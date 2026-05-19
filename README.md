# Fitness Management Backend Application

Backend Fitness Management Application built with Java & Spring Boot featuring JWT Authentication, CRUD Operations, REST APIs, Swagger Documentation, Validation, MySQL Integration, and Exception Handling.

---

## 🚀 Features

* JWT Authentication & Authorization
* CRUD Operations
* RESTful APIs
* Swagger API Documentation
* Validation & Exception Handling
* MySQL Database Integration
* Postman API Testing

---

## 🛠 Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* MySQL
* Swagger/OpenAPI
* Postman

---

## 📂 Project Structure

* Controller
* Service
* Repository
* DTO
* Model
* Security
* Config
* Exception Handling

---

## 🔗 API Endpoints

### 🔐 Authentication APIs

| Method | Endpoint             | Description                       |
| ------ | -------------------- | --------------------------------- |
| POST   | `/api/auth/register` | Register a new user               |
| POST   | `/api/auth/login`    | Login user and generate JWT token |

---

### 🏃 Activity APIs

| Method | Endpoint                      | Description                       |
| ------ | ----------------------------- | --------------------------------- |
| POST   | `/api/activity`               | Track user activity               |
| GET    | `/api/activity/user/{userId}` | Get activities of a specific user |

---

### 💡 Recommendation APIs

| Method | Endpoint                                    | Description                        |
| ------ | ------------------------------------------- | ---------------------------------- |
| POST   | `/api/recommendation/generate`              | Generate fitness recommendation    |
| GET    | `/api/recommendation/user/{userId}`         | Get recommendations by user ID     |
| GET    | `/api/recommendation/activity/{activityId}` | Get recommendations by activity ID |

---

## ▶️ How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA or VS Code
3. Configure MySQL database in `application.properties`
4. Run MySQL server
5. Run the Spring Boot application
6. Access Swagger UI:

   ```bash
   http://localhost:8080/swagger-ui/index.html
   ```
7. Test APIs using Postman or Swagger UI


## 📌 API Testing

APIs tested using Postman and documented with Swagger UI.

---

## 👨‍💻 Author

Vikas Maurya
