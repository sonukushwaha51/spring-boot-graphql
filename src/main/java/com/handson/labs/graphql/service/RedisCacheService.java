package com.handson.labs.graphql.service;

import java.util.ArrayList;
import java.util.List;

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

    private final Class<T> typeParameterClass;

    @Value("${spring.redis.ttl}")
    private Long ttl;

    public RedisCacheService(RedisTemplate<String, Object> redisTemplate, LibraryCache libraryCache, Class<T> typeParameterClass) {
        this.redisTemplate = redisTemplate;
        this.libraryCache = libraryCache;
        this.typeParameterClass = typeParameterClass;
    }

    public List<T> getfromCacheOrClientCall(List<Integer> keysList) {
        List<T> fetchedResult = new ArrayList<>();
        List<Integer> fetchResultsFromClientKeys = new ArrayList<>();
        for (Integer key : keysList) {
            log.info("Redis value serializer class : {}", redisTemplate.getValueSerializer().getClass().getName());
            T cachedValue = typeParameterClass.cast(redisTemplate.opsForValue().get(generateKey(libraryCache, key)));
            if (cachedValue != null) {
                log.info("Cache hit for key : {} for Object: {}", key, getClass().getSimpleName().replace("Service", ""));
                fetchedResult.add(cachedValue);
            } else {
                fetchResultsFromClientKeys.add(key);
            }
        }

        // Fetch from client for missing keys
        List<T> clientResultList = getAllFromClient(fetchResultsFromClientKeys);

        // Store fetched values in cache
        storeFetchedValuesInCache(fetchResultsFromClientKeys, clientResultList);

        fetchedResult.addAll(clientResultList);
        return fetchedResult;
    }

    public String generateKey(LibraryCache libraryCache, Integer id) {
        return libraryCache.getCacheName() + "_" + id;
    }

    protected void storeFetchedValuesInCache(List<Integer> keys, List<T> values) {
        for (int key = 0; key < keys.size(); key++) {
            log.info("Redis value serializer class : {}", redisTemplate.getValueSerializer().getClass().getName());
            redisTemplate.opsForValue().set(generateKey(libraryCache, keys.get(key)), values.get(key), ttl);
        }
    }

    public T getFromCacheOrClientCall(Integer id) {
        T cachedValue = typeParameterClass.cast(redisTemplate.opsForValue().get(generateKey(libraryCache, id)));
        if (cachedValue != null) {
            log.info("Cache hit for key : {} for Object: {}", id, getClass().getSimpleName().replace("Service", ""));
            return cachedValue;
        } else {
            List<Integer> ids = new ArrayList<>();
            ids.add(id);
            List<T> clientResultList = getAllFromClient(ids);
            if (!clientResultList.isEmpty()) {
                redisTemplate.opsForValue().set(generateKey(libraryCache, id), clientResultList.get(0), ttl);
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

}
