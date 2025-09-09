package club.shengsheng.adapter_demo.controller;

import io.etcd.jetcd.Client;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.keyvalue.core.KeyValueAdapter;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
@Configuration
@EnableConfigurationProperties(EtcdProperties.class)
public class EtcdConfiguration {

    @Bean
    public Client etcdClient(EtcdProperties properties) {
        return Client.builder().endpoints(properties.getUrl()).build();
    }


    @Bean
    public EtcdRedisValueOperations etcdRedisValueOperations(Client client) {
        return new EtcdRedisValueOperations(client);
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(EtcdRedisValueOperations operations) {
        return new EtcdRedisAdapter(operations);
    }
    
    @Bean
    public StringRedisTemplate stringRedisTemplate(EtcdRedisValueOperations operations) {
        return new EtcdRedisAdapter(operations);
    }

    @Bean
    public RedisKeyValueAdapter redisKeyValueAdapter() {
        return new VoidRedisKeyValueAdapter();
    }
    

}
