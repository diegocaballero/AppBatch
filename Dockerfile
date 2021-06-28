FROM openjdk:11-jre-slim

COPY target/App-0.0.1-SNAPSHOT.jar /App.jar

CMD ["java", "-jar", "/App.jar"]