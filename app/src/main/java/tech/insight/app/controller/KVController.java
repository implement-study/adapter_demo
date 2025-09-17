package tech.insight.app.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
@RestController
@RequestMapping("/redis")
public class KVController {

    private final RedisTemplate<String, String> redisTemplate;

    public KVController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/get/{key}")
    public String getValue(@PathVariable("key") String key) {
        String value = redisTemplate.opsForValue().get(key);
        if (value == null) {
            return "null";
        }
        return value;
    }

    @PutMapping("/put/{key}/{value}")
    public String putValue(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return "ok";
    }

}
