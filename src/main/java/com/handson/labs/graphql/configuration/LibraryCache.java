package com.handson.labs.graphql.configuration;

public enum LibraryCache {

    ORDERS("orders"),
    USERS("users"),
    BOOKS("books"),
    AUTHORS("authors"),
    PUBLISHERS("publishers"),
    CATEGORIES("categories"),
    REVIEWS("reviews"),
    BOOKS_BY_AUTHOR_ID("books_by_author_id"),
    REVIEWS_BY_USER_ID("reviews_by_user_id");

    private final String cacheName;

    LibraryCache(String cacheName) {
        this.cacheName = cacheName;
    }
    public String getCacheName() {
        return cacheName;
    }
}
