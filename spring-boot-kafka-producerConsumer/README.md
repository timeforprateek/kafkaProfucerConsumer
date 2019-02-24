# Spring Boot with Kafka Consumer Example

This Project covers how to use Spring Boot with Spring Kafka to Consume JSON/String message from Kafka topics

## get the kafka_2.11-2.1.0.tgz from https://kafka.apache.org/quickstart

## Start Zookeeper
- `bin/zookeeper-server-start.sh config/zookeeper.properties`

## Start Kafka Server
- `bin/kafka-server-start.sh config/server.properties`

## Create Kafka Topic
- `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Kafka_Example`
- `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Kafka_Example_json`

## Publish to the Kafka Topic via Console
- `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic Kafka_Example`
- `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic Kafka_Example_json`


#rest service path

http://localhost:8081/kafka/publish/anyname

http://localhost:8081/kafka/subscribe/