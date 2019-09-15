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

