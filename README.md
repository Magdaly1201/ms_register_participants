###API - Participantes en las Meetups

#Readme

- Api para inscribirse en meetups.

###Tecnologias
- JAVA 11
- Spring Boot V2.6.6
- Spring doc open api ui V1.6.8
- MySql V8.0.24
- Flyway V5.2.4
- JPA

# url Swagger

http://localhost:8088/swagger-ui/index.html#/

## Docker composer DB
    version: '3.1'
    services:
      db:
        image: mysql
        restart: always
        environment:
          MYSQL_ROOT_PASSWORD:
          MYSQL_DATABASE: db_participants

        ports:
          - "3308:3306"


###End


## Docker composer Kafka and Zookeeper
    version: '3'
    services:

      zookeeper:
        image: wurstmeister/zookeeper
        container_name: zookeeper
        ports:
            - "2181:2181"
      kafka:
        image: wurstmeister/kafka
        container_name: kafka
        ports:
            - "9092:9092"
        environment:
            KAFKA_ADVERTISED_HOST_NAME: localhost
            KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181

###End