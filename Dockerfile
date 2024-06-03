FROM maven:3.9.7-amazoncorretto-17 AS stage1
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM amazoncorretto:17
COPY --from=stage1 /app/target/secure-login-backend-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "/app.jar"]