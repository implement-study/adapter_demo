package club.shengsheng.adapter_demo.controller;

import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.Client;
import io.etcd.jetcd.kv.GetResponse;
import io.etcd.jetcd.kv.PutResponse;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class EtcdRedisValueOperations implements ValueOperations<String, String> {

    private final Client client;

    public EtcdRedisValueOperations(Client client) {
        this.client = client;
    }

    @Override
    public void set(String key, String value) {
        ByteSequence tecdKey = ByteSequence.from(key, StandardCharsets.UTF_8);
        ByteSequence tecdValue = ByteSequence.from(value, StandardCharsets.UTF_8);
        CompletableFuture<PutResponse> putFuture = client.getKVClient().put(tecdKey, tecdValue);
        try {
            putFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public String get(Object key) {
        CompletableFuture<GetResponse> future = client.getKVClient().get(ByteSequence.from(key.toString(),
            StandardCharsets.UTF_8));
        try {
            GetResponse response = future.get();
            if (response.getCount() == 0) {
                return null;
            }
            return response.getKvs().get(0).getValue().toString(StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAndDelete(String key) {
        return "";
    }

    @Override
    public String getAndExpire(String key, long timeout, TimeUnit unit) {
        return "";
    }

    @Override
    public String getAndExpire(String key, Duration timeout) {
        return "";
    }

    @Override
    public String getAndPersist(String key) {
        return "";
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit unit) {

    }

    @Override
    public Boolean setIfAbsent(String key, String value) {
        return null;
    }

    @Override
    public Boolean setIfAbsent(String key, String value, long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public Boolean setIfPresent(String key, String value) {
        return null;
    }

    @Override
    public Boolean setIfPresent(String key, String value, long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public void multiSet(Map<? extends String, ? extends String> map) {

    }

    @Override
    public Boolean multiSetIfAbsent(Map<? extends String, ? extends String> map) {
        return null;
    }


    @Override
    public String getAndSet(String key, String value) {
        return "";
    }

    @Override
    public List<String> multiGet(Collection<String> keys) {
        return List.of();
    }

    @Override
    public Long increment(String key) {
        return 0L;
    }

    @Override
    public Long increment(String key, long delta) {
        return 0L;
    }

    @Override
    public Double increment(String key, double delta) {
        return 0.0;
    }

    @Override
    public Long decrement(String key) {
        return 0L;
    }

    @Override
    public Long decrement(String key, long delta) {
        return 0L;
    }

    @Override
    public Integer append(String key, String value) {
        return 0;
    }

    @Override
    public String get(String key, long start, long end) {
        return "";
    }

    @Override
    public void set(String key, String value, long offset) {

    }

    @Override
    public Long size(String key) {
        return 0L;
    }

    @Override
    public Boolean setBit(String key, long offset, boolean value) {
        return null;
    }

    @Override
    public Boolean getBit(String key, long offset) {
        return null;
    }

    @Override
    public List<Long> bitField(String key, BitFieldSubCommands subCommands) {
        return List.of();
    }

    @Override
    public RedisOperations<String, String> getOperations() {
        return null;
    }
}
