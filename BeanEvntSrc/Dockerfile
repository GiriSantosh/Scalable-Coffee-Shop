# Use Eclipse Temurin as the base image with Java 17
FROM eclipse-temurin:17

# Define build arguments
ARG SPRING_DATASOURCE_URL
ARG SPRING_DATASOURCE_USERNAME
ARG SPRING_DATASOURCE_PASSWORD
ARG JAVA_OPTS

# Set environment variables
ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL}
ENV SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME}
ENV SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}
ENV JAVA_OPTS=${JAVA_OPTS}

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY ./build/libs/*.jar beanservice.jar

# Expose the port your application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar beanservice.jar"]