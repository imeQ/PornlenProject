Pornlen
==========================

Pornlen project based on Java8, Groovy, Gradle, SpringBoot, SpringLoader, Jetty, Spring web security, Jsf, Primefaces, FlyWay, Hibernate and MySQL

To run the project for the first time:

1. Execute FlyWay migrations:
gradle flywayMigrate

2. Execute gradle task which starts the server:
gradle bootRestart

3. To stop the server:
gradle bootStop (just intellijs stop button does not work and so you are able to use debugging features)

Features so far
===============

- spring and java might be mixed (only one main/test src folder for both) -> enjoy groovy coding in src/main/java

- websecurity with spring

- example jsf/primefaces view on localhost:port/index.jsf

- jpa/hibernate on a MySQL db (open session in entitymanager pattern used)

- entity auditing

- h2console is enabled (localhost:port/h2console)

- example rest endpoints (spring driven, localhost:port/rest/...)

- amqp messaging (rabbit mq) //By default commented out

- use of Spring Profiles

- tests are in place, using jmockit lib and also using spring mockmvc to test the rest endpoints


Things to come:
===============

- open entitymanager in conversation fo long running business processes

- logging with log4j2 or logback

- flexible search/paging engine

- environment specific config

- configuration reloading mechanism (maybe via JMX)

- JMS endpoints