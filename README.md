[🇺🇸 Read this page in english](./README.md)

[🇧🇷 Leia esta página em português](./README-pt.md)


# About

Example API using Spring and Redis, with the use of generics to simplify the creation of Java APIs for basic CRUD (Create, Read, Update, Delete) operations, implemented through a simple backend system for questions.

My goal is to demonstrate my skills and facilitate future projects. Feel free to fork this project or suggest improvements!

## Technologies Used:
- Java 22
- Spring 3
- Redis
- Docker
- GitHub Actions
- PostgreSQL

## Versioning

Each tag generates an image with undefined environment variables, using default values.

# Run API with Docker

## Prerequisites

For the API to work properly, the following are required:

### Database (PostgreSQL)

Create Docker network:
```sh
docker network create quiz-net
```

```sh
docker run \
  --name quiz-db \
  -e POSTGRES_DB=quiz \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  --network quiz-net \
  -v quiz-data:/var/lib/postgresql/data \
  -d postgres:latest
```

### Cache (Redis)
```sh
docker run \
  --name quiz-redis \
  -p 6379:6379 \
  --network quiz-net \
  -d redis:latest
```


## Start Backend

```sh
docker run \
  --name quiz-backend \
  -p 8080:8082 \
  --network quiz-net \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://quiz-db:5432/quiz \
  -e SPRING_REDIS_HOST=quiz-redis \
  ghcr.io/haetten/quiz-backend:latest
```

The database migration (Liquibase) will create the expected database structure.

# Swagger

API documentation via Swagger will be accessible at:
http://localhost:8080/api/swagger-ui/index.html


# Generics

The API uses the concept of generics and abstract classes to provide generic CRUD operations for persistent entities. It leverages the Spring Framework to expose RESTful endpoints.

## Usage Example:

### 1. Create the Persistent Entity:
The entity defines the structure of the table in the database.
Your entity must extend PersistentEntity\<I\>, where I is the type of the identifier (e.g., Long).

##### TestEntity.java
```java
@Entity
public class TestEntity extends PersistentEntity<Long> {
    @Id
    private Long id;
    private String name;
    // getters and setters
}
```

### 2. Crie o Serviço Genérico, usando Repository ou EntityManager:
The service contains the business logic and interacts with the repository.
Your service must extend GenericService\<T, I\>, where T is the entity and I is the identifier type.

GenericService has two abstract subclasses with different implementations for database connection:
- GenericEntityManagerService, which uses EntityManager.
- GenericRepositoryService, which uses JpaRepository.

#### 2.1 Extending GenericEntityManagerService:
You can override the methods buildParameters, postProcessing, and getJoin to add filters or process query results.

##### TestService.java
```java
@Service
public class TestService  extends GenericEntityManagerService<TestEntity, Long, GenericFilter>{

    // Mandatory constructor. Pass the entity class.
	public TestService() {
		super(TestEntity.class);
	}

    // Specific implementations, if necessary

}
```

#### 2.2 Extending GenericRepositoryService
When using JpaRepository, you must also create a repository for the entity:

##### TestRepository.java
```java
public interface TestRepository extends JpaRepository<TestEntity, Long> {

}

```

##### TestService.java
```java
@Service
public class TestService extends GenericRepositoryService<TestEntity, Long, TestRepository> {

	public TestService(TestRepository repository) {
		super(TestEntity.class, repository);
	}

    // Specific implementations, if necessary
	
}
```

### 3. Create the Specific Controller:
The controller exposes RESTful endpoints.
Your controller must extend GenericController\<T, I, S\>, where T is the entity, I is the identifier type, and S is the service.

##### TestController.java
```java
@RestController
@RequestMapping("/tests")
public class TestController extends GenericController<TestEntity, Long, TestService> {

    public TestController(TestService service) {
        super(service);
    }
}
```

### 4. Available Endpoints
With the creation of the Controller and Service, the endpoints will be exposed with very few lines of code:

- GET /tests: Returns a list of all entities.
- GET /tests/count: Returns the total count of entities.
- GET /tests/{id}: Returns a specific entity by its ID.
- POST /tests: Saves a new entity.
- PUT /tests: Updates an existing entity.
- DELETE /tests: Deletes an entity by its ID.

The endpoints use Redis caching for reading by ID, clearing the cache when updating or deleting an entity.












