# Mvn Build
FROM maven:3.8.6-eclipse-temurin-17-focal AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package > /home/app/build.log 2>&1

# Check Maven build output
RUN cat /home/app/build.log

# Jar Package
FROM eclipse-temurin:17-jre-focal
COPY --from=build /home/app/target/wageapp-0.0.1-SNAPSHOT.jar /usr/local/lib/wageapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/wageapp.jar"]
