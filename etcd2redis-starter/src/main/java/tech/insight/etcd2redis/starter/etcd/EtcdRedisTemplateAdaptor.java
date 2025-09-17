package tech.insight.etcd2redis.starter.etcd;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class EtcdRedisTemplateAdaptor extends RedisTemplate<String, String> {

    private final EtcdValueOperations operations;

    public EtcdRedisTemplateAdaptor(EtcdValueOperations operations) {
        this.operations = operations;
    }

    @Override
    public ValueOperations<String, String> opsForValue() {
        return operations;
    }

    @Override
    public void afterPropertiesSet() {

    }
}
