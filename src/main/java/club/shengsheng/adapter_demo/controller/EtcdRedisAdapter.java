package club.shengsheng.adapter_demo.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class EtcdRedisAdapter extends StringRedisTemplate {

    private final EtcdRedisValueOperations etcdRedisValueOperations;

    public EtcdRedisAdapter(EtcdRedisValueOperations etcdRedisValueOperations) {
        this.etcdRedisValueOperations = etcdRedisValueOperations;
    }

    @Override
    public ValueOperations<String, String> opsForValue() {
        return etcdRedisValueOperations;
    }

    @Override
    public void afterPropertiesSet() {
        
    }
}
