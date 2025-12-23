FROM maven:3.9.6-eclipse-temurin-17 as builder
ARG ARTIFACT_REGISTRY_TOKEN
# This makes the variable available to Maven
ENV ARTIFACT_REGISTRY_TOKEN=${ARTIFACT_REGISTRY_TOKEN}
WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B -s settings.xml

# Copy the source code (this layer is invalidated on code changes)
COPY src ./src

RUN mvn clean package -DskipTests -s settings.xml

COPY target/*.jar graphql.jar

# Step 4: Expose the port (Cloud Run defaults to 8080)
EXPOSE 8080

# Step 5: Run the JAR
# We use -Dserver.port to ensure Spring matches the port Cloud Run expects
ENTRYPOINT ["java", "-Dserver.port=8080", "-jar", "graphql.jar"]