- [Aspect Oriented Programming-AOP](#aspect-oriented-programming-aop)
  - [1. static/compile time](#1-staticcompile-time)
    - [1.1 aspect](#11-aspect)
    - [1.2 pointcut](#12-pointcut)
    - [1.3 advice](#13-advice)
  - [2. dynamic/runtime](#2-dynamicruntime)
    - [2.1 jointpoint](#21-jointpoint)
    - [2.2 weaving](#22-weaving)
- [References](#references)

# Aspect Oriented Programming-AOP
- AOP (Aspect Oriented Programming) lets you focus on business logic by abstracting out common cross cutting concerns like logging, secutiy, performance metrics etc
- AOP should be used in such a way that even if disabled or broken the application should not be affected

## 1. static/compile time
### 1.1 aspect
- concern to be addressed
- usually cross cutting concerns like
  - logging
  - security
  - transaction management
  - performance metrics
- **e.g.,** **logging**

### 1.2 pointcut
- a regex like pattern to intercept target method, field etc
- **e.g.,** when money is debited/credited from/to account

### 1.3 advice
- the action to be taken on an aspect/target once intercepted by pointcut
- basically what to do with intercepted target
- **e.g.,** the logging **functionality**

## 2. dynamic/runtime

### 2.1 jointpoint
- execution of user defined behaviour at runtime
- execution of advice 
- **e.g.,** **execution** of logging code

### 2.2 weaving
- the process of wiring user defined behaviour to existing behavior and the excution is called weaving
- **e.g.,** **intercept** the method that modifies money in account and successfully **inject** the required logging functionality

# References
- [Spring AOP Tutorial - with Aspectj Examples](https://youtu.be/Og9Fyew8ltQ)