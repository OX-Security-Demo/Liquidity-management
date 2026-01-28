FROM adoptopenjdk/openjdk8:jdk8u292-b10
MAINTAINER Abhisek Datta <abhisek@appsecco.com>

RUN apt-get update
RUN apt-get install -y default-mysql-client
RUN apt-get install -y maven

WORKDIR /app
COPY pom.xml pom.xml
COPY rest.java src/main/java/net/kvak/log4shell/RESTController.java

RUN mvn clean package -DskipTests

CMD ["java", "-jar", "target/log4shell-1.0.0.jar"]
