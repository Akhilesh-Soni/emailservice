# EmailService


mvn archetype:generate -DgroupId=com.retailio.email -DartifactId=email-service -Dversion=1.0.0-SNAPSHOT -Dpackage=com.retailio.email -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DinteractiveMode=true

How to start the EmailService application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/email-service-1.0.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
