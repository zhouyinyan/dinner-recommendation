#!/usr/bin/env bash
## ---在travis上的操作----

# 编译打包
mvn clean package -Dmaven.test.skip=true -Dmaven.javadoc.skip=true

# 上传jar包
scp ./target/dinner.jar root@139.9.247.199:/opt/diner/dinner.jar.new
scp ./restart.sh root@139.9.247.199:/opt/diner

##----在部署服务器上的操作----
## 执行重启
ssh root@139.9.247.199 "bash /opt/diner/restart.sh"


