- [Spring logging](#spring-logging)
  - [Introduction](#introduction)
  - [Implementation](#implementation)
  - [Suggestion](#suggestion)
  - [IMP NOTES](#imp-notes)
- [References](#references)

# Spring logging

## Introduction
- starter web or any started dependencies include starter-logging which include spring JCL spring commons logging bridge
- it uses logback framework whic is a successor of log4j

## Implementation
- you can set log settings in `application.properties` or `logback-spring.xml`
- apply logging for everything (for even springs internal working)
  - `logging.level.root=<LEVEL>`
- apply logging for specific package only
  - `logging.level.<PACKAGE>=<LEVEL>`
- basically by specifying muliple of this we can have different level of logs for different things

## Suggestion
- to prevent `application.properties` from being filled with logging config, you can put config in `logback-spring.xml` (stop judging just because it is `.xml`)
- same as `application.properties` you define only one line for each config, the rest of configs can be included from `base.xml` of loback

## IMP NOTES
- there are multiple players in loggin game like 
  - logback
  - slf4j
  - log4j
- read, compare and finalise which one to use

# References
- [How to do logging in Spring Boot - Brain Bytes
](https://youtu.be/lGrcZsw-hKQ)
- [manual](http://logback.qos.ch/manual/index.html)