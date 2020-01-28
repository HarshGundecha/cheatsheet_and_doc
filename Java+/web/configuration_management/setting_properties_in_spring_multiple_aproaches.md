- [application properties](#application-properties)
  - [different ways to write properties - (most to least verbose)](#different-ways-to-write-properties---most-to-least-verbose)
  - [examples](#examples)
    - [application.properties](#applicationproperties)
    - [yml](#yml)
  - [drawbacks](#drawbacks)

# application properties

1. we can override specific property in build command itself
2. we can pass whole `application.properties` file to override the default internal one
3. we can use OS env variables too
4. we can mix any or most of above
- we can also have a look at all of the properties even the spring configured properties by enabling them in spring actuator

## different ways to write properties - (most to least verbose)
- xml
- [application.properties](#applicationproperties)
- json
- [yml](#yml)


## examples

### application.properties
````properties
# for @Value example
firstName = john
lastName =doe
fullName = ${firstName} ${lastName}
listOfNaturals = 1,2,3
productSpecs = {brand:'gogle', model:'pixel 3XL' }

# for @ConfigurationProperties example 
db.host = 127.0.0.1/pgsql
db.port = 1234
db.database = dummy
````

### yml
````yml
# for yml example with @ConfigurationProperty
db:
  host: 127.0.0.1/pgsql
  port: 1234
  database: dummy

my.app.name: myApp # also supports this so that you dont have to expand smaller propertis to multiple lines
````

## drawbacks
- with application properties alone all the config done above still resides in a fat JAR only