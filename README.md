# Real-time Order Tracking System (Backend Microservice)

This is a backend-only microservice for managing and tracking customer orders in real time. Built using **Spring WebFlux**, **Kafka**, **MongoDB**, and **Docker**. The service is event-driven and provides functionalities for creating and updating customer orders with real-time status tracking.

This microservice tracks customer orders and updates their statuses asynchronously. It features event-driven architecture for efficient communication between services, allowing seamless order tracking and status updates.


## Features

- **Reactive APIs**: Exposes RESTful, non-blocking APIs for creating and updating customer orders.
- **Event-driven Architecture**: Kafka-based producer-consumer model for asynchronous order status updates.
- **MongoDB**: Utilizes MongoDB for persistent storage of customer orders.
- **Real-time Dashboard**: Real-time updates on order status using Kafka and WebFlux.
- **Dockerized**: The microservice is containerized using Docker and can be easily deployed.
  
## Tech Stack

- **Languages**: Java, Kotlin
- **Frameworks**: Spring Boot, Spring WebFlux
- **Messaging**: Apache Kafka
- **Database**: MongoDB (NoSQL)
- **Testing**: JUnit 5, Mockito
- **Containerization**: Docker
- **Spring WebFlux** for building non-blocking, reactive APIs.
- **Apache Kafka** for event-driven architecture and asynchronous message handling.
- **MongoDB** as the NoSQL database for storing order data.
- **Docker** for containerizing the application and running it across environments.
- **Docker Compos**e to orchestrate multiple services including *Kafka* and *MongoDB*.

## Setup and Installation

### Requirements

- **Java 11+**
- **Docker** and **Docker Compose**
- **MongoDB** (can be run in Docker container)
- **Kafka** (can be run in Docker container)

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/yashi2003/order-tracking-service.git
   cd order-tracking-service
   ```
2. Build and run the Docker containers:
   ```bash
   docker-compose up --build
   ```
3.Access the service at 
```bash
http://localhost:8080
```

### API EndPoints
1. Create Order (POST /api/orders)
Body:
```bash
{ "customerName": "Yashi", "product": "Phone", "status": "Placed" }
```

Get All Orders (GET /api/orders)
No body required.

Update Order Status (PUT /api/orders/{id})
Body: 
```bash
{ "status": "Shipped" }
```

