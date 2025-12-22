FROM eclipse-temurin:jdk17 as builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

# Copy the source code (this layer is invalidated on code changes)
COPY src ./src

RUN mvn clean package -DskipTests

COPY target/*.jar graphql.jar

# Step 4: Expose the port (Cloud Run defaults to 8080)
EXPOSE 8080

# Step 5: Run the JAR
# We use -Dserver.port to ensure Spring matches the port Cloud Run expects
ENTRYPOINT ["java", "-Dserver.port=8080", "-jar", "graphql.jar"]