# RabbitMQ Capstone Project

This project demonstrates a simple Spring Boot application that uses RabbitMQ for message queuing. It includes components for publishing, scheduling, and listening to messages.

## Technologies Used

- Java
- Spring Boot
- Maven
- Lombok
- Log4j2
- RabbitMQ
- HAProxy
- Docker

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Docker
- An IDE such as IntelliJ IDEA

## Setup

### Clone the Repository

```bash
git clone https://github.com/rushawnwhite29/rabbitmq-capstone.git
cd rabbitmq-capstone
```

### Running RabbitMQ and HAProxy in Docker
To run RabbitMQ and HAProxy in Docker, use the following commands:

```bash
docker-compose up -d
```

### Running the Applications

For Both the Publisher and Listener Modules:
- Navigate to the Application class in the com.griddynamics.rwhite_rabbitmq_capstone package.
- Right-click on the Application class and select Run 'Application.main()'.

## Usage

### Message Publishing
The MessagePublisher class is responsible for publishing messages to the RabbitMQ queue.  

### Message Scheduling
The MessageScheduler class schedules the publishing of messages at a fixed rate (configured to 100 milliseconds).  

### Message Listening
The MessageListener class listens for messages from the RabbitMQ queue and logs the received messages.