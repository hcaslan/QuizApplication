# Quiz Application Spring Boot Project

The application aims to provide a system where questions and their corresponding answers can be prepared and managed. The main goal is to create a functional and efficient platform for the creation and implementation of quizzes.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Endpoints](#api-Endpoints)
- [How It Works](#how-it-works)
- [Validation and Error Checking](#validation-and-error-checking)

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- Jakarta Bean Validation

## Project Structure

The Blog Spring Boot Project follows a standard project structure to organize its source code and resources. Here's an overview of the project structure:

- `src/main/java/org.hca.quizapplication.constant`: Contains constant values used throughout the application.
- `src/main/java/org.hca.quizapplication.controller`: Contains the application's controllers.
- `src/main/java/org.hca.quizapplication.dto`: Contains Data Transfer Objects (DTOs) to encapsulate data and transport it between the controller and service layers.
    - `.request`: Contains request DTOs represent data sent by the client in requests.
    - `.response`: Contains response DTOs represent data returned to the client in responses.
- `src/main/java/org.hca.quizapplication.entity`: Contains the entity classes representing the application's data model.
- `src/main/java/org.hca.quizapplication.exception`: Contains custom exceptions and exception handling logic.
- `src/main/java/org.hca.quizapplication.mapper`:  Contains mapper classes responsible for mapping between different object representations within the application.
    - `.customMapper`: Contains custom mapping logic for specific scenarios.
- `src/main/java/org.hca.quizapplication.repository`: Contains the interfaces for data access and repositories.
- `src/main/java/org.hca.quizapplication.rules`: Contain classes related to business rules and validation rules specific to the application domain.
- `src/main/java/org.hca.quizapplication.service`: Contains the services that implement the business logic.
- `src/main/java/org.hca.quizapplication.utility`: Contains utility classes and helper functions that are used throughout the application.
- `src/main/resources`: Contains configuration files and static resources used by the application.

## Getting Started

Follow the steps below to set up and run the project on your local machine:

1. Configure the database connection:

    - Open the `application.yml` file located in the `src/main/resources` directory.
    - Update the database connection details such as URL, username, and password according to your PostgreSQL configuration.

   ```yaml
   server:
     port: 9090
   spring:
     datasource:
       driver-class-name: org.postgresql.Driver
       url: jdbc:postgresql://localhost:5432/quizDB
       username: postgres
       password: 1234
     jpa:
       hibernate:
         ddl-auto: update
   ```
    - The application will start running on `http://localhost:9090`.

2. Access the API documentation:

   Once the application is running, you can access the API documentation by visiting `http://localhost:9090/swagger-ui.html` in your web browser. The API documentation provides detailed information about the available endpoints, request and response formats, and allows you to interact with the APIs.

## API Endpoints

The following API endpoints are available:

| Endpoint Tag                     | Call   |                 Endpoint                  | Description                                                        |
|----------------------------------|--------|:-----------------------------------------:|--------------------------------------------------------------------|
| CREATE                           | POST   |            `/api/v2/questions`            | Create a new question.                                             |
| FIND_ALL                         | GET    |            `/api/v2/questions`            | Get a list of all questions.                                       |
| FIND_BY_ID                       | GET    |         `/api/v2/questions/{id}`          | Get detailed information about a specific question.                |
| GET_QUIZ                         | GET    |      `/api/v2/quiz/{questionCount}`       | Get the exam consisting of a given number of questions             |

## How It Works

- To add a question to the database, the questionText and answers fields of the question must be filled in completely.
- answerText field should be filled in the answers list field. Also, 1 correct answer should be selected.
- answerText and questionText fields must be between 3 and 2024 characters in length.
- Should be specified how many questions the quiz to be created will consist of.
- Quiz questions are numbered and the answers to each question are numbered.
- There is an answer key at the bottom of the quiz.

## Validation and Error Checking

The project incorporates validation and error checking to ensure the integrity of the data and provide meaningful error messages.

- #### Length Validation:

[Jakarta Bean Validation](https://beanvalidation.org/) is a validation model that can add constraints to the beans with annotations placed on fields, methods, or classes.

With the `validateFieldLength` method, the lengths of the fields are checked and a meaningful error is returned.

- #### BusinessRules Classes:

The project utilizes BusinessRules classes to encapsulate validation logic and enforce business rules. These classes provide a structured approach to validate entities and perform custom validation checks specific to the project's requirements.

---

This project was developed for Java programming courses. [Bilge Adam](https://www.bilgeadam.com/).

by [hcaslan](https://github.com/hcaslan).