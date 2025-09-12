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

    public List<T> getfromCacheOrClientCall(List<Integer> keysList) {
        Map<Integer, T> fetchedResult = new LinkedHashMap<>();
        List<Integer> fetchResultsFromClientKeys = new ArrayList<>();
        for (Integer key : keysList) {
            T cachedValue = readFromCache(key);
            if (cachedValue != null) {
                log.info("Cache hit for key : {}", generateKey(libraryCache, key));
                fetchedResult.put(key, cachedValue);
            } else {
                fetchResultsFromClientKeys.add(key);
            }
        }

        // Fetch from client for missing keys
        List<T> clientResultList = getAllFromClient(fetchResultsFromClientKeys);

        for (T entity : clientResultList) {
            Integer id = getId(entity);
            fetchedResult.put(id, entity);

            // Store fetched values in cache
            writeToCache(entity, id);
        }

        return fetchedResult.values().stream().toList();
    }

    public String generateKey(LibraryCache libraryCache, Integer id) {
        return libraryCache.getCacheName() + "_" + id;
    }

    protected void storeFetchedValuesInCache(List<Integer> keys, List<T> values) {
        for (int key = 0; key < keys.size(); key++) {
            writeToCache(values.get(key), keys.get(key));
        }
    }

    public T getFromCacheOrClientCall(Integer id) {
        T cachedValue = readFromCache(id);
        if (cachedValue != null) {
            log.info("Cache hit for key : {} for Object: {}", id, getClass().getSimpleName().replace("Service", ""));
            return cachedValue;
        } else {
            List<Integer> ids = new ArrayList<>();
            ids.add(id);
            List<T> clientResultList = getAllFromClient(ids);
            if (!clientResultList.isEmpty()) {
                writeToCache(clientResultList.get(0), id);
                return clientResultList.get(0);
            } else {
                return null;
            }
        }
    }

    public List<T> getResultByParentIds(List<Integer> ids, String parentFieldName) {
        return new ArrayList<>();
    }

    protected abstract List<T> getAllFromClient(List<Integer> ids);

    private T readFromCache(Integer id) {
        T cachedValue = typeClass.cast(redisTemplate.opsForValue().get(generateKey(libraryCache, id)));
        if (cachedValue != null) {
            log.info("Cache hit for key : {}", generateKey(libraryCache, id));
        }
        return cachedValue;
    }

    private void writeToCache(T value, Integer id) {
        log.info("Writing to cache for key : {}, value: {}", getId(value), value);
        redisTemplate.opsForValue().set(generateKey(libraryCache, id), value, ttl);
    }

    protected abstract Integer getId(T entity);

}
