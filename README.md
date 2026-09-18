# Job Portal — Monolithic Application

A Spring Boot REST API for a job portal, handling companies, job postings, and company reviews in a single service.

## Tech Stack

- **Java 17**
- **Spring Boot 3.3.2**
- **Spring Data JPA** (Hibernate)
- **PostgreSQL** — primary database
- **H2** — used during early local development (currently commented out in favor of PostgreSQL)
- **Spring Boot Actuator** — health/monitoring endpoints
- **Maven**

## Architecture

Single Spring Boot application, organized into three domain packages:

- `Jobs` — job posting entity, controller, service, repository
- `Companys` — company entity, controller, service, repository (a company has many jobs and many reviews)
- `review` — company review entity, controller, service, repository (nested under a company)

## API Endpoints

### Jobs — `/job`
| Method | Path | Description |
|---|---|---|
| GET | `/job` | Fetch all jobs |
| POST | `/job` | Create a job |
| GET | `/job/{id}` | Fetch a job by ID |
| PUT | `/job/{id}` | Update a job |
| DELETE | `/job/{id}` | Delete a job |

### Companies — `/companies`
| Method | Path | Description |
|---|---|---|
| GET | `/companies` | Fetch all companies |
| POST | `/companies` | Create a company |
| GET | `/companies/{id}` | Fetch a company by ID |
| PUT | `/companies/{id}` | Update a company |
| DELETE | `/companies/{id}` | Delete a company |

### Reviews — `/companies/{companyId}/reviews`
| Method | Path | Description |
|---|---|---|
| GET | `/companies/{companyId}/reviews` | Fetch all reviews for a company |
| POST | `/companies/{companyId}/reviews` | Create a review for a company |
| GET | `/companies/{companyId}/reviews/{reviewId}` | Fetch a specific review |
| PUT | `/companies/{companyId}/reviews/{reviewId}` | Update a review |
| DELETE | `/companies/{companyId}/reviews/{reviewId}` | Delete a review |

./mvnw spring-boot:build-image

This produces a runnable Docker image using the project's Maven configuration. An image built this way has been pushed to Docker Hub.

## Running Locally

1. Start PostgreSQL and pgAdmin via Docker Compose (this only runs the database, not the app itself):
docker-compose up

2. Set the `DB_USERNAME` and `DB_PASSWORD` environment variables with your local PostgreSQL credentials.
3. Run the application:
./mvnw spring-boot:run
4. The API is available at `http://localhost:8080`.

## Known Limitations / Roadmap

This is a learning project and is intentionally scoped. Not yet implemented:

- No authentication or authorization (Spring Security / JWT)
- No automated tests beyond the default Spring Boot context-load test
- No CI/CD pipeline

These are on the roadmap as the project evolves.

## Container Image

This application can be containerized using Spring Boot's built-in Cloud Native Buildpacks support (no Dockerfile required):
