FROM eclipse-temurin:21-alpine

WORKDIR /app
COPY . .

CMD ./mvnw clean install && ./mvnw -pl start spring-boot:run