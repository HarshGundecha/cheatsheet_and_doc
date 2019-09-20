# Terminologies
- ## Java
  _________________________________________
  | **Item**          | **Description**
  |-------------------|--------------------
  | Annotations       | a way to provide meta data to the context
  | JDBC              | java's build in database connectivity and execution solution
  | JPA               | a framework that map relational database entities to java objects and persist them
  | JPQL              | sql like JPA query language
  | Entity            | a java class that represents a real world entity and reflected in database (entity=model)
  | Entity manager    | an object per entity that will perform crud operations for that entity
  | JTA               | framework for transaction management that provides atomicity
  | Repository        | a directory that contains all classes with functions that performs business logic as crud operations, functions defined here are later used for serving user requests
  | Bean validation   | used for validation in component
  | CDI               | context depemdency injection is used to inject dependency at runtime
  | JAX-RS            |
  __________________________________________


- ## Tools and Tech.
  __________________________________________
  | **Item**        |  **Description**
  |-----------------|-----------------------
  | Spring          | java umbrella project
  | Spring boot     | spring framewrok to ease spring's configuration and make spring run out of the box with almost zero configuration
  | H2              | in memory lite and embedded database(development use only)
  | Maven           | java ee build toool
  | Maven archetype | cli tool that helps generates java ee directory structure and few required files
  | Wildfly         | java runtime environment which hosts application
  | Junit           | tool for unit testing in java
  | Arquillian      | tool for integration testing
  | Shrinkwrap      | creates deployable archives, used for arquillian test deployement
  | Hibernate       | orm framework for relational DB
  | Open api spec.  | an open source api documentation specification
  | Swagger         | api documentaion tool and tech that uses open API spec.
  __________________________________________


---


# Java EE Deployement Process
- ## Manual
  - build project
  - package it in a .war file
  - start wildfly server and open it in browser
  - go to deployements and upload .war file there

- ## Automatic (automation of above)
  - to enable auto update .war on each run/deploy, configure intellij to automatically pack and put .war file at required  path
  - refer pularsight video for exact "how to"


---


# Open API Specification(OAS)
- open API documentation standard supported by linux foundation
- ## Swagger
  - helps in generating json based api documentation
  - uses Open API Specification(OAS) as a standard format for documentation
  - to be able to do so it uses a few additional annotations apart from already described ones in the EntityEndpoint of java REST api classes
  - java even have swagger specific annotations for describing API with proper information
  - documentation can include things like URI, parameters, response codes, response entities etc



# Spring
- spring is a umbrella project
- there are multiple projects under spring like data, secutity, core etc found at [Spring projects](https://spring.io/projects)
- spring boot is at top of these multiple projects
- spring cloud is at top of spring boot


# Parts of spring
- we put each of the different type of file in their respective packages
- for e.g, controller, repository, entity in their own packages (i.e also a seperate directory)
- table or entity structure and g/setter in entity
- db basic crud operation in dao
- db relate dother functions in repository
- business logic in controller which also uses methods defined in DAO
- JSP = view of codeigniter
- seperate class suffixed with EndPoint that serves as rest EndPoint and reuses Book repository under the hood


---


# Setup a Spring Project
- get a preconfigured spring boot app from [Start Spring project](https://start.spring.io)
- ## Database Configuration
  - add databases dependency in pom.xml with appropriate version
  - on adding it will show code in red as driver might not be there, to solve that just run it and it will automatically donwload required files
  - add database properties in application.properties alongwith auto ddl create-drop | update..
    ````properties
    spring.datasource.url=jdbc:postgresql://localhost:<port>/<dbname>
    spring.datasource.username=<username>
    spring.datasource.password=<password>
    spring.datasource.driverClassName=org.postgresql.Driver
    spring.jpa.hibernate.ddl-auto=create-drop
    ````
  - add database to datasource to explore schema from intellij itself
  - to test create any entity and run app and see if the table for entity is created in db or not
  - DB can also be configured progamatically and other ways

---