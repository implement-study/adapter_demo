package tech.insight.etcd2redis.starter.etcd;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
@ConfigurationProperties(prefix = "shengsheng.etcd")
@Data
public class EtcdProperties {
    private String url;

}
