# rest api framework

- ## api structure
	_________________________________________________________
	|	method	|					url				|					action					|
	|---------|-------------------|-------------------------|
	|	GET			| eg.com/entity/		|	list objects						|
	|	POST		| eg.com/entity/		|	add an object						|
	|	GET 		| eg.com/entity/id/	|	get specified object 		|
	|	PUT 		| eg.com/entity/id/	|	update specified object	| 
	|	DELETE	| eg.com/entity/id/	|	delete specified object |
	_________________________________________________________

- ## methods


- ## rest status codes
	- https://www.django-rest-framework.org/api-guide/status-codes/

- ## formatting API
	- making API browsable
	- supporting .json urls
	- ...

- ## urls
  - generally we will define this 2 url pattern **per entity**, except in case of using router
    - one that points to /entity/
    - one that points to /entity/id/
  - depending upon request type and url accessed the specific view method or class.method will be invoked

-	## authentication

	- ### BasicAuthentication
		-	in this method the API users are supposed to pass username and password in url itself
		- must not be used in production
		- example usage
			```bash
			http -a admin:password123 POST http://127.0.0.1:8000/snippets/ code="print(789)"
			# or
			http POST http://127.0.0.1:8000/snippets/ username="admin" password="password123" code="print(789)"
			```

	- ### Token Based Auth
		1. add auth package to installed app, do following
			-	update `INSTALLED_APPS` list in **projects's** settings.py by **appending** following code
				```py
				'rest_framework.authtoken',
				```

		2. set defualt authentication method to token based authentication and also set permission class to IsAuthenticated, so UnAuthenticated users cant access API, do following
			-	update `REST_FRAMEWORK` dictionary in **projects's** settings.py by **appending** following code
				```py
				'DEFAULT_AUTHENTICATION_CLASSES':['rest_framework.authentication.TokenAuthentication'],
				'DEFAULT_PERMISSION_CLASSES':['rest_framework.permissions.IsAuthenticated'],
				```
			- **note:** this sets the permission and auth at project level, although this could also be done at app level or even at view level

		3. to let users create a access token by passing username and password via POST request, create following url endpoint
			-	update **project's** urls.py by **appending** following
				```py
				from rest_framework.authtoken import views
				urlpatterns += [path('api-token-auth/', views.obtain_auth_token)]
				```
			- **make sure** to run manage.py migrate after changing your settings.py, The rest_framework.authtoken uses database for managing tokens.

		4. test by accessing from terminal using httpie or something similar in following way
			```bash
			http POST http://127.0.0.1:8000/api-token-auth/ username="<registered-uername>" password="<registered-password>"
			```
			-	if the creds are valid you would get token, else an error messsage

		5. once you get token in response, test api access as below
			```bash
			http http://127.0.0.1:8000/snippets/ "Authorization: Token <your-token-here>"
			```
			-	now you should be able to get the appropriate reponse

- ## permissions
  - builtin permission classes
  - custom permissions
	- level(needs R&D)
    - app level
    - view level
    - ...

- ## serializers
  - Serializer
  - ModelSerializer
  - HyperlinkedModelSerializer
  - ...

- ## views

  1. ### function based views
		- works by mapping multiple request type to one function and differentiating code by checking method type using `request.method`
  		- generally here we create 2 function
  			- 1st for list and add, generally named `<model>_list()`
  			- 2nd for detail, update and delete, generally named `<model>_detail()`
		- we **explicitly** need to write code(logic part) for all methods

  2. ### class based views
		- works by defining methods named as request type, i.e, defining `get()` for `GET` request, need to define a function for each request type
		- generally here we create 2 classes that extends APIView
			- 1st for list and add by defining `get()` and `post()` methods in class named `<Model>List`
			- 2nd for detail, update and delete by defining `get()`, `put()` & `delete()` methods in class named `<Model>Detail`
		- difference between this and function based views
			- function are transalated to classes
			- if conditions of method check are translated to methods of class
		- but we still **explicitly** need to write code(logic part) for all methods

  3. ### mixin based views
		- generally here we create 2 classes that extends multiple `mixins.*` and GenericAPIView class
			- 1st for list and add by defining `get()` and `post()` methods in class named `<Model>List`
			- 2nd for detail, update and delete by defining `get()`, `put()` & `delete()` methods in class named `<Model>Detail`
		- difference between this and class based views
			- we **don't need to write** logical part(like get data, validate, if correct insert etc) of code for all methods
			- handles all the work implicitly
	
	4. ### generic class based views
		- generally here we create 2 classes that extends `generics.*APIView` class
			- 1st for list and add by defining class named `<Model>List`
			- 2nd for detail, update and delete by defining class named `<Model>Detail`
		- difference between this and mixin based views
			- we **don't even need to define individual methods**, just 2 classes, 0 methods and done
			- handles all the work implicitly

	5. ### view sets
		- generally here we create 1 class for object named `<Model>ViewSet` that handles everything automatically
		- difference between this and mixin based views
			- we **need to define only 1 class**, just 1 class, 0 method and done
			- handles all the work implicitly
			- we also need not to define url path, we use router which takes care of all itself, although  we need to register each ViewSet with router bur rest will  be taken care implicitly
			- if you dont use router while using viewsets you will have to define each and every route manually unlike defining only 2 routes as in above cases

# advanced

- ## caching
@method_decorator(cache_page(60*60*2))
@method_decorator(vary_on_cookie)
The cache_page decorator only caches the GET and HEAD responses with status 200.
The cache_page decorator only caches the GET and HEAD responses with status 200.

put the decorators above get and head view methods

- ## throtlling
https://www.django-rest-framework.org/api-guide/throttling/




# others
whenever data arrivers, it is in json so parse it to serializer
check validity
and depending upon validity either save or return errors

whenever data is requested 
fetch object
parse it to serializer
parse it to JSON
return
