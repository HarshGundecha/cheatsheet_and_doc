- [Springboot MS configuration](#springboot-ms-configuration)
  - [goals | why config management.](#goals--why-config-management)
  - [what kind of config](#what-kind-of-config)
  - [solution - config management system (least to most preferred)](#solution---config-management-system-least-to-most-preferred)
    - [differet approaches to set properties- (least to most advantageous)](#differet-approaches-to-set-properties--least-to-most-advantageous)
      - [setting_properties_in_spring_multiple_aproaches](#settingpropertiesinspringmultipleaproaches)
      - [spring profiles](#spring-profiles)
      - [cloud config](#cloud-config)
    - [accessing properties in spring](#accessing-properties-in-spring)
- [notes](#notes)
- [references](#references)
  - [Spring Boot Microservices Level 3: Microservice configuration](#spring-boot-microservices-level-3-microservice-configuration)
  - [A Quick Guide to Spring @Value](#a-quick-guide-to-spring-value)
  - [Externalized Configuration](#externalized-configuration)
  - [spring expression language - SPeL](#spring-expression-language---spel)

# Springboot MS configuration

## goals | why config management.
1. externalising config from business logic
2. for config to be env specific
3. version history for tracking changes
4. consistency across env, services and whole system
5. real time config management

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

## solution - config management system (least to most preferred)

### differet approaches to set properties- (least to most advantageous)

#### [setting_properties_in_spring_multiple_aproaches](configuration_management/setting_properties_in_spring_multiple_aproaches.md)
#### [spring profiles](configuration_management/spring_profiles.md)
#### [cloud config](configuration_management/cloud-config.md)

### [accessing properties in spring](configuration_management/accessing_properties_in_spring.md)

# notes
- separate declaring properties and getting/using properties in notes and examples
- restructure this doc

# references
## [Spring Boot Microservices Level 3: Microservice configuration](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTaoaVoQVfRJPqvNTCjcTvJB)
## [A Quick Guide to Spring @Value](https://www.baeldung.com/spring-value-annotation)
## [Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config)
## spring expression language - SPeL 