package club.shengsheng.adapter_demo.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
@ConfigurationProperties(prefix = "shengsheng.etcd")
public class EtcdProperties {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
