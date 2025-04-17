# API REST (Client)

In this project i have one entity for test my API Rest, so i have that to do a CRUD, validations and exceptions for client and test with some Endpoints.

To development this project i use layered architecture.

![Image of layered architecture!](/assets/images/layer1.drawio.png)

But what is this layered architecture? Development in layer is an architecture that separates the responsabilities of the a determined entity in our system. In this image we have a section of back-end, in this section we have three layers that are Controllers REST, Service layer and Access layer of data (Respository). let's go to start talk about Access layer of data (Respository) is layer is the more under of our sistem when use the leyered architecture, it communicates with the database, the service layer accesses the services that are offered by the data access layer (Repository), we can see that there is a bridge between the service layer and the repository that is entity/ORM that are entities of our system, ORM (Object-Relational Mapping) that transforms our entities into table format in our database, in this two layer is do the transition on database of the entities and in the REST layer the controller benefits from the services offered by the service layer to perform REST query operations. Oops! I almost forgot. Data Transfer Objects (DTO) transport data from our application in response to REST requests.

## Conceptual Model (UML)

![Client UML!](/assets/images/Client%20Diagram.png)

Our entity that we will test.

### This API provides five operations basics

These are:

- Paged resource search
- Resource search by id 
- Insert new resource 
- Update resouce
- Delete resouce

### How to do requests this API

Search client by id

**GET /clients/1**

Paged clients search

**GET /clients?page=0&size=6&sort=name**

New client insertion

**POST  /clients**

```
{
  "name": "João Carlos",
  "cpf": "12345678901",
  "income": 30000.0,
  "birthDate": "1990-07-20",
  "children": 0
}
```

Update Client

**PUT /clients/1**

```
{
    "name": "Maria Silva", 
    "cpf": "12345678901", 
    "income": 6500.0, 
    "birthDate": "1994-07-20", 
    "children": 2 
}
```

Deletion client

**DELETE /clients/1**

## Tecnologies used

- Java
- Spring Boot
- Postman






