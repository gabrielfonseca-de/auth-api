# 🔐 Auth API

This is a simple and modern authentication API built with **Java 21**, **Spring Boot 3**, and **JWT**. It provides endpoints for user registration, login, and access control using role-based authentication.

---

## 🚀 Technologies Used

- **Java 21**
- **Spring Boot 3**
- **Spring Security**
- **Spring Data JPA**
- **Hibernate**
- **JWT (JSON Web Token)**
- **Swagger/OpenAPI**
- **PostgreSQL** *(or your preferred database)*

---

## 📁 Project Structure

```bash
src/
└── main/
    └── java/
        └── com/
            └── api/
                └── auth_login/
                    ├── config/           # Security and Swagger configuration
                    ├── controller/       # API endpoints
                    ├── domain/
                    │   ├── enums/        # User roles
                    │   └── user/         # User entity
                    ├── dto/              # Request and response DTOs
                    ├── repository/       # JPA repositories
                    └── service/          # Business logic

-------------------------------------------------------------------------------------------------------------------------------------

🔧 Setup Instructions

1 -> Clone the repository

git clone https://github.com/gabrielfonseca-de/auth-api.git
cd auth-api

2 -> Set up your environment

- Configure your `application.yml` with your database and JWT settings.

   Example (`src/main/resources/application.yml`):
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/auth_db
       username: your_db_user
       password: your_db_password
     jpa:
       hibernate:
         ddl-auto: update
       show-sql: true
       properties:
         hibernate:
           format_sql: true

   jwt:
     secret: your_jwt_secret
     expiration: 3600000

3 -> Run the application

./mvnw spring-boot:run

4 -> Access Swagger UI

http://localhost:8080/swagger-ui/index.html

📦 Features

    ✅ User registration and login

    ✅ Password encryption with BCrypt

    ✅ Role-based access control (ADMIN, USER)

    ✅ Token-based authentication using JWT

    ✅ Swagger documentation for all endpoints


🧪 Future Improvements

Add refresh token mechanism

Add email verification

Add password reset feature

Add unit and integration tests

Dockerize the application

------------------------------------------------------------------------------------------------------------------------------------

🧑‍💻 Author

Gabriel do Nascimento Fonseca
LinkedIn | GitHub


