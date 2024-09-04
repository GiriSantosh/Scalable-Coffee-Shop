# Use Eclipse Temurin as the base image with Java 17
FROM eclipse-temurin:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY ./build/libs/*.jar beanservice.jar

# Expose the port your application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "beanservice.jar"]