# 适配器模式Demo

这是一个适配器模式相关代码 

[相关B站视频](https://www.bilibili.com/video/BV1Z4WVzyE8T/)


## 视频中的docker命令：

启动 redis  

docker run --name redis -p 6379:6379 -it redis:7.4.1

启动 etcd

docker run -d \
--name etcd-standalone \
-p 2379:2379 \
-p 2380:2380 \
--env ALLOW_NONE_AUTHENTICATION=yes \
gcr.io/etcd-development/etcd:v3.6.4 \
/usr/local/bin/etcd \
--name etcd0 \
--listen-client-urls http://0.0.0.0:2379 \
--advertise-client-urls http://0.0.0.0:2379 \
--listen-peer-urls http://0.0.0.0:2380 \
--initial-advertise-peer-urls http://0.0.0.0:2380 \
--initial-cluster etcd0=http://0.0.0.0:2380 \
--initial-cluster-token etcd-cluster-1 \
--initial-cluster-state new
