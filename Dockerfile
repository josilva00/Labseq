# Use an official Java runtime parent image
FROM openjdk:17-jdk-alpine

# Information about the maintainer
LABEL maintainer="jose.silva.tt15@gmail.com"

# Set the location in the container where the app will be placed
WORKDIR /app

# Copy the jar file into our container
COPY ./target/LabSeq-0.0.1-SNAPSHOT.jar /app

# Set the startup command to run your binary
ENTRYPOINT ["java", "-jar", "/app/LabSeq-0.0.1-SNAPSHOT.jar"]