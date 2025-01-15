FROM openjdk:22-jdk-slim AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY mvnw* .
COPY .mvn .mvn

RUN ./mvnw clean package -DskipTests


FROM openjdk:22-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.war app.war
# COPY  ./target/*.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]