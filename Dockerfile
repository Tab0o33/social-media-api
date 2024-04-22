FROM openjdk:17
VOLUME /tmp
EXPOSE 9000
ARG JAR_FILE=target/social-media-api-0.3.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]