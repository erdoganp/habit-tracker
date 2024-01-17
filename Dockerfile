FROM maven:3-amazoncorretto-17

WORKDIR /usr/src/app
COPY . .

RUN mvn clean package

FROM amazoncorretto:17-alpine3.17-jdk
COPY --from=build /usr/src/app/target/demo*.jar /app.jar
ENTRYPOINT ["java","-jar","app.jar"]