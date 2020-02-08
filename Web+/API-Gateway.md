- [API Gateway](#api-gateway)
  - [helps in](#helps-in)
    - [security](#security)
    - [routing](#routing)
    - [adaptor, a single endpoint which can make calls to](#adaptor-a-single-endpoint-which-can-make-calls-to)
    - [caching](#caching)
    - [adaptor for cross protocol](#adaptor-for-cross-protocol)
- [References](#references)

# API Gateway
- acts as a front layer between backend and client/user/broswer etc
- removes the responsibility of auth and other things from all MS to single gateway

## helps in

### security
- authentication
- authorization, check for expected user role against url requested
- ssl termination, ensures that requests are HTTPS
- DDoS protection/throttling
- thus can also possibly let microservices communicate with each other with low to no authentication/JWT hell as MS will reside behind the API Gateway

### routing
- routing, all requests hit API Gateway and gateway contains logic to route request to appropriate service

### adaptor, a single endpoint which can make calls to
  - static content, a component inside gateway itself for serving static content thus doesnt need separate service for that
  - user info service
  - order service
  - and then consolidate the response from all and return to client, eliminating multiple calls for client

### caching
- cache for quicky serving same requests

### adaptor for cross protocol 
- can convert request from newer protocols like http2 and still serve by invoking service using http1

- load balancer
- A/B testing
- canary release
- can also allow other business to access your service an keep track of usage quota and all

# References
- [What is an API Gateway?](https://www.youtube.com/watch?v=vHQqQBYJtLI)
- Appigee
- Istio