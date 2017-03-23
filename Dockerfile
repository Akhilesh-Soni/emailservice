FROM openjdk:8
COPY . /usr/src/emailservice
WORKDIR /usr/src/emailservice
ENTRYPOINT ["java", "-jar", "/usr/src/emailservice/email-service-1.0.0-SNAPSHOT.jar"]
CMD ["server", "config.yml"]
