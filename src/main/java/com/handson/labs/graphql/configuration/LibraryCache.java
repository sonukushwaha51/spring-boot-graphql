package com.handson.labs.graphql.configuration;

public enum LibraryCache {

    ORDERS("orders"),
    USERS("users"),
    BOOKS("books"),
    AUTHORS("authors"),
    PUBLISHERS("publishers"),
    CATEGORIES("categories"),
    REVIEWS("reviews");

    private final String cacheName;

    LibraryCache(String cacheName) {
        this.cacheName = cacheName;
    }
    public String getCacheName() {
        return cacheName;
    }
}
