# use ubuntu:18.04 base image
FROM openjdk:11

WORKDIR /project/spring-boot
# Install dependencies
COPY mvnw .
COPY .mvn .mvn

COPY pom.xml .

RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw package -DskipTests

CMD ["java","-jar","target/spring-boot-0.0.1-SNAPSHOT.jar"]