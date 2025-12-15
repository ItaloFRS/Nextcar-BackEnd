# 🚗 NextCar — BackEnd API (Java + Spring Boot)

Este é o projeto **backend da aplicação NextCar**, implementado em **Java com Spring Boot**.  
Ele fornece uma **API REST** para servir dados ao frontend (web e mobile), permitindo gerenciar carros, usuários e demais funcionalidades conectadas à aplicação NextCar.

🔗 Frontend Web (deploy no Vercel):  
https://next-car-front-qrjhuio1m-talo-de-farias-costas-projects.vercel.app/

---

## 🧠 Visão geral

Esta API foi projetada para ser consumida por aplicações clientes (React Web, React Native) via requisições HTTP REST.  
A arquitetura utiliza o ecossistema Spring Boot e Maven para organização de dependências, compilação e execução.

---

## 🚀 Funcionalidades Principais

> 📌 **Exemplo de rotas/endpoints esperados**  
> (Caso seu backend tenha endpoints definidos, ajuste abaixo conforme sua implementação real)

| Método | Endpoint           | Descrição                  |
|--------|--------------------|----------------------------|
| GET    | `/api/cars`        | Lista todos os carros      |
| GET    | `/api/cars/{id}`   | Detalhes de um carro       |
| POST   | `/api/cars`        | Cria um novo carro         |
| PUT    | `/api/cars/{id}`   | Atualiza um carro          |
| DELETE | `/api/cars/{id}`   | Remove um carro            |
| ...    | `/api/auth/...`    | Autenticação / Usuários    |

📍 Ajuste essa tabela de acordo com os endpoints existentes no seu projeto.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia   | Propósito                         |
|--------------|----------------------------------|
| **Java 17+**      | Linguagem principal             |
| **Spring Boot**   | Framework backend REST         |
| **Maven**         | Gerenciador de dependências     |
| **Spring MVC**    | Estrutura de API REST           |
| **Spring Data JPA** | Acesso a banco de dados (se houver) |

---

## 📥 Pré-requisitos

Antes de rodar a aplicação localmente, assegure que você tenha:

✔️ JDK 17 ou superior  
✔️ Maven instalado (ou utilize o wrapper `mvnw`)  
✔️ Banco de dados configurado (opcional / conforme necessidade)

---

## 📁 Estrutura de Pastas

```
Nextcar-BackEnd/
├── .mvn/                         # Configurações do Maven Wrapper
│   └── wrapper/
│       ├── maven-wrapper.jar
│       └── maven-wrapper.properties
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── nextcar/
│   │   │           ├── controller/      # Controllers (camada REST)
│   │   │           ├── service/         # Regras de negócio
│   │   │           ├── repository/      # Repositórios JPA
│   │   │           ├── model/            # Entidades / Models
│   │   │           ├── dto/              # DTOs
│   │   │           ├── config/           # Configurações (CORS, Security)
│   │   │           └── NextcarApplication.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-example.properties
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── nextcar/
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

```


