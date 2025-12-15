# ETAPA 1: BUILD (Compilação)
FROM maven:4.0.0-openjdk-21 AS build
# Copia todo o código-fonte para a imagem de build
COPY . .
# Roda o comando Maven para limpar e empacotar (criando o JAR)
RUN mvn clean package -DskipTests

# ETAPA 2: RUNTIME (Execução)
FROM openjdk:21-jdk-slim
# Copia o JAR criado na etapa de build para a pasta raiz do container de execução, nomeando-o como app.jar
COPY --from=build /target/*.jar app.jar
# Sua aplicação Spring Boot deve usar a porta 8080 por padrão
EXPOSE 8080
# Define o comando que será executado ao iniciar o container
ENTRYPOINT ["java", "-jar", "app.jar"]