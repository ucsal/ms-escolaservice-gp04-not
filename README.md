# ms-escola-gp04-not

Microserviço responsável pelo gerenciamento de escolas, desenvolvido como parte da arquitetura de microserviços do projeto de disponibilidade de professores.

---

## Tecnologias utilizadas

- Java 17
- Spring Boot 4.0.6
- Spring Data JPA
- Spring Cloud Netflix Eureka Client
- PostgreSQL
- Lombok
- Maven

---

## Como rodar o projeto

### Requisitos

- Java 17 instalado
- PostgreSQL instalado e rodando
- Eureka Server rodando na porta 8761 (pode rodar sem ele, mas o registro no service discovery nao vai funcionar)

### Banco de dados

Crie o banco de dados antes de rodar a aplicacao:

```sql
CREATE DATABASE escola_service;
```

As tabelas sao criadas automaticamente pelo Hibernate ao subir a aplicacao.

### Configuracoes

As configuracoes ficam em `src/main/resources/application.properties`:

```properties
spring.application.name=escola-service
server.port=8083

spring.datasource.url=jdbc:postgresql://localhost:5432/escola_service
spring.datasource.username=postgres
spring.datasource.password=postgres

eureka.client.service-url.defaultZone=http://localhost:8761/eureka
```

### Rodando a aplicacao

Rode:

```bash
./mvnw spring-boot:run
```

Ou no IntelliJ, rode a classe `EscolaServiceApplication.java`.

A aplicacao sobe na porta `8083`.

---

## Endpoints disponiveis

### Criar escola

```
POST http://localhost:8083/escola

{
  "nome": "Escola de Engenharia",
  "coordenador": "Nome do Coordenador",
  "iesId": "uuid-da-ies",
  "iesNome": "Nome da IES"
}
```

---

### Listar escolas

```
GET http://localhost:8083/escola
```

Exemplo:

```json
[
  {
    "id": "7a73f8e3-bd22-492e-b16f-46d3a5989161",
    "nomeEscola": "Escola de Engenharia",
    "coordenador": "Nome do Coordenador",
    "nomeIes": "Nome da IES",
    "temHistorico": false
  }
]
```

---

### Excluir escola

```
DELETE http://localhost:8083/escola/{id}
```

Substitua `{id}` pelo UUID da escola. Retorna status 204 se bem sucedido.

A exclusao e feita de forma logica, ou seja, a escola nao e removida do banco, apenas marcada como inativa.

---

## Estrutura do projeto

```
src/main/java/com/equipe4/escolaservice/
├── controller/
│   └── EscolaController.java
├── dto/
│   ├── CriarEscolaDto.java
│   └── EscolaResponseDto.java
├── model/
│   └── Escola.java
├── repository/
│   └── EscolaRepository.java
├── service/
│   └── EscolaService.java
└── EscolaServiceApplication.java
```

---

## Observacoes

- O servico se registra automaticamente no Eureka Server ao subir, desde que o Eureka esteja rodando na porta 8761.
- O CORS esta liberado para qualquer origem, facilitando a integracao com o front-end ou API Gateway.
- As transacoes de escrita sao gerenciadas com @Transactional para garantir consistencia dos dados.
