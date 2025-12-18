FROM eclipse-temurin:21-alpine

ARG UID
ARG GID

RUN addgroup -g ${GID} appgroup && \
    useradd -u ${UID} -g appgroup -m appuser && \
    mkdir -p /home/appuser/.m2 && \
    chown -R appuser:appgroup /home/appuser && \
    chown -R appuser:appgroup /app

WORKDIR /app
COPY . .

USER appuser

ENTRYPOINT  ./mvnw clean install && ./mvnw -pl start spring-boot:run