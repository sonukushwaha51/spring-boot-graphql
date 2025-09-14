package com.handson.labs.graphql.service;

import com.handson.labs.graphql.configuration.LibraryCache;
import com.handson.labs.graphql.entity.User;
import com.handson.labs.graphql.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService extends RedisCacheService<User> {

    public UserService(RedisTemplate<String, Object> redisTemplate) {
        super(redisTemplate, LibraryCache.USERS, User.class);
    }

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(List<Integer> ids) {
        return (List<User>) userRepository.findAllById(ids);
    }

    @Override
    public User getResultByPrimaryIdentifier(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    protected List<User> getClientResultFromClient(List<Integer> ids) {
        log.info("Fetching users from DB for Ids : {}", ids);
        return getAllUsers(ids);
    }

    @Override
    protected Integer getId(User entity) {
        return entity.getId();
    }

}
