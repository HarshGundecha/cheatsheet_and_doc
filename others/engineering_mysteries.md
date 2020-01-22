- [Engineering Mysteries](#engineering-mysteries)
  - [Backend](#backend)
      - [API gateway](#api-gateway)
  - [- what API gateway is in use here](#ul-liwhat-api-gateway-is-in-use-hereli-ul)
    - [programming or java related](#programming-or-java-related)
    - [Logging](#logging)
  - [- where are the logs stored](#ul-liwhere-are-the-logs-storedli-ul)
    - [Microservice](#microservice)
      - [Discovery](#discovery)
      - [Other](#other)
  - [- how do we maintain the consistency and atomicity of a transaction when there are bunch of microservices communicating with each other](#ul-lihow-do-we-maintain-the-consistency-and-atomicity-of-a-transaction-when-there-are-bunch-of-microservices-communicating-with-each-otherli-ul)
    - [circuit breaker](#circuit-breaker)
  - [- when circuit breaking happens how the other instances of the service where the circuit breaking happended are alerted](#ul-liwhen-circuit-breaking-happens-how-the-other-instances-of-the-service-where-the-circuit-breaking-happended-are-alertedli-ul)
  - [Frontend](#frontend)

# Engineering Mysteries 

## Backend
- how to test a function that needs the DB or any other resource to be in a particular state
  - ans - checkout junit with mockito, how ?
- in case of social media login how we maintain our native email based and social media based users in DB, what the design is like ? 
- what are all messaging queues used here
- what happens in case of a user's token is stolen

#### API gateway
- do we have API gateway
  - what are all things that our gateway takes care of
  - what API gateway is in use here
---

### programming or java related
- how are the environment variables set for different environment without exposing the credentials to unexpected set of people
- how we keep the system safe from concurrency issues(like multithreading), any best practices

### Logging
- how logs across different microservices are maintained
- where are the logs stored
---

### Microservice 

#### Discovery
- how microservice discovery happens in our system
- we do it by something like eureka  or how client registers at discovery server or is there something else ?

#### Other
- how do we maintain the consistency and atomicity of a transaction when there are bunch of microservices communicating with each other
---

### circuit breaker
- what are some of the circuit breaking parameters
- how a MS is set to normal after circuit breaking
- what system we use for CB is it hystrix or anything else ?
- when circuit breaking happens how the other instances of the service where the circuit breaking happended are alerted
---

## Frontend
- how to safely store the JWT token
  - do we use cookies or is there anything better that can be done
- how to resume user session on reload or re-visit to site
