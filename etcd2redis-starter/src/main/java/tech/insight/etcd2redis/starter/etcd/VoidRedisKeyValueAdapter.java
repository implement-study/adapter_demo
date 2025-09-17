package tech.insight.etcd2redis.starter.etcd;

import org.springframework.data.redis.core.RedisKeyValueAdapter;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class VoidRedisKeyValueAdapter extends RedisKeyValueAdapter {

    @Override
    public void afterPropertiesSet() {
       
    }
}
