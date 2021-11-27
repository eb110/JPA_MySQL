FROM openjdk:11.0.13-jdk-buster
ADD target/JPA.MySQL.jar .
EXPOSE 8000
CMD java -jar JPA.MySQL.jar