FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY . .

WORKDIR /app/ai-career-assistant

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17

WORKDIR /app

COPY --from=build /app/ai-career-assistant/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]