package io.github.touchsun.tstudy.core.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Generic Redis utility class
 * Provides static methods to interact with Redis without type casting
 *
 * @author lee
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static RedisTemplate<String, Object> staticRedisTemplate;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init() {
        staticRedisTemplate = redisTemplate;
    }

    /**
     * Set a value in Redis
     *
     * @param key   the key
     * @param value the value
     * @param <T>   the type of the value
     */
    public static <T> void setValue(String key, T value) {
        ValueOperations<String, Object> ops = staticRedisTemplate.opsForValue();
        try {
            String jsonValue = objectMapper.writeValueAsString(value);
            ops.set(key, jsonValue);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Could not serialize value to JSON", e);
        }
    }

    /**
     * Set a value in Redis with an expiration time
     *
     * @param key      the key
     * @param value    the value
     * @param timeout  the expiration time
     * @param timeUnit the time unit of the expiration time
     * @param <T>      the type of the value
     */
    public static <T> void setValueWithExpire(String key, T value, long timeout, TimeUnit timeUnit) {
        ValueOperations<String, Object> ops = staticRedisTemplate.opsForValue();
        try {
            String jsonValue = objectMapper.writeValueAsString(value);
            ops.set(key, jsonValue, timeout, timeUnit);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Could not serialize value to JSON", e);
        }
    }

    /**
     * Get a value from Redis
     *
     * @param key   the key
     * @param clazz the type of the value
     * @param <T>   the type of the value
     * @return the value
     */
    public static <T> T getValue(String key, Class<T> clazz) {
        ValueOperations<String, Object> ops = staticRedisTemplate.opsForValue();
        String jsonValue = (String) ops.get(key);
        if (jsonValue == null) {
            return null;
        }
        try {
            return objectMapper.readValue(jsonValue, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Could not deserialize value from JSON", e);
        }
    }

    /**
     * Delete a value from Redis
     *
     * @param key the key
     */
    public static void deleteValue(String key) {
        staticRedisTemplate.delete(key);
    }

    /**
     * Check if a key exists in Redis
     *
     * @param key the key
     * @return true if the key exists, false otherwise
     */
    public static boolean hasKey(String key) {
        return Boolean.TRUE.equals(staticRedisTemplate.hasKey(key));
    }

    /**
     * Set the expiration time for a key
     *
     * @param key     the key
     * @param timeout the expiration time
     * @param unit    the time unit of the expiration time
     * @return true if the expiration time was set, false otherwise
     */
    public static boolean expire(String key, long timeout, TimeUnit unit) {
        return Boolean.TRUE.equals(staticRedisTemplate.expire(key, timeout, unit));
    }

    /**
     * Get the remaining expiration time of a key
     *
     * @param key  the key
     * @param unit the time unit of the expiration time
     * @return the remaining expiration time, or -1 if the key does not have an expiration time
     */
    public static long getExpire(String key, TimeUnit unit) {
        return staticRedisTemplate.getExpire(key, unit);
    }
}
