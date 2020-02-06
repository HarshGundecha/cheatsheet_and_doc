- [Terminologies used](#terminologies-used)
- [MS related concepts and their implentations](#ms-related-concepts-and-their-implentations)
  - [Circuit Breaker pattern](#circuit-breaker-pattern)
    - [why CB are needed](#why-cb-are-needed)
    - [Identifying break/CB open parameter](#identifying-breakcb-open-parameter)
    - [Response in case of broken state(fallback mechanisms)](#response-in-case-of-broken-statefallback-mechanisms)
    - [Limitations](#limitations)
    - [Identifying unbreak/CB close parameter(reset parameter)](#identifying-unbreakcb-close-parameterreset-parameter)
- [References](#references)

---

# Terminologies used
- **MS** - Microservice(s)
- **CB** - Circuit Breaker

---

# MS related concepts and their implentations
- MS Discovery
  - eureka
  - service discovery pattern
  - happens via discovery server
- [Circuit Breaker pattern](#circuit-breaker-pattern)
  - [hystrix](../Java+/web/microservices/hystrix_spring_circuit_breaker.md)
- API Gateway
- versioning of MS
- adaptive fault tolerance
- Client side Load balancer
  - ribbon
- Log tracing
  - sleuth
- API Gateway
  - zuul
  - appigee ?
- CDN
  
## Circuit Breaker pattern

### why CB are needed
- if we are about to fail, why not fail fast
- in lack of CB the users will keep waiting and refreshing the page or resending the request which makes system even slow when theres something is wrong
- ultimately system will die in absence of CB
- can provide fall back functionality
- automatic recovery
- you could follow bulkhead pattern for limiting each service to a specific thread pool size so that if one freezes others dont get affected

### Identifying break/CB open parameter
- find a parameter by which we can identify when to break the circuit(normal flow)
- examples of parameter
  - how to decide a request has failed
    - set timeout duration, after which the request is said to be failed
	- when to break
    - decide from failure last n request
      - decide on basis of how many request from last n should fail

- usually in real world application the parameters are crafted out of trial and error based on the capacity of resource, load and other things(basically it's tailor made or is fine tuning thing).

### Response in case of broken state(fallback mechanisms)
- possible fallbacks (in order of less useful to more useful)
  - throw an error (not a good strategy)
  - have a default response
  - use cache from previous responses (obviosly not preferred for mission critical applications like banking)
    - can use default in case of cache miss

### Limitations
- you may need to continuesly keep in check all the parameters in applications lifecycle
- solution
  - adaptive fault tolerance
	
### Identifying unbreak/CB close parameter(reset parameter)
- find a parameter by which we can identify when to reset(continue) the circuit(normal flow)
- Example parameter
  - how long to wait before trying to re-communicate the said MS
  - can it be that the said service send heart beats when it is up ?

---

# References
- [Spring Boot Microservices Level 1: Communication and Discovery](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas)

- [Spring Boot Microservices Level 2: Fault Tolerance and Resilience](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTbXZY_elyGv7IkKrfkSrX5e)

- [What is an API Gateway?](https://www.youtube.com/watch?v=vHQqQBYJtLI)

- [Design Pattern using Java](https://www.youtube.com/playlist?list=PLd0lZIptCEwOplc9fZ8rv5yj-Vo7C6q7k)

- [NetflixTechBlog - Performance Under Load](https://medium.com/@NetflixTechBlog/performance-under-load-3e6fa9a60581)

- [medium articles](https://medium.com/@GaryStafford)
- https://medium.com/@GaryStafford/part-1-using-eventual-consistency-and-spring-for-kafka-to-manage-a-distributed-data-model-5345f601814d
- https://medium.com/@GaryStafford/part-2-using-eventual-consistency-and-spring-for-kafka-to-manage-a-distributed-data-model-7575d68ad8c1
