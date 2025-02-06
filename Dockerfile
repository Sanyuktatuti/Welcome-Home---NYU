# Use an official Maven image to build the project
FROM maven:3.8.7-openjdk-17 AS build
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the application (this generates the JAR file)
RUN mvn clean package -DskipTests

# Use a lightweight Java image to run the application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the generated JAR file from the previous step
COPY --from=build /app/target/*.jar app.jar

# Expose the port Render requires
EXPOSE 10000

# Run the application
CMD ["java", "-jar", "app.jar", "--server.port=10000"]
