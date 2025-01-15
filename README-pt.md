[🇺🇸 Read this page in english](./README.md)

[🇧🇷 Leia esta página em português](./README-pt.md)


# Sobre

Exemplo de API utilizando Spring e Redis, com uso de genéricos para facilitar a criação de APIs em Java para operações básicas de CRUD (Create, Read, Update, Delete), implementado por meio de um backend de sistema simples de questões.

Meu objetivo é demonstrar habilidades e também facilitar projetos futuros. Pode criar forks deste projeto livremente ou sugerir melhorias!

## Tecnologias utilizadas:
- Java 22
- Spring 3
- Redis
- Docker
- Github Actions
- PostgreSQL

## Versionamento

A cada tag é gerado imagem com as variáveis de ambiente não definidas, de modo que são utilizados os valores padrão.

# Executar API com Docker

## Pré-Requisitos

Para o bom funcionamento da API, espera-se:

### Banco de Dados (PostgreSQL)

Criar rede docker:
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


## Iniciar backend

```sh
docker run \
  --name quiz-backend \
  -p 8080:8082 \
  --network quiz-net \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://quiz-db:5432/quiz \
  -e SPRING_REDIS_HOST=quiz-redis \
  ghcr.io/haetten/quiz-backend:latest
```

A database migration (Liquibase) irá criar a estrutura do banco conforme esperado.

# Swagger

A documentação das APIs via swagger estará acessível em 
http://localhost:8080/api/swagger-ui/index.html


# Genéricos

A API usa o conceito de genéricos e classes abstratas para fornecer operações CRUD genéricas para entidades persistentes. Ela utiliza o Spring Framework para expor endpoints RESTful.

## Exemplo de uso:

### 1. Crie a Entidade Persistente:
A entidade define a estrutura da tabela no banco de dados.
Sua entidade deve estender PersistentEntity\<I\>, onde I é o tipo do identificador (por exemplo, Long).

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
O serviço contém a lógica de negócios e interage com o repositório.
Seu serviço deve estender GenericService\<T, I\>, onde T é a entidade e I é o tipo do identificador.

GenericService possui 2 subclasses abstratas, com diferentes implementações para conexão ao banco:
- GenericEntityManagerService, que usa EntityManager;
- GenericRepositoryService, que usa JpaRepository.

#### 2.1 Extendendo GenericEntityManagerService: 
Pode-se realizar override os métodos buildParameters, postProcessing e getJoin para incluir filtros adicionar ou tratamentos nos resultados da consulta.

##### TestService.java
```java
@Service
public class TestService  extends GenericEntityManagerService<TestEntity, Long, GenericFilter>{

	// Construtor obrigatório. Passar classe da entidade.
	public TestService() {
		super(TestEntity.class);
	}

    // Implementações específicas, se necessário

}
```

#### 2.2 Extendendo GenericRepositoryService
Ao usar JpaRepository, será necessária a criação também do repository para a entidade:

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

    // Implementações específicas, se necessário
	
}
```

### 3. Crie o Controlador Específico:
O controlador permite expor endpoints RESTful.
Seu controlador deve estender GenericController\<T, I, S\>, onde T é a entidade, I é o tipo do identificador, e S é o serviço.

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

### 4. Endpoints Disponíveis
Com a criação do Controller e Service, com pouquíssimas linhas de código serão expostos os endpoints:

- GET /tests: Retorna uma lista de todas as entidades.
- GET /tests/count: Retorna a contagem total de entidades.
- GET /tests/{id}: Retorna uma entidade específica pelo seu ID.
- POST /tests: Salva uma nova entidade.
- PUT /tests: Atualiza uma entidade existente.
- DELETE /tests: Deleta uma entidade pelo seu ID.

Os endpoints usarão cache com o Redis na leitura pelo ID, limpando o cache ao realizar atualização ou exclusão.








