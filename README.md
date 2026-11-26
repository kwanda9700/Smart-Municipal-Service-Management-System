
# Smart Municipal Service Management System

A Java-based municipal service management application developed to help manage citizen service requests. The system demonstrates backend development, REST API integration, database management, JDBC connectivity, and server-side web development.

## Project Overview

The Smart Municipal Service Management System is designed to provide a platform where citizens can submit municipal service requests and retrieve information about submitted requests.

The application uses Java and Spring Boot for backend development, MySQL for database storage, and JSP for displaying information through web pages.

It also demonstrates the use of both Spring Data JPA and JDBC for database operations.

## Features

- Submit municipal service requests.
- Retrieve all submitted service requests.
- Retrieve individual service requests using their IDs.
- Validate user input.
- Store service requests in a MySQL database.
- Automatically assign a submitted status to new requests.
- Display service requests through JSP pages.
- Demonstrate direct JDBC database connectivity.
- Export service request information to CSV files.
- Handle application errors and invalid requests.
- Perform unit testing using JUnit and Mockito.
- Test REST API endpoints using Postman.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Spring Boot 3.3.5 | Backend framework |
| Spring Web | REST API development |
| Spring Data JPA | Database persistence |
| Hibernate | Object-relational mapping |
| MySQL | Database management |
| JDBC | Direct database connectivity |
| JSP | Server-side web pages |
| JSTL | JSP functionality |
| Apache Tomcat | Web application server |
| Maven | Dependency management |
| JUnit 5 | Unit testing |
| Mockito | Mock testing |
| Postman | API testing |
| Apache NetBeans | Development environment |

## Project Structure

```text
Smart-Municipal-Service-Management/
│
├── database/
│   └── municipal_service_db.sql
│
├── docs/
│   └── EVIDENCE_CHECKLIST.md
│
├── postman/
│   └── Smart-Municipal-Service.postman_collection.json
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── za/co/municipality/smartservice/
│   │   │       ├── controller/
│   │   │       ├── exception/
│   │   │       ├── filehandling/
│   │   │       ├── jdbc/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── servlet/
│   │   │
│   │   ├── resources/
│   │   │   └── application.properties
│   │   │
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── jsp/
│   │       │       └── requests.jsp
│   │       └── requests-jdbc.jsp
│   │
│   └── test/
│       └── java/
│
├── pom.xml
└── README.md
```

## Requirements

Before running the application, ensure you have installed:

- JDK 17 or later.
- Apache NetBeans.
- Apache Maven 3.8 or later.
- MySQL Server.
- MySQL Workbench (optional).
- Postman (optional).

## Database Configuration

### 1. Create the database

Locate the SQL script:

`database/municipal_service_db.sql`

Execute the script using MySQL Workbench or your preferred MySQL client.

The script creates the `municipal_service_db` database and the required service requests table.

### 2. Configure database connectivity

Open:

`src/main/resources/application.properties`

Configure your MySQL connection:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/municipal_service_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Africa/Johannesburg

spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

You must also configure the JDBC connection class:

`src/main/java/za/co/municipality/smartservice/jdbc/JdbcConnection.java`

Update the database username and password to match your MySQL configuration.

**Important:** Never upload actual database passwords or sensitive credentials to a public GitHub repository.

## Running the Application

### Using Apache NetBeans

1. Open Apache NetBeans.
2. Select File → Open Project.
3. Locate the project directory.
4. Open the project containing `pom.xml`.
5. Allow Maven to download the required dependencies.
6. Configure your MySQL database.
7. Build and run the project.

### Using Maven

Run the following command to build the project:

```bash
mvn clean package
```

To execute the unit tests:

```bash
mvn clean test
```

To start the Spring Boot application:

```bash
mvn spring-boot:run
```

The application runs on:

`http://localhost:8080`

## REST API Endpoints

The application provides REST API endpoints for managing municipal service requests.

**Base URL:**

`http://localhost:8080/api/requests`

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/api/requests` | Submit a new service request |
| GET | `/api/requests` | Retrieve all service requests |
| GET | `/api/requests/{id}` | Retrieve a specific service request |

### Example: Submit a Service Request

**POST**

`http://localhost:8080/api/requests`

Request body:

```json
{
  "citizenName": "Thando Jacobs",
  "requestType": "ROAD_REPAIR",
  "description": "A pothole is causing a hazard outside 12 Main Road."
}
```

A successful request returns HTTP `201 Created`.

### Retrieve All Requests

**GET**

`http://localhost:8080/api/requests`

Returns a list of submitted service requests.

### Retrieve a Specific Request

**GET**

`http://localhost:8080/api/requests/1`

Returns the service request associated with the supplied ID.

If the request does not exist, the application returns HTTP `404 Not Found`.

## Testing

### Postman Testing

A Postman collection is included in:

`postman/Smart-Municipal-Service.postman_collection.json`

Import the collection into Postman to test the available REST API endpoints.

### Unit Testing

The project includes unit tests using:

- JUnit 5.
- Mockito.

Execute the tests using:

```bash
mvn test
```

## Additional Implementation

The project demonstrates several software development concepts:

- **REST API Development:** Creating endpoints for submitting and retrieving service requests.
- **Database Integration:** Connecting Java applications to MySQL.
- **JPA and Hibernate:** Managing database entities and persistence.
- **JDBC:** Executing SQL operations using direct database connectivity.
- **Input Validation:** Ensuring required information is provided.
- **Exception Handling:** Managing invalid requests and missing records.
- **File Handling:** Exporting service request information into CSV format.
- **Unit Testing:** Testing application functionality using JUnit and Mockito.

## Future Improvements

Potential improvements include:

- User authentication and authorisation.
- Municipal employee dashboards.
- Service request status tracking.
- Email and SMS notifications.
- Search and filtering functionality.
- Improved frontend design.
- Role-based access control.
- Deployment to a cloud hosting environment.

## Academic Context

Originally developed as part of:

**HSYD201-1: Systems Development 2A**

Summative Assessment 1.

---

Developed using Java, Spring Boot, MySQL and Maven.
