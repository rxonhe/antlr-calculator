FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY . .
RUN ./gradlew build
CMD ["./gradlew", "bootRun"]
EXPOSE 8080
