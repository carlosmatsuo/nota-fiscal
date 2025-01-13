FROM openjdk:17-jdk-alpine
COPY target/nota-fiscal-0.0.1-SNAPSHOT.jar nota-fiscal.jar
ENTRYPOINT ["java", "-jar", "/nota-fiscal.jar"]
