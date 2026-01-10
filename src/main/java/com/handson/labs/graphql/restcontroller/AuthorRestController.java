package com.handson.labs.graphql.restcontroller;

import com.handson.labs.graphql.configuration.LibraryCache;
import com.handson.labs.graphql.service.AuthorService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/authors")
public class AuthorRestController {

    private final LibraryCache booksByAuthorIdCache = LibraryCache.BOOKS_BY_AUTHOR_ID;

    private final AuthorService authorService;

    @GetMapping("/get-authors")
    // Should use generic return type when using circuit breaker
    @CircuitBreaker(name = "authorService", fallbackMethod = "authorsFallback")
    @RateLimiter(name = "authorService", fallbackMethod = "rateLimitFallback")
    public ResponseEntity<?> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/get-author/{id}")
    @CircuitBreaker(name = "authorService", fallbackMethod = "authorsFallback")
    @RateLimiter(name = "authorService", fallbackMethod = "rateLimitFallback")
    public ResponseEntity<?> getAllAuthorById(@PathVariable("id") int id) {
        return new ResponseEntity<>(authorService.getResultByPrimaryIdentifier(id), HttpStatus.OK);
    }

    // Must pass Exception as parameter in fallback
    public ResponseEntity<String> rateLimitFallback(RequestNotPermitted exception) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests - slow down!");
    }

    // Must pass Exception as parameter in fallback
    public ResponseEntity<?> authorsFallback(Exception exception) {
        log.error("Exception while fetching data: {}", exception);
        return new ResponseEntity<>("Service Unavailable", HttpStatus.SERVICE_UNAVAILABLE);
    }


}
