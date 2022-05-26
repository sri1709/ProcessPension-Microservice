FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8400
ADD target/*.jar process-pension-service.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /process-pension-service.jar" ]