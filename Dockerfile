FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

COPY pom.xml /deploy/
COPY src /deploy/src/
WORKDIR /deploy/
RUN mvn package


FROM openjdk:8-alpine
COPY --from=MAVEN_BUILD /deploy/target/*.jar employees-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","employees-0.0.1-SNAPSHOT.jar"]

