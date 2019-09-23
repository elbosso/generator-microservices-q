#Build stage
FROM maven:3.6.1-jdk-11 AS build-env

ADD . /generator-microservices-q

WORKDIR generator-microservices-q

RUN mvn -U compile package

# Run it
FROM openjdk:11

COPY --from=build-env /generator-microservices-q/target/* /app/
COPY --from=build-env /generator-microservices-q/target/lib/* /app/lib/

EXPOSE 8080

CMD ["java", "-Djava.awt.headless=true", "-jar", "/app/generator-microservices-q-1.0.0-SNAPSHOT-runner.jar"]