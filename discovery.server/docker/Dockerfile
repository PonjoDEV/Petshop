FROM gradle:8.6.0-jdk21 as gradle-build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src
RUN gradle build


FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=gradle-build ./home/gradle/src/build/libs/*.jar ./app.jar
EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]
