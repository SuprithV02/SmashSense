
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/racket-service-0.0.1-SNAPSHOT.jar racket-service.jar
EXPOSE 8082
CMD ["java", "-jar", "racket-service.jar"]