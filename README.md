# Employee CRUD API with Spring Data JPA

## Description
This project is a RESTful API for managing employee data, built with Spring Boot. It supports CRUD operations and leverages Spring Data JPA to simplify data access, removing the need for a traditional DAO layer.

## Technologies Used
- Spring Boot 3
- Spring 6
- Spring Data JPA
- Hibernate (JPA)
- MySQL
- Maven
- Swagger UI for API documentation and testing

### Dependencies
- **springdoc-openapi-starter-webmvc-ui**: Added to enable Swagger UI for interactive API documentation and testing (version 2.8.9).

## How to Run the Project
1. **Clone the repository**:
   ```bash
   git clone https://github.com/abdalrhman002/employee-crud-spring-data-jpa.git
   ```
2. **Navigate to the directory**:
   ```bash
   cd employee-crud-spring-data-jpa
   ```
3. **Set up the database**:
    - Create a MySQL database named `employee_db`.
    - Update `application.properties` with your database credentials.
4. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```
5. **Access Swagger UI**:
    - Open your browser and go to `http://localhost:8080/ui.html`.
    - Use Swagger UI to explore and test the API endpoints interactively.

## Approach Explanation
This project uses Spring Data JPA to streamline data access:
- **Repository Interface**: Extends `JpaRepository`, providing CRUD methods without manual implementation.
- **Service Layer**: Manages business logic and transactions.
- **REST Controller**: Defines API endpoints.

By using Spring Data JPA, this project reduces boilerplate code compared to the DAO-based approach, making it more efficient for standard CRUD operations.

## API Documentation
- **Swagger UI**: Available at `http://localhost:8080/ui.html` for interactive API testing.
- **OpenAPI Docs**: Available at `http://localhost:8080/api-doc` for the API specification.

## Related Projects
Explore other implementations:
- [DAO, Service, REST Controller Version](https://github.com/abdalrhman002/employee-crud-dao-service-rest)
- [Spring Data REST Version](https://github.com/abdalrhman002/employee-crud-spring-data-rest)