==> Notes

=> BASEPATH
	-> makes sure that the requested file is passed through index.php before it is parsed and output is given to user
	-> prevents execution of php files that are not meant to be directly executed by user request

=> index.php
	-> front/first controller of CI application that checks url and initialises required classes and sets system variables and serves user request by routing request according to url

=> Controller
	-> the class/file for a particular group of tasks where the data is modified/manipulated/checked/prepared before and/or after the data comes in and/or goes out of the application

	-> InShort
		-> checks/validates data when received from the user input
		-> prepares data befor sending it to model

		-> prepares data after receiving from model
		-> loads view(html) file and passes the prepared data to it

	=> index()
		-> executes when no function is invoked and only controller class is requested by url

=> View
	-> a file that contains user inteface for the user developed in combination of  html/css/JS/JQ or other frontend technologies
	-> it is used to properly display data on the website sent to it by its respective controller

=> Model
	-> a class/file for exchanging data bewteen application and DB or between application and third party data center
	-> generally it would be used for select, insert, update, delete etc operations on DB
	-> further for a large or complex application it could also contain code for API calling or web service calling or invoking any third party script/page to exchange data

=> Helper file
	-> contains functions that could be invoked directly without object or $this once loaded
	-> used when functions without classes or objects are to be invoked
	-> uses POP concepts

=> Library file
	-> contains classes -> functions that could be invoked with object or $this once loaded
	-> used when other classes or libraries or helpers are needed to be used in code
	-> uses OOP concepts

=> Query Builder
	-> built in class/library for generating queries that are independent of the database driver, so in case of change in database driver the queries should still run fine with minor modification in application

	=> Examples
		$query = $this->db->get('mytable');
		// SELECT * FROM mytable

		$query = $this->db->get('mytable', 10, 20);
		// SELECT * FROM mytable LIMIT 20, 10

=> base_url()
	-> http://localhost/projects/ci/
	-> complete path to the root folder of the application
	-> useful for accessing resouces rather then accessing controllers

=> site_url()
	-> http://localhost/projects/ci/index.php
	-> complete path to the root folder of the application+Front controller i.e., index.php
	-> useful for accessing controllers rather then accessing resouces
	-> becomes same as base_url() when index.php is removed from url with .htaccess

=> database.php
	-> located at CI/applicaton/config/database.php
	-> used for setting up database name, user, password, DB driver etc

=> routes.php
	-> located at CI/applicaton/config/routes.php
	-> used for internally routing the application according to pattern of the URL requested by request

=> .htaccess
	-> .htaccess is a configuration file used by servers running the Apache Web Server software
	-> used for removing index.php from URL to make application SEO friendly and increase readeability

=> __construct()
	-> executes when a class is initializes
	-> useful when you need to perform actions like loading items or checking session etc before any method is executed

=> autoload.php
	-> for automatically loading packages, libraries ,helper ,database etc when the application loads so that the specifies items are not needed to be loaded in individual files or classes,
	-> in short it universally loads specified items for whole application