- [Terminologies](#terminologies)
- [Tools](#tools)
	- [basic](#basic)
	- [advanced](#advanced)
- [Django_flow](#djangoflow)
	- [project setup](#project-setup)
		- [initiate project and an app](#initiate-project-and-an-app)
		- [configure project by updating project's settings.py](#configure-project-by-updating-projects-settingspy)
	- [models](#models)
		- [models define the entities and its members (i.e database table and its attributes)](#models-define-the-entities-and-its-members-ie-database-table-and-its-attributes)
	- [migrations](#migrations)
	- [url_mapping](#urlmapping)
	- [views](#views)
		- [views define the `function` or `class` that is invoked upon accessing a specific url defined in urls.py](#views-define-the-function-or-class-that-is-invoked-upon-accessing-a-specific-url-defined-in-urlspy)
	- [templates](#templates)
	- [testing](#testing)
		- [Things to test](#things-to-test)
		- [models](#models-1)
		- [views](#views-1)
		- [forms ???](#forms)
		- [running tests](#running-tests)
	- [admin_site](#adminsite)
	- [register model for admin site controls](#register-model-for-admin-site-controls)
	- [customise admin site(optional)](#customise-admin-siteoptional)
	- [create admin/superuser from CLI](#create-adminsuperuser-from-cli)
- [Undefined](#undefined)
- [Doubts/queries](#doubtsqueries)

# Terminologies
- app - standalone plugable package/module
	- an app acts as a package which can be shipped
- project - contains >=1 app
	- i.e, a peojct contains multiple plugable apps

# Tools
## basic
- `python manage.py <CommandName>` , command to perform various tasks   in django from CLI
- (make an alias for `python manage.py <CommandName>` to shorten  it to something like `pym <CommandName>`)
- `virtualenv` (compulsorily to be used) - virtual python environment, do more R&D
- `pip` , `setuptools` command line django utilities that eases development
- `python manage.py shell` , for executing django code directly on CLI
## advanced
- selenium, automated interactive testing
- continuous integration and develpment
- Django LiveServerTestCase
- coverage.py to identify dead code
- how to serve static files in both development and deployement

# Django_flow
## project setup
### initiate project and an app
-	setup virtualenv and activate it, after this we get django-admin utility which helps in creating a project
- if needed instal django (`cd c/python37/scripts/`, install django )
-	`django-admin startproject <project_name>`
-	`cd <project_name>`
-	create alias by following command
-	`alias pym="python manage.py"`
-	now start with creating an app inside your project by using following command
-	`pym startapp <app_name>`
- or simply use django setup shell script that does all of above
### configure project by updating project's settings.py
- register your apps in `INSTALLED_APPS` array, add an entry as `<app_name>.apps.<app_name>Config`
- set `TIME_ZONE` according to needed country from "TZ database name" column from [timezone values](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones), for india use `Asia/Kolkata`
- set `ALLOWED_HOSTS` url (optional, set only if you want to use IP other than http://127.0.0.1)
- configure database in `DATABASES` array (**if skipped**, uses sqlite with default settings, fine for development but **not for production**)

## models
### models define the entities and its members (i.e database table and its attributes)
- create model classes in models.py for each entity
	- class contains member variables that **reflect** table attributes
	- should have a `def __str__(self):` method that returns string when an object is called
	- for e.g., if its student model(class) it might return name(attribute) of student of that particluar object

## migrations
- after defining models
- create migrations
	- `python manage.py makemigrations` , command for generating migration files
- apply migrations
	- `python manage.py migrate` , command for running migrations against database

## url_mapping
- setup app's namespace by setting `app_name` variable just after imports in urls.py
- configure **url -> view** mapping by setting `urlpatterns` array in urls.py with entries of `path()` as below
  - `path(<url_pattern>,<view_to_use>, name="<assign_a_name_to_view>")`
		 
## views
### views define the `function` or `class` that is invoked upon accessing a specific url defined in urls.py
- view either returns `HttpResponse` or raises Exception
- types
- `function` based(more code)
	- working
		- fetch the required data and pass it to a template
		-	render the template with given data and return it as `HttpResponse`
-	`class` based (known as **generic views**) 
	-	like listing of item or detail of item etc(standard use cases of views), (easy to use, less code) 
	-	working
		-	set model, define `get_queryset(args)`

## templates
- make separate html files for each component of a webpage, namely
-	top scripts
- navbar
- header
- sidebar
- bottom scripts
- footer
- create a base html page that clubs all this component using template block tag and a placeholder block tag where actual content goes when used
- create actual content template and use block tag to merge all template parts
- uses `{{variable_name}}` to render value of `variable_name`
- uses following structure control statements like if and for in templating 
```django
{% control_statement %} 
	<some_tags>
		data {{variable_name|<filter_name> }}
	</some_tags>
{% endcontrol_statement %}
```
- more on tags [Built in tags](https://docs.djangoproject.com/en/2.2/ref/templates/builtins/#built-in-tag-reference)
- more on filters [Built in filters](https://docs.djangoproject.com/en/dev/ref/templates/builtins/#built-in-filter-reference)
  
## testing
-	tests are to be written in tests.py
- create a test class and a function, write following things in a test function for a test
### Things to test
### models
-	Types of test cases could be
	-	test a value to be
		-	within boundary
		-	exact inside boundary
		-	exact on boundary
		-	exact above boundary
	-	for example when an input expects a value from 0 to 10, test for values in below given table at end of testing section 
-	how to test
	-	create an entity or model object
	-	insert it
	-	try to fetch it
	-	check it against expected output by `assert*(anything_that_generates_data, expected_output)` method that does the testing
	- could also check for if the recently inserted value is fetched or not, count of items retrieved, output of some function in model called on the inserted object

### views
-	Types of test cases could be
	-	test a view to return `response.status_code` , (further check content by accessing `response.context`)
		-	200
			- with proper data (>= 1 objects)
			- with proper message of object not found (0 objects)(empty dataset)
		-	404
			- url itself is invalid or resource not available
-	how to test
	-	create an entity or model object
	-	insert it
	-	fetch it using django test client that acts as a user agent accessing site and store the response
	-	check it against expected output by `assert*(anything_that_generates_data, expected_output)` method that does the testing
	-	check for expected `response.status_code`
	- could also check for 
		-	if the recently inserted value is fetched or not
		-	count of items retrieved against expected
		-	output of some function in model called on the inserted object
		-	"No <EntityName> found" message in case if dataset is empty

### forms ???
- (or will this be covered in model test ??)
### running tests
- `python manage.py test <TestClass>` **or**
- `python manage.py test` , runs all tests

values	|type 
--------|----------  
5				|normal average case, inside boundary
1, 9		|inside boundary
0, 10		|exact boundary
-1, 11	|above boundary
**7**		|**Total**
*test for both the values in above table  


## admin_site
## register model for admin site controls
- import model to register and register as below
- `admin.site.register(<ImportedModelName>)`
	- registers the model so that it appears in admin site with default UI and controls
## customise admin site(optional)
- create a class of <ModelName>admin in admin.py, configure class by setting various built in variables as per requirement in it and pass this class instead of ModelName as a agrument while registering
## create admin/superuser from CLI
- to reflect changes to model in admin site make sure latest migrations are applied
- `python manage.py createsuperuser`
  - command that launches CLI based admin creation wizard for accessing admin site

# Undefined
- `F()` - to avoid race condition
- reverse() - to reverse map, i.e map an url name to its actual url, used while redirecting

# Doubts/queries
- `Question.object.create()` vs `Question(date/questionl)`
