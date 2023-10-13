# Spring-Boot-project

# Employee Management System

This project consists of two main parts:
1. **EmployeeApiYourName**: A RESTful API service that provides CRUD functionalities for managing employees.
2. **EmployeeUIYourName**: A web-based UI application to interact with the EmployeeApi, making the management of employees user-friendly.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- Git

### Installation

1. Clone the repository:
```bash
git clone [your-git-repo-url]
```

2. Navigate to the project's root directory and install the dependencies:
```bash
mvn clean install
```

### Running the Applications

1. **EmployeeApiYourName**: 
Navigate to the root directory of `EmployeeApiYourName` and run:
```bash
mvn spring-boot:run
```
By default, the service will start on port `8080`.

2. **EmployeeUIYourName**: 
Navigate to the root directory of `EmployeeUIYourName` and run:
```bash
mvn spring-boot:run
```
Ensure that the service port for this application is different if running both applications on the same machine. By default, you might want to set it to run on port `8081`.

You can do this by updating the `application.properties` or `application.yml` file with the following line:
```
server.port=8081
```

## Usage

Once both applications are up and running:

1. Access the API documentation at: 
```
http://localhost:8080/swagger-ui/
```

2. Interact with the web-based UI application at:
```
http://localhost:8081/
```

## Features

- CRUD operations for managing employees.
- Custom runtime exceptions.
- API documentation using Swagger.
- Responsive web-based UI to manage employees.

## Contributing

If you'd like to contribute, please fork the repository and use a feature branch. Pull requests are warmly welcome.

## License

This project is licensed under the MIT License - see the `LICENSE.md` file for details.

