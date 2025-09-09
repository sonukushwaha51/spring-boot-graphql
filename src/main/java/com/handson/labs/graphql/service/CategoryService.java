package com.handson.labs.graphql.service;

import com.handson.labs.graphql.configuration.LibraryCache;
import com.handson.labs.graphql.entity.Category;
import com.handson.labs.graphql.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryService extends RedisCacheService<Category> {

    public CategoryService(RedisTemplate<String, Category> categoryRedisTemplate) {
        super(categoryRedisTemplate, LibraryCache.CATEGORIES);
    }

    @Autowired
    private CategoryRepository categoryRepository;

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
    
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public List<Category> getAllCategories(List<Integer> ids) {
        return (List<Category>) categoryRepository.findAllById(ids);
    }

    @Override
    protected List<Category> getAllFromClient(List<Integer> ids) {
        log.info("Fetching categories from DB for Ids : {}", ids);
        return getAllCategories(ids);
    }

    @Override
    protected Integer getId(Category entity) {
        return entity.getId();  
    }

}
