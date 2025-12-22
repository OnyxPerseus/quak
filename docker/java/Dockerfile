FROM eclipse-temurin:21-alpine

WORKDIR /app
COPY . .

ENTRYPOINT  ./mvnw clean install && ./mvnw -pl start spring-boot:run