FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN mkdir -p /data
RUN mkdir -p /data/logs
RUN mkdir -p /data/tomcat

RUN mkdir -p /data/appdatas/cat
RUN mkdir -p /data/applogs/cat
RUN chmod 777 /data/ -R
COPY ./client.xml /data/appdatas/cat/client.xml

COPY ./labs-spring-cloud-service-user.jar /data/labs-spring-cloud-service-user.jar
ENTRYPOINT ["java","-jar","/data/labs-spring-cloud-service-user.jar"]