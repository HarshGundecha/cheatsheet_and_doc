- [accessing properties in spring](#accessing-properties-in-spring)
  - [example](#example)
    - [using `@Value`](#using-value)
    - [using `@ConfigurationProperty`](#using-configurationproperty)
    - [other aproaches](#other-aproaches)
- [references](#references)

# accessing properties in spring
- any combination of following given that properties are available to system
- `@Value` - for getting individual properties
- `@ConfigurationProperties` - for getting a group of related properties

## example
- this properties are set in [property file aproaches](configuration_management/property_file_approaches.md)
- note that obviously both of the following can be used at same time

### using `@Value`
````java
// accessing properties individually
@value("some static value")
private String staticValueString;

@value("${firstName}")
private String firstNameFromProperty;

@value("${firstName:jack}")
private String firstNameFromPropertyWithDefaultValue;

@value("${fullName:jack ma}")
private String nameFromPropertyWithinProperty;

@value("${listOfNaturals}")
private List<Integer> listOfNaturalsFromProperty;

@value("#{${productSpecs}}")
private Map<String, String> productSpecsFromProperty;
````

### using `@ConfigurationProperty`
````java
// accessing bunch of property by ansorbing them in a POJO
@Configuration
@ConfigurationProperty("db")
@Data //should work but if doesnt generate getter/setter
class DbConfig{
  private String host;
  private int port;
  private String database;
}

class Main{
  public static void main(){
    @Autowired
    private DbConfig dbConfig;
    //enjoyy
    someConnect(dnConfig.getHost, dbConfig.getPort, dbConfig.getDatabase());
  }
}
````

### other aproaches
- environment object

# references
