Spring Cloud Microservices with API Gateway & Eureka
This repository demonstrates a microservices architecture using:
- Spring Cloud Gateway as the API Gateway
- Eureka Server for service discovery
- Student Service and School Service as microservices
- Feign Clients for inter-service communication

Architecture

- All services (Gateway, Student, School) register with Eureka.
- The API Gateway uses Eureka to discover and route requests to the services.

Configuration
- API Gateway - Port: 8084
- Routes:
- /api/student/** → lb://STUDENT
- /api/school/** → lb://SCHOOL
- Eureka Server - Port: 8083
- URL: http://localhost:8083/eureka/

Endpoints
Gateway
- http://localhost:8084/api/student/** → Student Service
- http://localhost:8084/api/school/** → School Service
  Student Service
- GET /api/student/all → All students
- POST /api/student/add → Add student
- GET /api/student/{id} → Student by ID
  School Service
- GET /api/school/all → All schools
- POST /api/school/add → Add school
- GET /api/school/{id} → School by ID

Run Order
- Start Eureka Server (8083)
- Start Student Service and School Service
- Start API Gateway (8084)
- Access services via Gateway:
- http://localhost:8084/api/student/findAll
- http://localhost:8084/api/school/findAll

Monitoring
Actuator endpoints exposed via Gateway:
- /actuator/health
- /actuator/info
- /actuator/metrics


