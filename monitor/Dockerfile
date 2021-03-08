FROM java:8u111-jre-alpine
COPY target/monitor-final.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]