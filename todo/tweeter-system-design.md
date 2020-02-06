- [notations](#notations)
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
- [references](#references)

# notations
- italic lines means there's not much clarification on how and where to implement that thing.

# tweeter system design

## Concepts to use

### programming / spring
- testing
  - unit
  - integration
  - load
- spring cloud
- *functional programming*
- universal exception handling
- *DTO or DAO*
  - try.of by using functionalprogramming
- lambda, streams and filters
- *reactive programming ?, rxJava ?*
- prefer webclient instead of restteamplate
- lombok with builders
- inter service communication auth or no auth ?
- public facing MS or coordinator MS that talks to others ?

### other tech

#### microservices

##### user management
- social media
- native mail and phone based
- user search

##### blog management
- feeds
- posting
- configurable things
  - tweet length
  - media specs like size and count limit
- queue
  - put likes, tweets & retweets in queue ?

##### media management
- CRUD for photo/music/video

##### notification management
- sms
- mailing
- app notifications / pub sub / FireBase

#### API gateway
- *choose from either of* 
  - *zuul2, spring cloud, nginx, apigee* 
- *load balancing*
- *traffic splitting*
- *canary builds*
- *A/B testing*

#### data related
- [GraphQL and Java & Spring](https://youtu.be/iHxu2bq3fxI)
- *caching*
- *elasticsearch*
- NoSql for feeds MS - try DynamoDB
- MySql for rest MS
- *CDN*

#### other
- API doc
  - swagger
  - spring rest docs
- design patterns
- *social login*
- multi env config setup(dev, staging, prod) - config management
- *CI/CD*
- API versioning
- GIT multi branch setup
- planning for rollback before deploying new versions of APIs
- jira
- *containerisation*
- *orchestration*
- istio
- *cloud functions*
  
### both of above
- *logging using zipkins or something similar*
  - stored somewhere in cloud storage
- circuit breaking
- *service discovery*

# references
- [Mostodon - open source similar system](https://github.com/tootsuite/mastodon)