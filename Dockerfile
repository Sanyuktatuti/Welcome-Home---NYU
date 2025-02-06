# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose the port Render will use
EXPOSE 10000

# Run the application
CMD ["java", "-jar", "app.jar", "--server.port=10000"]
