package com.handson.labs.graphql.entity.upsert.model;

import java.util.Date;
import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateResponse {
    private int status;
    private String message;

    @Builder.Default
    private Date timestamp = Date.from(Instant.now());
}
