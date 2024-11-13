FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
EXPOSE 9292
COPY target/circuit-breaker.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]