FROM openjdk:17

ENV DB_HOST=localhost
ENV DB_PORT=5432


COPY target/db-microservice-0.0.1-SNAPSHOT.jar /app/db-microservice.jar

CMD ["java", "-jar", "/app/db-microservice.jar"]
