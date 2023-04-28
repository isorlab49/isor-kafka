package com.isor.example.kafka.cache.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@RedisHash("dictionary")
public class DictionaryItem {

    @Id
    public String id;
    private String value;
}
