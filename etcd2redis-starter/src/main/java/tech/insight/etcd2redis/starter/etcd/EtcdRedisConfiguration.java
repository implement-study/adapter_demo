package tech.insight.etcd2redis.starter.etcd;

import io.etcd.jetcd.Client;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
@Configuration
@AutoConfigureBefore(RedisAutoConfiguration.class)
@EnableConfigurationProperties(EtcdProperties.class)
public class EtcdRedisConfiguration {


    @Bean
    public Client etcdClient(EtcdProperties properties) {
        return Client.builder().endpoints(properties.getUrl()).build();
    }

    @Bean
    public EtcdValueOperations etcdValueOperations(Client client) {
        return new EtcdValueOperations(client);
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(EtcdValueOperations operations) {
        return new EtcdRedisTemplateAdaptor(operations);
    }

    @Bean
    public RedisKeyValueAdapter redisKeyValueAdapter() {
        return new VoidRedisKeyValueAdapter();
    }
}
