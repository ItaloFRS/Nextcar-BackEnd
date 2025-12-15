# --- ETAPA 1: BUILD ---
# Usamos uma imagem Maven estável com Java 21 (Eclipse Temurin)
FROM maven:3.9-eclipse-temurin-21 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Compila o projeto e gera o .jar (pula os testes para ser mais rápido no deploy)
RUN mvn clean package -DskipTests

# --- ETAPA 2: RUNTIME ---
# Usamos uma imagem leve do Java 21 para rodar a aplicação
FROM eclipse-temurin:21-jre-alpine

# Define o diretório de trabalho
WORKDIR /app

# Copia o .jar gerado na etapa anterior
# O comando abaixo pega qualquer arquivo .jar na pasta target
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]