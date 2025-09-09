package club.shengsheng.adapter_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/get/{key}")
    public String get(@PathVariable("key") String key) {
        String value = redisTemplate.opsForValue().get(key);
        if (value == null) {
            return "null";
        }
        return value;
    }

    @GetMapping("/put/{key}/{value}")
    public String put(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return "ok";
    }
}
