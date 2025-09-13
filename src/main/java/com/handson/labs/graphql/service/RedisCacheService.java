package com.handson.labs.graphql.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.handson.labs.graphql.configuration.LibraryCache;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public abstract class RedisCacheService<T> {

    private final RedisTemplate<String, Object> redisTemplate;

    private final LibraryCache libraryCache;

    private final Class<T> typeClass;

    @Value("${spring.redis.ttl}")
    private Long ttl;

    public RedisCacheService(RedisTemplate<String, Object> redisTemplate, LibraryCache libraryCache, Class<T> typeClass) {
        this.redisTemplate = redisTemplate;
        this.libraryCache = libraryCache;
        this.typeClass = typeClass;
    }

    public List<T> getClientResults(List<Integer> keysList) {
        Map<Integer, T> fetchedResult = new LinkedHashMap<>();
        List<Integer> fetchResultsFromClientKeys = new ArrayList<>();
        for (Integer key : keysList) {
            T cachedValue = readFromCache(key);
            if (cachedValue != null) {
                fetchedResult.put(key, cachedValue);
            } else {
                fetchResultsFromClientKeys.add(key);
            }
        }

        // Fetch from client for missing keys
        List<T> clientResultList = getClientResultFromClient(fetchResultsFromClientKeys);

        for (T entity : clientResultList) {
            int id = getId(entity);
            fetchedResult.put(id, entity);

            // Store fetched values in cache
            if (entity != null) {
                writeToCache(entity, id);
            }   
        }

        return fetchedResult.values().stream().toList();
    }

    public String generateKey(LibraryCache libraryCache, Integer id) {
        return libraryCache.getCacheName() + "_" + id;
    }

    public T getSingleClientResult(Integer id) {
        T cachedValue = readFromCache(id);
        if (cachedValue != null) {
            return cachedValue;
        } else {
            T clientResult = getResultByPrimaryIdentifier(id);
            if (clientResult != null) {
                writeToCache(clientResult, id);
                return clientResult;
            }
        }
        return null;
    }

    private T readFromCache(Integer id) {
        T cachedValue = typeClass.cast(redisTemplate.opsForHash().get(libraryCache.getCacheName(), generateKey(libraryCache, id)));
        if (cachedValue != null) {
            log.info("Cache hit for key : {}", generateKey(libraryCache, id));
        }
        return cachedValue;
    }

    protected void writeToCache(T value, Integer id) {
        log.info("Writing to cache for key : {}, value: {}", generateKey(libraryCache, id), value);
        redisTemplate.opsForHash().put(libraryCache.getCacheName(), generateKey(libraryCache, id), value);
    }

    protected void writeToCache(LibraryCache cache, T value, Integer id) {
        log.info("Writing to cache for key : {}, value: {}", generateKey(cache, id), value);
        redisTemplate.opsForHash().put(cache.getCacheName(), generateKey(cache, id), value);
    }

    protected void writeToCache(List<T> values) {
        for (T t : values) {
            writeToCache(t, getId(t));
        }
    }

    @SuppressWarnings("unchecked")
    protected <T> List<T> readListFromCache(LibraryCache cache, int id, Class<T> ChildNodeClass) {
        return (List<T>) redisTemplate.opsForHash().get(cache.getCacheName(), generateKey(cache, id));
    }

    protected <T> void writeListToCache(LibraryCache cache, int id, List<T> entityList) {
        log.info("Writing list to cache for id: {}, value: {}", generateKey(cache, id), entityList);
        redisTemplate.opsForHash().put(cache.getCacheName(), generateKey(cache, id), entityList);
    }

    public List<T> getResultByParentIds(LibraryCache cache, List<Integer> ids, Class<T> class1) {
        log.info("Ids in getResultByParentIds: {}", ids);
        for (int id : ids) {
            List<T> results = readListFromCache(cache, id, class1);
            if (results != null && !results.isEmpty()) {
                return results;
            } else {
                results = getResultListFromParentIdFromClient(List.of(id));
                log.info("Results: {} for id: {}", results, id);
                if (results != null && !results.isEmpty()) {
                    writeListToCache(cache, id, results);
                    return results;
                }
            }
        }
        return new ArrayList<>();
    }

    protected List<T> getResultListFromParentIdFromClient(List<Integer> ids) {
        return new ArrayList<>();
    }


    protected abstract List<T> getClientResultFromClient(List<Integer> ids);

    protected abstract Integer getId(T entity);

    protected abstract T getResultByPrimaryIdentifier(int id);

}
