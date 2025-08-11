FROM eclipse-temurin:21-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/pizza_store_pos-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-XX:+UseContainerSupport","-XX:MaxRAMPercentage=75","-jar","/app.jar"]