FROM gradle:8.6.0-jdk21 as gradle-build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src
RUN gradle build -x test

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=gradle-build ./home/gradle/src/build/libs/*.jar ./app.jar

ENV DISCOVERY_SERVER_PORT=8187
ENV DISCOVERY_SERVER_URL=discovery-inst
ENV CONFIG_SERVER_URL=cloudserver-inst

ENTRYPOINT ["java", "-jar", "app.jar"]
