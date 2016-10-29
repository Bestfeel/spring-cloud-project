###  kafka  download  
http://kafka.apache.org/downloads.html

#### 启动ZK 

```
./bin/zookeeper-server-start.sh config/zookeeper.properties

```
#### 启动服务 

```
./bin/kafka-server-start.sh config/server.properties

```
#### 创建主题 

```
./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

```
#### 查看主题 

```
./bin/kafka-topics.sh --list --zookeeper localhost:2181

```
####   查看 主题相关信息

```
./bin/kafka-topics.sh --describe --zookeeper localhost:2181 --topic test

```
### 命令行客户端操作


#### 创建生产者 

```
./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test 

```

### 创建消费者 

```
./bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic test --from-beginning

```