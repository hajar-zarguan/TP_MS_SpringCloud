FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/Billing-service-0.0.1-SNAPSHOT-plain.jar /Billing-service.jar
CMD ["java","-jar","Billing-service.jar","--spring.profiles.active=prod"]
EXPOSE 8089
