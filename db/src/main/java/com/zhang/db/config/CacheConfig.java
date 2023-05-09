package com.zhang.db.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-04-13 9:59
 */
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager(){
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<CaffeineCache> caffeineCaches = new ArrayList<>();
        caffeineCaches.add(new CaffeineCache("users", Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).build()));
        caffeineCaches.add(new CaffeineCache("username", Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).build()));
        cacheManager.setCaches(caffeineCaches);
        return cacheManager;
    }
}
