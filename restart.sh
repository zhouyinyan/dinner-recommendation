#!/usr/bin/env bash
## 停止服务
pkill -f java

## 重命名jar包
mv -f /opt/diner/dinner.jar /opt/diner/dinner.jar.old
mv -f /opt/diner/dinner.jar.new /opt/diner/dinner.jar
chmod +x /opt/diner/dinner.jar

## 启动服务
nohup java -jar /opt/diner/dinner.jar > appstart.log 2>&1 &


