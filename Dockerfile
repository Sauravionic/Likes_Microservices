FROM eclipse-temurin:17-jdk-jammy
#FROM openjdk:17
EXPOSE 8080
ADD target/app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]