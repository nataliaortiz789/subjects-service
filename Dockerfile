FROM eclipse-temurin:17-jdk-focal

COPY docs/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8091