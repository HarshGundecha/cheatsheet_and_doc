- [Springboot MS configuration](#springboot-ms-configuration)
  - [goals | why config management.](#goals--why-config-management)
  - [what kind of config](#what-kind-of-config)
  - [solution - config management system](#solution---config-management-system)
    - [setting - types (least to most preferred)](#setting---types-least-to-most-preferred)
      - [setting properties by basic file](#setting-properties-by-basic-file)
      - [setting properties by spring profiles](#setting-properties-by-spring-profiles)
      - [setting properties by cloud config](#setting-properties-by-cloud-config)
    - [getting properties in spring](#getting-properties-in-spring)
- [references](#references)

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

## solution - config management system

### setting - types (least to most preferred)

#### [setting properties by basic file](setting_properties_by_basic_file.md)
#### [setting properties by spring profiles](setting_properties_by_spring_profiles.md)
#### [setting properties by cloud config](setting_properties_by_cloud_config.md)

### [getting properties in spring](getting_properties_in_spring.md)

# references
- [Spring Boot Microservices Level 3: Microservice configuration](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTaoaVoQVfRJPqvNTCjcTvJB)
- [A Quick Guide to Spring @Value](https://www.baeldung.com/spring-value-annotation)
- [Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config)
- spring expression language - SPeL 