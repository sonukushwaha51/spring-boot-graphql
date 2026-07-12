package com.handson.labs.graphql.service;

import com.handson.labs.graphql.entity.Author;
import com.handson.labs.graphql.repository.AuthorRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    AuthorRepository authorRepository;

    @Mock
    RedisTemplate<String, Object> redisTemplate;

    @InjectMocks
    AuthorService authorService;

    @ParameterizedTest
    @MethodSource("authorProvider")
    void testAuthorSave(Author author, int id) {
        when(authorRepository.findById(id))
                .thenReturn(Optional.of(author));

        Author result = authorService.getResultByPrimaryIdentifier(id);

        assertEquals(author, result);
    }

    static List<Arguments> authorProvider() {
        return List.of(
                Arguments.of(new Author(), 1)
        );
    }


}
