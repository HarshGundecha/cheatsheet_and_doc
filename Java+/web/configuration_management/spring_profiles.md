- [spring profiles](#spring-profiles)
  - [naming convention](#naming-convention)
  - [ways to activate a profile](#ways-to-activate-a-profile)
  - [drawbacks](#drawbacks)
- [references](#references)

# spring profiles
- having only one application properties doesnt work as different env will have different properties
- so we can have multiple property files(profiles) for different envs
- [ways to activate a profile](#ways-to-activate-a-profile)
- default profile is always active, so you are supposed to put all common property in default and env specific in theie respective files
- if you set any other profile active, the new one would overwrite any conflicts
- if we have env specific beans in spring, we can put @Profile("<profiel_name>") to make sure that bean is loaded only in this profile
- we can also inject environment objects in code to access properties using env object
  - it is not preffered to use this property lookup, instead use property injection or ${}
  
## naming convention
- `application.properties`
  - for default and common properties
  - always loaded
- `application-<your_profile_here>.properties`
  - for properties specific to <your_profile_here>
  - example
    - `application-prod.properties`
  - loaded when specifically set to active

## ways to activate a profile
- in properties file itself
  - would be hardcoding
- at code level
  - also hardcoding
- while running mvn or java -jar and passing profile as command line arg
  - somewhat flexible as profile can be applied as per arg passed

## drawbacks
- may expose credentials to unauthorised set of people if you put all property/profiles in code
- or else you need to make sure the availability of different property files across different envs while push/pull happens
- most of the goals of config management are not met with this alone

# references