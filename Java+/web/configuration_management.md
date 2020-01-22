- [Springboot MS configuration](#springboot-ms-configuration)
  - [why needed](#why-needed)
  - [what kind of config](#what-kind-of-config)
  - [solution - config management system](#solution---config-management-system)
    - [Types (most to least verbose)](#types-most-to-least-verbose)
      - [xml](#xml)
      - [properties files](#properties-files)
      - [json](#json)
      - [yaml](#yaml)
    - [Goals](#goals)
- [`application properties`](#application-properties)
  - [externalising config](#externalising-config)
  - [examples](#examples)
- [references](#references)
  - [Spring Boot Microservices Level 3: Microservice configuration](#spring-boot-microservices-level-3-microservice-configuration)
  - [A Quick Guide to Spring @Value](#a-quick-guide-to-spring-value)
  - [Externalized Configuration](#externalized-configuration)
  - [spring expression language - SPeL](#spring-expression-language---spel)

# Springboot MS configuration

## why needed
- seperation between business logic and various types of config
- most of this config should be such that changes could be made on the go wothout needing redeployements i.e dynamic configs

## what kind of config
- springboot's own configuration
- DB connections
- feature flags to twaek features like
  - toggle a feature on the go without needing new deployements
  - experimenting with features
- business logic config could happen at
  - different ways
    - DB level
    - using external property files
  - why needed
    - to test for example various offers
    - test how to provide a service with various combinations

## solution - config management system
### Types (most to least verbose)
#### xml
#### [properties files](#application-properties)
#### json
#### yaml
  
### Goals
- real time config management
- externalising config from business logic
- for config to be env specific
- consistency across env, services and whole system
- version history for tracking changes


# `application properties`

## externalising config
- all the config done above still resides in a fat JAR only
- following is a way to externalise it where different env like prod & dev could pass diff configs 
1. we can override specific property in build command itself
2. we can pass whole `application.properties` file to override the default internal one
3. we can use OS env variables too
4. we can mix any or most of above

## examples
````properties

firstName = john
lastName =doe
fullName = ${firstName} ${lastName}
listOfNaturals = 1,2,3
productSpecs = {brand:'gogle', model:'pixel 3XL' }
````

````java
@value("some static value")
private String staticValueString;

@value("${firstName}")
private String firstNameFromProperty;

@value("${firstName:jack}")
private String firstNameFromPropertyWithDefaultValue;

@value("${fullName:jack ma}")
private String nameFromPropertyWithinProperty;

@value("${listOfNaturals}")
private List<Integer> listOfNaturalsFromProperty;

@value("#{${productSpecs}}")
private Map<String, String> productSpecsFromProperty;

````

# references
## [Spring Boot Microservices Level 3: Microservice configuration](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTaoaVoQVfRJPqvNTCjcTvJB)
## [A Quick Guide to Spring @Value](https://www.baeldung.com/spring-value-annotation)
## [Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config)
## spring expression language - SPeL 