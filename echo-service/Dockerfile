FROM azul/zulu-openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY target/echo-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]