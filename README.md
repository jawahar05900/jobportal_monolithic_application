


# 🌟 Job Portal Monolithic Application 🌟

## Project Description
Welcome to the **Job Portal Monolithic Application (2024)**! This comprehensive job portal facilitates seamless matching of job seekers with employers. Featuring REST APIs designed with Spring Boot and integrated with H2/PostgreSQL databases, it achieves a **15% reduction in query latency**. Deployed using Docker and Kubernetes, the application offers real-time monitoring via Spring Boot Actuator.

## Key Features
- 🏗️ **Monolithic Architecture**: Unified design for simplicity and ease of use.
- 🚀 **RESTful APIs**: Efficient data handling using Spring Boot.
- 🗄️ **Database Integration**: Supports H2 and PostgreSQL databases.
- 🐳 **Containerization**: Docker for creating isolated environments.
- ☸️ **Orchestration**: Managed with Kubernetes for deployment and scaling.
- 📈 **Monitoring**: Real-time monitoring with Spring Boot Actuator.

## Installation

### Prerequisites
- 📦 Java 11 or higher
- 🐳 Docker
- ☸️ Kubernetes
- 🔧 Maven

### Steps
1. **Clone the repository**:
   ```bash
   git clone https://github.com/jawahar05900/jobportal_monolithic_application.git
   cd jobportal_monolithic_application
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Build and run Docker containers**:
   ```bash
   docker-compose up --build
   ```

4. **Deploy to Kubernetes**:
   ```bash
   kubectl apply -f k8s/
   ```

## Usage

1. **Access the application**:
   - **Web Interface**: `http://localhost:8080`

2. **API Endpoints**:
   - `GET /api/job`: Fetches all job listings.
   - `POST /api/job`: Creates a new job listing.
   - `PUT /api/job/{id}`: Updates an existing job listing.
   - `DELETE /api/job/{id}`: Deletes a job listing.

## Contributing

1. **Fork the repository**.
2. **Create a new branch**:
   ```bash
   git checkout -b feature-branch
   ```
3. **Make your changes**.
4. **Commit your changes**:
   ```bash
   git commit -m 'Add new feature'
   ```
5. **Push to the branch**:
   ```bash
   git push origin feature-branch
   ```
6. **Open a pull request**.

## License
This project is licensed under the MIT License.



Feel free to copy and customize this README file for your project. If you need further adjustments or additional details, just let me know!

  




