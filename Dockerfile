# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jre-alpine

#ARG JAR_FILE=target/*.jar

#RUN echo "Oh dang look at that $JAR_FILE"

# copy application JAR (with libraries inside)
COPY target/learn-spring-0.0.1-SNAPSHOT.jar /learnspring.jar

# specify default command
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/learnspring.jar"]

#ENTRYPOINT ["java","-jar","/learnspring.jar"]