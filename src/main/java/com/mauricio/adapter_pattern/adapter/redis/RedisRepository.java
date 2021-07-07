package com.mauricio.adapter_pattern.adapter.redis;

import com.mauricio.adapter_pattern.domain.cache.CacheRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RedisRepository implements CacheRepository {

    @Override
    public Map<String, String> getUserCategories() {

        //Simulate a query to redis

        Map<String, String> userTypes = new HashMap<>();
        userTypes.put("1", "Developer");
        userTypes.put("2", "QA");
        return userTypes;
    }
}
