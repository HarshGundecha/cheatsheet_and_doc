- [System Artchitectures](#system-artchitectures)
  - [Context](#context)
  - [Problem](#problem)
  - [Forces](#forces)
  - [Solution](#solution)
    - [Monolithic architeture solution](#monolithic-architeture-solution)
      - [Resulting context](#resulting-context)
        - [Benefits](#benefits)
        - [Limitations](#limitations)
    - [Microservices architeture Solution](#microservices-architeture-solution)
      - [Resulting context](#resulting-context-1)
        - [Benefits](#benefits-1)
        - [Limitations](#limitations-1)
- [References / Further reading](#references--further-reading)

# System Artchitectures

## Context
- You are developing a server-side enterprise application.
- It must support a variety of different clients including desktop browsers, mobile browsers and native mobile applications.
- The application might also expose an API for 3rd parties to consume. 
- It might also integrate with other applications via either web services or a message broker.
- The application handles requests (HTTP requests and messages) by executing business logic; accessing a database; exchanging messages with other systems; and returning a HTML/JSON/XML response.
- There are logical components corresponding to different functional areas of the application.

## Problem
- What’s the application’s deployment architecture?

## Forces
- There is a team of developers working on the application
-New team members must quickly become productive
- The application must be easy to understand and modify
-You want to practice continuous deployment of the application
- You must run multiple instances of the application on multiple machines in order to satisfy scalability and availability requirements
- You want to take advantage of emerging technologies -(frameworks, programming languages, etc)

## Solution

### Monolithic architeture solution
- Build an application with a monolithic architecture.
- For example:
  - a single Java WAR file.
  - a single directory hierarchy of Rails or NodeJS code

#### Resulting context

##### Benefits
- Simple to develop - the goal of current development tools and IDEs is to support the development of monolithic applications
- Simple to deploy - you simply need to deploy the WAR file (or directory hierarchy) on the appropriate runtime
- Simple to scale - you can scale the application by running multiple copies of the application behind a load balancer

##### Limitations
- The large monolithic code base intimidates developers, especially new ones.
- The application can be difficult to understand and modify
- Larger the code base = Overloaded IDE = slower IDE
- Overloaded web container - the larger the application the longer it takes to start up.
- In order to update one component you have to redeploy the entire application, this maked continuous deployement difficult
- in case of failure of new integrations or experiments the whole applications needs to be redeployed everytime unless everything works
- in case of deployements to multiple machines Each copy of application instance will access all of the data, which makes caching less effective and increases memory consumption and I/O traffic.
- different application components have different resource requirements - With a monolithic architecture we cannot scale each component independently
- Obstacle to scaling development, better if seperate teams were able to work independently without breaking productions and a lot of redeployements on each fix
- Requires a long-term commitment to a technology stack, since the whole system is on single artifact

### Microservices architeture Solution
- Define an architecture that structures the application as a set of loosely coupled, collaborating services. This approach corresponds to the Y-axis of the Scale Cube. **Each service is**:
  - Highly maintainable and testable - enables rapid and frequent development and deployment
  - Enables a team to work independently on specific service
  - Independently deployable
  - Capable of being developed by a small team
  - Services communicate using either synchronous protocols such as HTTP/REST or asynchronous protocols such as AMQP.
  - Each service has its own database in order to be decoupled from other services.
  - Data consistency between services is maintained using the [Saga pattern](https://microservices.io/patterns/data/saga.html)

#### Resulting context

##### Benefits
- Enables the continuous delivery and deployment of large, complex applications.
- Improved maintainability, as easier to understand and modify
- Better testability, smaller = faster to test
- Better deployability, services can be deployed independently
- It enables you to organize the development effort around multiple, autonomous teams.
- The IDE is faster making developers more productive
- The application starts faster, which makes developers more productive, and speeds up deployments
- Improved fault isolation. For example, if there is a memory leak in one service then only that service will be affected. The other services will continue to handle requests, In comparison, one misbehaving component of a monolithic architecture can bring down the entire system.
- Eliminates any long-term commitment to a technology stack. When developing a new service you can pick a new technology stack. Similarly, when making major changes to an existing service you can rewrite it using a new technology stack.

##### Limitations

- Developers must deal with the additional complexity of creating a distributed system
  - Developers must implement the inter-service communication mechanism and deal with partial failure
  - Implementing requests that span multiple services is more difficult and requires careful coordination between the teams
  - Testing the interactions between services is more difficult
  - Developer tools/IDEs are oriented on building monolithic applications and don’t provide explicit support for developing distributed applications.
- Deployment complexity. In production, there is also the operational complexity of deploying and managing a system comprised of many different services.
- Increased memory consumption.
  - The microservice architecture replaces N monolithic application instances with NxM services instances. If each service runs in its own JVM (or equivalent), which is usually necessary to isolate the instances, then there is the overhead of M times as many JVM runtimes. Moreover, if each service runs on its own VM (e.g. EC2 instance), as is the case at Netflix, the overhead is even higher.


# References / Further reading
- [Monolithic Architecture](https://microservices.io/patterns/monolithic.html)
- [Microservices Architecture](https://microservices.io/patterns/microservices.html)