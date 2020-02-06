- [hystrix](#hystrix)
	- [Introduction](#introduction)
	- [Implementation](#implementation)
	- [Behind the scenes - How does it work](#behind-the-scenes---how-does-it-work)
- [References](#references)

# hystrix

## Introduction
- open source library originally deevloped by netflix
- implements CB pattern so we dont have to
- give it the parameters and it does the work
- works well with spring boot
- not activately developed (but still works and is in maintainance mode)
- due to its limitation which is same as Circuit Breaker [Limitations](../../../design_patters_&_architectures/microservices+.md#limitations) people are moving towards adaptive fault tolerance

## Implementation
- add spring-cloud-started-nttflix-hystrix dependency
- enable CB
  - add `@EnableCircuitBreaker` annotation to application's main class
- apply CB to methods
  - add `@HystrixCommand` to methods that need circuit breakers
- configure hystrix behaviour, i.e, configure when to break
  - for now go with the defaults i.e dont need to do anything
- add fallback mechanism
  - configure `@HystrixCommand` annotation as follows
	````java
	//...
	@HystrixCommand(
		fallbackMeatho="getFallbackResponse"
	)
	public Object someMethod(){
		// a method for which CB is implemented
	}
	// name of method to call, may contain logic to return cached or default response 
	// should have same method signature as the mthod where it is applied
	// shouldn't be making call to others else the fallback might need a fallback :p
	// quickly manual test by killing one of the MS that is depends on, not for prod, for prod do proper testing

	//...
	```` 
- further read
  - [hystrix implementation playlist](https://www.youtube.com/watch?v=SvZ98jLVdM8&list=PLqq-6Pq4lTTbXZY_elyGv7IkKrfkSrX5e&index=15)
  - [hystrix circuit breaking configuration](https://github.com/netflix/hystrix/wiki/configuration)
- you could also follow bulkhead pattern for limiting each service to a specific thread pool size so that if one freezes others dont get affected
  - read more at [The bulkhead pattern](https://youtu.be/Kh3HxWk8YF4)
- get a nice hystrix dashboard showing live info of service at [Hystrix Dashboard](https://youtu.be/WfsomLHaSzQ)

## Behind the scenes - How does it work
- hystrix wraps the actual api class+CB in a proxy class
- keeps constant watch on whatever the parameters are there to detect problems
- if it smells something wrong, calls fallback method

# References
- [Spring Boot Microservices Level 1: Communication and Discovery](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas)

- [Spring Boot Microservices Level 2: Fault Tolerance and Resilience](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTbXZY_elyGv7IkKrfkSrX5e)