FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN mkdir -p /data
RUN mkdir -p /data/logs
RUN mkdir -p /data/tomcat
COPY ./labs-spring-cloud-admin-service-user.jar /data/labs-spring-cloud-admin-service-user.jar
ENTRYPOINT ["java","-jar","/data/labs-spring-cloud-admin-service-user.jar"]