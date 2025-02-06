# Step 1: Build the application using Maven
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Build the application (this generates the JAR file)
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight Java image to run the app
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the generated JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port Render requires
EXPOSE 10000

# Run the application
CMD ["java", "-jar", "app.jar", "--server.port=10000"]
