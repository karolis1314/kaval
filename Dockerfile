FROM openjdk:17
COPY target/kaval-0.0.1-SNAPSHOT.jar /kaval.jar
CMD ["java", "-jar", "/kaval.jar"]