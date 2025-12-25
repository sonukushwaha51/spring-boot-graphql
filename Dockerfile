FROM maven:3.9.6-eclipse-temurin-17 as builder

ARG ARTIFACT_REGISTRY_TOKEN
ENV ARTIFACT_REGISTRY_TOKEN=${ARTIFACT_REGISTRY_TOKEN}
WORKDIR /app

COPY pom.xml .
COPY settings.xml .

RUN if [ -z "$ARTIFACT_REGISTRY_TOKEN" ]; then echo "TOKEN IS EMPTY"; else echo "TOKEN STARTS WITH: ${ARTIFACT_REGISTRY_TOKEN:0:5}"; fi

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