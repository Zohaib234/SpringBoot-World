# Company & Job Microservices

This repository contains two microservices: **Company Microservice** and **Job Microservice**. Each microservice is designed to handle specific functionalities related to the domain. These microservices are designed to be run independently but can communicate with each other where necessary.

## Table of Contents

- [Company Microservice](#company-microservice)
- [Job Microservice](#job-microservice)
- [Monolithic Version](#monolithic-version)
- [Docker Images](#docker-images)
- [Getting Started](#getting-started)
- [Running the Microservices](#running-the-microservices)
- [Contributing](#contributing)
- [License](#license)

## Company Microservice

The **Company Microservice** is responsible for managing company-related operations. This includes creating, updating, and retrieving company information.

### Features

- Create new companies
- Update existing company details
- Retrieve company information

### Technologies

- Spring Boot
- Maven
- Java

### Getting Started

1. Navigate to the `CompanyMicroService` directory:

    ```bash
    cd CompanyMicroService
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

3. Start the microservice:

    ```bash
    java -jar target/CompanyMicroService-0.0.1-SNAPSHOT.jar
    ```

## Job Microservice

The **Job Microservice** is responsible for managing job-related operations. This includes creating, updating, and retrieving job postings.

### Features

- Create new job postings
- Update existing job postings
- Retrieve job information

### Technologies

- Spring Boot
- Maven
- Java

### Getting Started

1. Navigate to the `JobMicroService` directory:

    ```bash
    cd JobMicroService
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

3. Start the microservice:

    ```bash
    java -jar target/JobMicroService-0.0.1-SNAPSHOT.jar
    ```

## Monolithic Version

In addition to the microservices, a **monolithic** version of the application is available in the `monolethic` branch. This version combines the functionalities of both microservices into a single application.

### Docker Image

A Docker image for the monolithic version is available on Docker Hub.

- **Docker Hub Link**: [Spring Boot Monolithic](https://hub.docker.com/repository/docker/zohaib41105/spring-boot/general)
- **Pull Command**:

    ```bash
    docker pull zohaib41105/spring-boot:tagname
    ```

Replace `tagname` with the appropriate tag for the version you want to pull.

## Docker Images

Each microservice can be containerized and run using Docker. To build and run the Docker images for these microservices:

1. **Build the Docker Image**:

    Navigate to the respective microservice directory and build the Docker image.

    ```bash
    docker build -t company-microservice:latest .
    docker build -t job-microservice:latest .
    ```

2. **Run the Docker Container**:

    ```bash
    docker run -p 8080:8080 company-microservice:latest
    docker run -p 8081:8081 job-microservice:latest
    ```

## Getting Started

1. Clone the repository:

    ```bash
    git clone <repository-url>
    ```

2. Checkout the `monolethic` branch if you want to work with the monolithic version:

    ```bash
    git checkout monolethic
    ```

3. Follow the instructions for building and running the microservices or the monolithic version.

## Contributing

Contributions are welcome! Please fork this repository and submit pull requests.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
