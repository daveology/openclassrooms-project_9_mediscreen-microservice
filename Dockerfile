FROM openjdk:8-jdk-alpine

COPY build/libs/openclassrooms_9th-project_mediscreen-microservice-0.1.0-SNAPSHOT.jar /Mediscreen.jar

CMD ["java", "-jar", "/Mediscreen.jar"]
