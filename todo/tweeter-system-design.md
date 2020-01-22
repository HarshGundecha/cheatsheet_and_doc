- [tweeter system design](#tweeter-system-design)
	- [Concepts to use](#concepts-to-use)
		- [programming / spring](#programming--spring)
		- [other tech](#other-tech)
			- [microservices](#microservices)
				- [user management](#user-management)
				- [blog management](#blog-management)
				- [media management](#media-management)
				- [notification management](#notification-management)
			- [API gateway](#api-gateway)
			- [data related](#data-related)
			- [other](#other)
		- [both of above](#both-of-above)

# tweeter system design

## Concepts to use

### programming / spring
- tests
- spring cloud
- functional programming
- universal exception handling
- DTO or DAO
  - try.of by using functionalprogramming
- lambda, streams and filters
- reactive programming ?, rxJava ?
- prefer webclient instead of restteamplate
- 

### other tech

#### microservices

##### user management
- social media
- native mail and phone based
- user search

##### blog management
- feeds
- posting

##### media management
- CRUD for photo/music/video

##### notification management
- sms
- mailing
- app notifications / pub sub / FireBase

#### API gateway
- load balancing
- traffic splitting
- canary builds
- A/B testing

#### data related
- graphql for serving multiple clients
- caching
- elasticsearch
- NoSql - try DynamoDB
- CDN

#### other
- design patterns
- social login
- multi env setup(dev, staging, prod)
- config management
- CI/CD
- API versioning
- GIT multi branch setup
- planning for rollback before deploying new versions of APIs
- jira
- containerisation
- orchestration
- istio
- cloud functions
  
### both of above
- logging
  - stored somewhere in cloud storage
- circuit breaking
- service discovery