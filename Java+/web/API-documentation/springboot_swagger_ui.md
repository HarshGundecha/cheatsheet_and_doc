- [Swagger](#swagger)
  - [What is swagger ?](#what-is-swagger)
  - [What can swagger docs describe](#what-can-swagger-docs-describe)
- [SpringBoot Swagger config](#springboot-swagger-config)
  - [Issues in out-of-the-box configuration](#issues-in-out-of-the-box-configuration)
  - [Solution](#solution)
  - [Swagger Problems](#swagger-problems)
  - [Solution to swagger problem](#solution-to-swagger-problem)
- [References](#references)

# Swagger

## What is swagger ?
- Swagger allows you to describe the structure of your APIs so that machines can read them.
- The ability of APIs to describe their own structure is the root of all awesomeness in Swagger

## What can swagger docs describe
- What are all the operations that your API supports?
- What are your API’s parameters and what does it return?
- Does your API need some authorization?
- And even fun things like terms, contact information and license to use the API.

---

# SpringBoot Swagger config
- Add springfox swagger2 dependency for rest based documentation 
- add `@EnableSwagger` to the `main` class of the project, ideally it should be in a seperate config file and not in main 
- add springfox swagger ui dependency html (UI) based documentation, this will enable documentation at root of api domain i.e at "/swagger-ui.html"
- after doing this initial setup we do get the API doc but there are several problems
- 
## Issues in out-of-the-box configuration
  1. it shows the built in error controller too
  2. it shows our models apart from entity too
  3. the API name, version and description is default and not much relevant to system

## Solution
  - configure swagger by making a Docket object inside `main()` in which all the config lies
  - add below in `main()` to get rid of issue 1 and 2 
    ````java
	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.apis(
                    RequestHandlerSelectors
                    .basePackage("com.happysolutions")
                )
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
			"Survey API",
			"Sample API for SpringBoot and swagger tutorial",
			"1.0",
			"Free to use",
			new Contact(
                "Harsh Gundecha", 
                "https://in.linkedin.com/in/harsh-gundecha",
                "harsh.gundecha@gmail.com"
            ),
			"API License",
			"http://myLicenseUrl.com",
			Collections.emptyList()
		);
	}
    ````
  - and this above **each API endpoint** for info on Endpoint and parameters
    ````java
    @GetMapping("/{questionId}")
    @ApiOperation(
        value = "Get Question",
        notes = "Given a questionId it returns a Question object",
        response = Question.class
    )
    public ResponseEntity<?> getQuestion(
        @ApiParam(
            value="questionId of the question to be fetched",
            required = true
        )
        @PathVariable Long questionId
    )
    {
        return ResponseEntity.ok(questionService.getQuestion(questionId));
    }
    ````
    - and add following annotations to each Entities
    ````java
    //...
    @ApiModel(value = "Question")
    public class Question {
        //...
        @ApiModelProperty(notes = "The question for survey")
        private String questionText;
        @OneToMany(cascade = CascadeType.ALL)
        @ApiModelProperty(notes = "The answers given by users")
        private Set<Answer> answerSet = new HashSet<>();
        //...
    }

    ````

## Swagger Problems
- as we see it becomes annotation hell as we need to have a lot of annotations for swagger to work

## Solution to swagger problem
- there's a spring project called **Spring REST docs** that attaches these annotations in test code instead of actual code.

# References
1. [How to add Swagger to Spring Boot - Brain Bytes](https://youtu.be/gduKpLW_vdY)
2. [How to configure Swagger in Spring Boot - Brain Bytes](https://youtu.be/8s9I1G4tXhA)
- [Spring REST Docs](https://spring.io/projects/spring-restdocs)