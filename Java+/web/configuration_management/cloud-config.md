- [cloud config](#cloud-config)
  - [solutions](#solutions)
    - [spring cloud config server - most widely used with spring](#spring-cloud-config-server---most-widely-used-with-spring)
    - [apache zookeeper](#apache-zookeeper)
    - [ETCD - distributed key value store](#etcd---distributed-key-value-store)
    - [hashicorp consul](#hashicorp-consul)
- [references](#references)

# cloud config
- a whole separate service for profiving config to all services with all the goals of config management met
- so its basically like, there is config server and then client services that needs access to configs

## solutions

### spring cloud config server - most widely used with spring
- it connects to a git repo
- which in turn consists of all the config files to be provided to the client services 
- in case of changes just make changes and push to repo and KaBoOm you're done

### apache zookeeper

### ETCD - distributed key value store

### hashicorp consul

# references