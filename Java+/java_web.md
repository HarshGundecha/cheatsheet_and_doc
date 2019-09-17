# TERMINOLOGIES
- ## java
  - JDBC - java's build in database connectivity driver
  - JPA - a framework that map relational database entities to java objects and persist them
    - entity manager - an object per entity that will perform crud operations for that entity
  - JPQL - sql like JPA query language
  - JTA - framework for transaction management that provides atomicity
  - repository - a directory that contains all the files that contains all the functions that performs business logic as crud operations, functions defined here are later used for serving user requests
	- annotations - provides meta data to the contexts
	- bean validation - used for validation in components
  	- annotations fo rvalidations
	- context dependency injection
	- JAX-RS - 

- ## tools and tech
	- maven - java ee build toool
  	- maven archetype - cli tool that helps generates java ee directory structure and few required files
	- wildfly	 - java runtime environment which hosts application
	- h2 - in memory lite and embedded database(development use only)
	- junit - tool for unit testing in java
	- arquillian - tool for integration testing
	- shrinkwrap - creates deployable archives, used for arquillian test deployement
	- spring - java web development MVC framework
	- spring boot - spring framewrok to ease spring's configuration and make spring run out of the box with almost zero configuration
	- hibernate - orm framework for relational DB
	- open api specification
	- swagger
---

# java ee deployement process
- ## manual
  - build project
  - package it in a .war file
  - start wildfly server and open it in browser
  - go to deployements and upload .war file there

- ## automatic (automation of above)
  - to enable auto update .war on each run/deploy, configure intellij to automatically pack and put .war file at required  path
  - refer pularsight video for exact "how to"

---



- ## Open API Specification(OAS)
  - open API documentation standard supported by linux foundation

- ## Swagger
  - helps in generating json based api documentation
  - uses Open API Specification(OAS) as a standard format for documentation
  - to be able to do so it uses a few additional annotations apart from already described ones in the EntityEndpoint of java REST api classes
  - java even have swagger specific annotations for describing API with proper information
  - documentation can include things like URI, parameters, response codes, response entities etc

seperate class suffixed with EndPoint that serves as rest EndPoint and reuses Book repository under the hood


# Spring
- spring is a umbrella project
- there are multiple projects under spring like data, secutity, core etc found at [Spring projects](https://spring.io/projects)
- spring boot is at top of these multiple projects
- spring cloud is at top of spring boot
- you can start a preconfigured spring boot app from [Start Spring project](https://start.spring.io)


# parts of spring
we put each different type of file in their respective packages
for e.g, controller, repository, model in their own packages (i.e also a seperate directory)
table or entity structure and getter and setter in model
db basic crud operation in dao
db relate dother functions in repository
business logic in controller which also uses methods defined in DAO
JSP = view of codeigniter


---

spring.io/projects
start.spring.io 

