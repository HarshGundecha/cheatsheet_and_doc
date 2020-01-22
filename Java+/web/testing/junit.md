- [Why testing](#why-testing)
- [Why automated testing](#why-automated-testing)
- [Terminologies used](#terminologies-used)
- [Junit](#junit)
  - [Intro](#intro)
  - [How To](#how-to)
  - [Cutomised Test reporting/logging](#cutomised-test-reportinglogging)
  - [Repeated Test case execution](#repeated-test-case-execution)
  - [Multiple testcase for single actual funtion](#multiple-testcase-for-single-actual-funtion)
- [Junti Test Lifecycle](#junti-test-lifecycle)
  - [Hooks](#hooks)
  - [TDD](#tdd)
- [Conditional Test Execution](#conditional-test-execution)
- [Tags](#tags)
- [References](#references)


# Why testing

# Why automated testing

# Terminologies used
  - **Test** - A Test can contain 0 or N test cases for functions to be tested, thus a test is referred as test of whole artifact or system in question.
  - **Test Case** - A test case will be part of a Test and there can be 0 to N test cases, It refers to test being conducted for a single actual function of a class.
- **Actual funtion** - the actual function containing business logic which is tested by test case
# Junit

## Intro

## How To
- add dependencies
  - jupiter engine
  - jupiter api
- add testclasses
- add functions with @Test annotation
  - declare variables that hold expected and actual results
  - call appropriate assert functios to compare results
  - assert*() takes 3 arguments
	- actual 
	- expected
	- test fail message 
  	- instead of passing string here prefer passing lambda so that it is evaluated only if required
  	- this becomes even more useful if the string consists of concatenation or other operations
  - you can use fail() to explicitly fail a test
  - we can also assert for exceptions using assertThrows i.e test that a particular case should throw a particluar exception
- @Test can also be used to run some code everytime - before deployements (yes its a hack)
- currently we depend on gui based builds to carry test and run system but to make sure that the test runs when the build is automated(cui based) we need to use maven surefire
  - for this we need to add maven-surefire plugin
  - and the we can test using `mvn test`
- to give a name to test class and test case function you can use following annotation before test function
  - `@DisplayName("Some name here")`
- we can make the complte test report to be meaningful english sentences by using @DisplayName and messages inside assert* methods

## Cutomised Test reporting/logging
- you can use TestInfo and TestReporter objects for making your own custom reports and logging
- pass them arguments to test case function and they would be injected by test runner  

## Repeated Test case execution
- you can use `@RepeatedTest(<count>)` to repeat a test count times
- doing this you can now add a `RepettitionInfo` object as an argument to test case function and it will be injected at runtime
- `RepettitionInfo` object provides info like total repetition, current repetition etc
- you can have conditional test based on repetition count
- this maybe useful when the test case itself be dynamic, lets say uses random number 

## Multiple testcase for single actual funtion
- if you need to do multiple asserts with different values in a function, try using `assertAll()` that accepts list of lambdas of assert methods
  - this would result in less complex and more useful test reports
- to write multiple test cases for a single actual function use nested as following
- make a sub class in test class and annotate it with `@Nested` 
  - make function for testing different functionality
- this would result in less complex and more useful test reports even better then `assertAll()`
# Junti Test Lifecycle
- test cases run at random order
- each test case should be **completely decoupled or independent** of other test cases
- everything that a test case needs to use should be instatiated inside it
- if there is some common thing required to be done for all test case funtions then do it in lifecylce hooks
  - for example instantiating objects 
- in junit 5 the class instance are instantiated per test case, so if you use variales spanning multiple cases(declaring is fine, instatiating is not) they wont retain their state
- but if theres such a requirement due to legacy code or anything else, this behaviour can be modified using following annotation before test class
- `@TestInstance(TestInstance.LifeCycle.PER_CLASS)`
- whereas the default behaviour is
- `@TestInstance(TestInstance.LifeCycle.PER_METHOD)`

## Hooks 
- do something once before test, usese `@BeforeAll` annotation
  - this method would be static as this runs clearly before the test class object is created
- do something before each test case, usese `@BeforeEach` annotation
- do something after each test case, usese `@AfterEach` annotation
- do something once after test, usese `@AfterAll` annotation
  - this method would be static as this runs clearly after the test class object is destroyed

## TDD
- a concept where you first write test case and then implement it i.e first get errors then solve them
- you can disbale a test case from execution while doing TDD
  - suppose you know all the needed test cases so you write all of them
  - now for each test case you start implementing them by developing required funtionality and running test
  - while doing this when you dont want the test to report fails for those functionality that are yet to be implemented
  - to do this you can use `@Disabled` annotation
  - this will skip testing WIP test cases and still show you in GUI indicating that this is sonmething WIP and is to be implemented and at the same time your test will pass for implemented functionalities


# Conditional Test Execution
- handy when you want test or test case(not sure excatly) to be esecuted in specific cases
    ````java
    @EnablesOnOs(OS.LINUX)
    @EnabledOnJre(JRE.JAVA_11)
    @EnabledIf(..)
    @EnabledIfSysteProperty
    @EnabledIfEnvioronmentVariable
    ````
- google for further reference
- theres also a concept of assumptions where you can tell JUnit to assume certain things, google for further read

# Tags
- you can apply tags to test or test cases
- this becomes useful when you want to run certain test only based on tags
- to achieve this we can configure test runners
- do further read when needed
- to configure it for maven you need to configure pom.xml

# References
- [JUnit 5 basics](https://www.youtube.com/watch?v=qVdPh2cBTN0&list=PLR5T7HLZman9YI5MQ_f5zb2Ju-I45bA-W)
- [Github source code - junit-5-basics-course](https://github.com/koushikkothagal/junit-5-basics-course)

