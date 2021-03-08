FROM java:8u111-jre-alpine
COPY target/client-final.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]