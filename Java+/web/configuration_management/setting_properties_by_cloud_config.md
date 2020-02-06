- [cloud config](#cloud-config)
  - [solutions](#solutions)
    - [spring cloud config server](#spring-cloud-config-server)
      - [setting property in server](#setting-property-in-server)
        - [testing access to config server](#testing-access-to-config-server)
      - [spring cloud config client / accessing properties in client](#spring-cloud-config-client--accessing-properties-in-client)
      - [change configuration](#change-configuration)
      - [reflecting new changes in client without redployement](#reflecting-new-changes-in-client-without-redployement)
    - [apache zookeeper](#apache-zookeeper)
    - [ETCD - distributed key value store](#etcd---distributed-key-value-store)
    - [hashicorp consul](#hashicorp-consul)
- [references](#references)

# cloud config
- a whole separate service for providing config to all services with all the goals of config management met
- so its basically like, there is config server and then client services that needs access to configs

## solutions

### spring cloud config server
- central management for config. via GIT, SVN or HashiCoop Vault for config storage

#### setting property in server
- add dependency of `spring-cloud-config-server`
- or go to `start.spring.io` and create a project with **config server**
- add `@EnableConfigServer` to main class
- for doing this via git do following
  - add `spring.cloud.config.server.git.uri=<git_url>` to application properties
- create an application property file inside repo and commit changes
- most of the things described here [configuration management - setting types least to most preferred](configuration_management.md#setting---types-least-to-most-preferred) applies
- to make configuration specific to a microservice, create a file named after microservice's name (artifact-id)
  - for e.g., `poll-app.properties`
  - also add `spring.application.name=<poll-app>` to client microservice
- same as usual the default or glabal properties should reside in default properties file

##### testing access to config server
- you can test how to access property by `<config_server_host:port>/<confil_file_name_without_ext>/<profile>`
- for example
  - `localhost:8888/application/default`

#### spring cloud config client / accessing properties in client
- add dependency of `spring-cloud-starter-config`
- also needs a parent depencdency that specifies version and other stuff, have a look by creating a project as below
- or go to `start.spring.io` and create a project with **config client**
- add `spring.cloud.config.uri=<git_url>` to application properties of client
- now you can fetch properties from server same as fetching local properties
  - for more details on fetching properties have a look at [accessing_properties_in_spring](../configuration_management/accessing_properties_in_spring.md)

#### change configuration
- make a change in property files of repo
- commit
- push

#### reflecting new changes in client without redployement
- if you access server it can immediately reflect changes without needing restart reason being eveythime you acess that it pulls values from file, so its always up to date
- since the client app loads the properties once on boot, it cannot detect the changes on the fly to do so we need to do following configuration
1. you need `spring-boot-started-actuator` in client app which exposes an POST endpoint like `<poll-app-host:port>/actuator/refresh` which when invoked tells app to pull latest properties from config server
2. this alone is not enough, doing so will not updates all the beans or classes that use those properties
3. to make it happen we need to at `@RefreshScope` to all the beans or classes that you want to get updated properties when that enpoint is invoked 
- and with this we have achieved of config management

### apache zookeeper
### ETCD - distributed key value store
### hashicorp consul




# references
- [best_practices-config_management](best_practices-config_management.md)