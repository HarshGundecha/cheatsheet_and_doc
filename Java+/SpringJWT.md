UNFINISHED



https://www.youtube.com/watch?v=7Q17ubqLfaMx

- create basic app
- add spring boot starter security and jjwt dependency
- generating JWT
	-	on accessing /authenticate with valid user & pass a JWT will be returned
-	validating JWT
	-	on each secured request above generated JWT will be passed
-	create a config package
	-	add a TokenUtil class for
		-	generating JWT
		-	validating JWT
		-	extracting info from JWT
-	create jwtuserdetailsservice class that extends usedetailsservice of spring security
	-	override loaduserbyusername
		-	this is where the user will be fetched from the DB to check validity
-	create JWTAuthenticationController for mapping/accessing "/authenticale" api
	-	createAuthenticationToken
		-	checks user creds by calling authenticate method and generates token by getting user details from creds provided

-	create JWTRequest and JWTResponse model

-	create JETRequestFilter in config that extends spring web filter OncePerRequestFilter
	-	extracts token
	-	calls validatetoken() from tokenutil
-	create JWTAuthenticationEntryPoint class in config
	-	it rejects and sends error code 401 to all unauthorised requests

-	create WebSecurityConfig class in config 
	-	it provides userdetails service to security manager
	-	configures hashing method
	-	configures security of all endpoints




-	JWTrequestfiler
-	authenticationcontroller
-	JWTUserDetailsService
-	JwtTokenUtil - generateToken


