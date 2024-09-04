# Use Eclipse Temurin as the base image with Java 17
FROM eclipse-temurin:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY ./build/libs/*.jar orderservice.jar

# Expose the port your application runs on
EXPOSE 8090

# Run the JAR file
ENTRYPOINT ["java", "-jar", "orderservice.jar"]