FROM gradle:8.6.0-jdk21 as gradle-build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src
RUN gradle build

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=gradle-build ./home/gradle/src/build/libs/*.jar ./app.jar

COPY --from=gradle-build ./home/gradle/src/server/client.yml ./config/server/client.yml
COPY --from=gradle-build ./home/gradle/src/server/animal.yml ./config/server/animal.yml

ENV DISCOVERY_SERVER_PORT=8187
ENV DISCOVERY_SERVER_URL=discovery-inst
ENV CONFIG_SERVER_FILE=/app/config/server

ENTRYPOINT ["java", "-jar", "app.jar"]