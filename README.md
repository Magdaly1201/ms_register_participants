###API - Participantes en las Meetups

#Readme

- Api para inscribirse en meetups.

###Tecnologias
- JAVA 11
- Spring Boot V2.7.0
- Spring doc open api ui V1.6.8
- MySql V8.0.24
- Flyway V5.2.4
- JPA

# url Swagger

http://localhost:8080/swagger-ui/index.html#/

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
          - "3308:3309"


###End