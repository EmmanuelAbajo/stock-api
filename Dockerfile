FROM openjdk:11
WORKDIR /
ADD target/stockservice.jar //
EXPOSE 8080
ENTRYPOINT [ "java", "-Dspring.profiles.active=default", "-jar", "/stockservice.jar"]
