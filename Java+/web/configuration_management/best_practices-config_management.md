- [Best practices](#best-practices)
  - [Configuration Strategies-best practices](#configuration-strategies-best-practices)
  - [securing spring cloud server](#securing-spring-cloud-server)
    - [what to secure](#what-to-secure)
    - [how to secure](#how-to-secure)
  - [use of defaults for quick local setup](#use-of-defaults-for-quick-local-setup)

# Best practices
## Configuration Strategies-best practices
- microservice specific and not likely to change
  - use - local property file
- microservice specific and often changes
  - use - config server
- using microservices with environment config providers like hosting providers or other
  - use - System variables in property files with alias
    - the reason for alias are
      - same naming convention across services
        - as you set your alias once and then use them everywhere
      - even if some variables that depends on 3rd party like hosting provider changes, we just need to changes at alias for once and all
  - for e.g.,
````properties
host.environment.port:8080 
# property gievn by hosting provider that you want to use
env.port: ${host.environment.port}	# create alias
server.port: ${env.port}	# use alias everywhere

# now imagine your provide changes and so does environment variable
# no worry just update the alias
````
## securing spring cloud server
- configure spring cloud server with spring security be it basci or jwt or some other auth
### what to secure
	- credentials 
  - connection strings
  - API keys

### how to secure
- use encrypted version of critical data
- for e.g.,
- `password:'{cipher}bcpwier74gw028eva03n4e3vemw9842kf7wsj9f'`
- this works as sprinf cloud server has capability to encrypt and decrypt strings
- process
  - while storing you generare encrypted values and keep them in repo
  - when a service asks for values, the sever can detect that it is encrypted and hence decrypts them and sends them to client


## use of defaults for quick local setup
- for e.g.,
  - `config.uri:http://localhost:${config.port}`
- while the above works fine when deployed but causes delay for new joiner in starting work as the joinee will have to configure X different values that are configured on server
- so the solution is use defaults alongwith those values as below
  - `config.uri:http://localhost:${config.port:8888}`
    - here 8888 is default port
    - so in case of local development in absence of config.port it will fallback to 8888