# Use the official OpenJDK 17 image from Docker Hub
FROM public.ecr.aws/amazoncorretto/amazoncorretto:17

# Set working directory inside the container
WORKDIR /app

# Copy the actual built jar from target folder
COPY target/faculty-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the Spring Boot app port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
