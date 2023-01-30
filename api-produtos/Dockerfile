FROM adoptopenjdk/openjdk11
VOLUME /tmp
ARG JAR_FILE=target/api-produtos-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]