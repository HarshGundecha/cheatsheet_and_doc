- [Read Me](#read-me)
  - [Rating](#rating)
    - [Configurability](#configurability)
    - [Complexity](#complexity)
- [Patterns](#patterns)
  - [Creational Patterns](#creational-patterns)
    - [Factory](#factory)
      - [e.g](#eg)
    - [Abstract factory](#abstract-factory)
      - [e.g](#eg-1)
    - [Builder](#builder)
      - [e.g](#eg-2)
    - [Prototype](#prototype)
      - [e.g](#eg-3)
    - [Singleton](#singleton)
      - [e.g](#eg-4)
  - [Structural Patterns](#structural-patterns)
    - [Adapter](#adapter)
      - [e.g](#eg-5)
    - [Bridge](#bridge)
      - [e.g](#eg-6)
    - [Composite](#composite)
      - [e.g](#eg-7)
    - [Decorator](#decorator)
      - [e.g](#eg-8)
    - [Facade](#facade)
      - [e.g](#eg-9)
    - [Flyweight](#flyweight)
    - [Proxy](#proxy)
  - [Behavioural Patterns](#behavioural-patterns)
    - [Chain of responsibility](#chain-of-responsibility)
      - [e.g](#eg-10)
      - [Implementation](#implementation)
      - [Additional info](#additional-info)
    - [](#)
- [Reference](#reference)

# Read Me
- the guide is build keeping in mind **revision** & **not first h& learning**
- the referenced article has already done fnatstic job for first h& learning
- the reference also consists of 
  - code examples in multiple languages
  - how patterns can be mixed with each other to get sove bigger problems
  - suggests when to use certain problem
  - lists the common usage of pattern alongwith its usage in certain built in features of a programming language

## Rating
- defines score depicting how much [configurable](#configurability) & [complex](#complexity) a pattern as
- here configurability is directly propotional with complexity
- for e.g if configutability is 5/5, complexity is also going to be same

### Configurability
- defines how much granular control the pattern can provide

### Complexity
- defines how much extra layers in terms of interfaces or classes are needed to achieve the goals



# Patterns

## Creational Patterns
- Creational patterns provide various object creation mechanisms, which increase flexibility & reuse of existing code.

### Factory
- Factory method is a creational design pattern which solves the problem of creating product objects without specifying their concrete classes.
- basicllay you want to select 1 type of product from **N types** of products
- rating - ⭐️
#### e.g
- for e.g you either want a **Small**, **Medium** or **Large** luggage product

### Abstract factory
- Abstract Factory is a creational design pattern, which solves the problem of creating entire **product families** without specifying their concrete classes.
- help when you have **M products with N variants in each product**.
- rating - ⭐️⭐️

#### e.g
- for e.g Product **Chair** & **Sofa** that too with 2 **variants** in each as **Modern** & **Traditional** where furniture is family
- for e.g a set of **Modern** **Chair** & **Sofa** forms a **Modern Furniture family**

### Builder
- Builder(👨‍🔧️) is a creational design pattern, which allows constructing complex objects step/step.
- consists of builder(👨‍🔧️) & director(👨‍🏫️) where the **👨‍🔧️ provides steps used for building an object** alongwith implementations while **👨‍🏫️ knows the sequence/set** of steps to execute
- a system can get a **st&ard** product by using **predefined 👨‍🏫️** by passing the 👨‍🔧️ initially to 👨‍🏫️ once only
- usually a **👨‍🏫️ uses single/same 👨‍🔧️ everytime** by accepting it in constructor but it can also accept 👨‍🔧️ in build method to **use different 👨‍🔧️ at build call**, thus allowing different product on each build
- a system can get **unique** products by directyl using **👨‍🔧️** without involving 👨‍🏫️, by executing build steps as required
- rating - ⭐️⭐️⭐️

#### e.g
- to build different types of car(🚙) & their respective reading manual(📜️)
- for e.g define a 👨‍🔧️ interface that declares setEngine(), setSeat() etc ()s for building 🚙 & respective 📜️ parts
- extend this with 🚙 👨‍🔧️ & 📜️ 👨‍🔧️
- define getProduct() (a () that will return final product) in concrete implementations of both 👨‍🔧️. This cant be done 👨‍🔧️ interface as return type varies for 🚙/📜️
- now define a () in 👨‍🏫️ for building a st&ard SUV 🚙 & put sequence/set of steps to build 🚙/📜️ in this ()
- now here's the magic if you pass 🚙 👨‍🔧️ to 👨‍🏫️ it can build 🚙, if you pass 📜️ 👨‍🔧️ it can build 📜️ too
- now create a 👨‍🏫️ instance by passing 🚙 👨‍🔧️, invoke getProduct(), & you get 🚙, repeat same by passing 📜️ 👨‍🔧️ & you get 📜️ too
- we can also use 👨‍🔧️ in main for which theres no 👨‍🏫️, to build a sports 🚙 with 2 seats & better engine by invoking setEngine etc in main which would be otherwise in 👨‍🏫️

### Prototype
- Prototye pattern provides a way to easily clone existing objects
- here an interface for the object is defined having a **clone()** which returns object of same interface to allow flexibility between all classes extending this interface
- all classes must implement a copy constructor that does cloning for that class
- an imp thing to note is that all copy constructor **must first call parent constructor** before doing cloning, to make sure parent fields are also cloned
- clone method just creates new object(by copy constructor) of its own class by passing current object(object to be cloned) & it will get you a clone
- rating - ⭐️
#### e.g
- you have to create certain object each time a request is made, although the objects creation is complex there are few usually used objects that are repeatedly created/used
- in this case one can use **Prototype registry** where you keep all usually required complex object pre created for once
- now whenever you need an object just clone one of the object from registry, thus saves you from going through complex creation process & also avoid repeatedly creating same objects

### Singleton
- Singleton lets you ensure that a class has only one instance, while providing a global access point to this instance.
- useful in cases like a single global key store or a single DB connection
- though note that you can always change it from singleton to Non-Singleton by putting additional logic to Limit objects to N, for e.g. for limited pool of resource of size N
- rating - ⭐️

#### e.g
- for example you want to make sure that there is only one DB instance used by whole app
- define only one constructor that too **private**, add a class member lets say theObject which holds the only created object
- add a getInstance() that will check if theObject==null, if so it will create object else return existing one, note that only getInstace() can call the **private** constructor
- also note that in case your app does multi-threading you need to make getInstance() **thread safe** to prevent multiple threads creating instance at same time


## Structural Patterns
- Structural patterns explain how to assemble objects & classes into larger structures while keeping these structures flexible & efficient.

### Adapter
- Adapter allows objects with incompatible interfaces to collaborate.
- could be used to convert from one to another or even 2 way conversion
- the adapter could extend either of following
  - both the source & target interface/actual class
  - source interface/actual class
  - target interface/actual class - usually cant be done since the target class could be 3rd party library that doesnt provide source code
- rating - ⭐️
#### e.g
- a legacy application(client) code produces xml data & wants to use a modern library that expects data in json
- to solve this problem there are several approaches
  - if legacy code have an interface, extend this in adapter
  - if not extend the xml producing class with an adapter
- whichever you choose add a method in adapter that converts data from xml to json
- thus this method then produces required xml from json & so you can use library now

### Bridge
- Bridge lets you split a large class or a set of closely related classes into two separate hierarchies - **abstraction** & **implementation**, which can be developed independently of each other.
- Useful when you need to extend a class in several orthogonal (independent) dimensions by switching from inheritance to the object composition.
- rating - ⭐️⭐️
#### e.g
- suppose your task is to develop Remotes(🎮) for Televisions(📺️) & Radios(📻️)
- in worst case you can tightly couple 📺️+🎮 & 📻️+🎮,  but wait & think about: 
  - repeatedly developing almost same things for N times for 2 category of products i.e 📺️ & 📻️ 
  - how would you incorporate bug fix or feature update in 🎮s
- so abstracting out common interface makes sense right ?
- thus we better create **abstractions (🅰️)** & **implementations (ℹ️)** (⚠️ not your regular programming terms)
  - 🅰️ reside in 🎮 side with higher level controls, an operation in 🅰️ can be made up of N operations of ℹ️
    - for e.g operations like
      - nextChannel() - ⏩️
      - prevChannel() - ⏪️
      - volumeUp() - 🔊️
      - voulmeDown() - 🔉️
      - mute() - 🔈️
  - ℹ️ reside in 📺️ & 📻️ side with all basic operations (like CRUD operations in web)
    - for e.g operations like
      - setChannel(can be used by both ⏪️ & ⏩️ channel)
      - getChannel()
      - setVolume(can be used by all 3 of volume 🔊️, 🔉️, 🔈️), 
      - getVolume(), etc
  - Note: implementations will actually be interface & thus will have concrete classes for different remotes lets say Remote1(🖲️) & Remote2(🖱️)
- Now the abstraction class/interface consists of an higher level 📺️ object, thus easily allowing to reuse 🎮 for other 📺️/📻️ variants by just swapping the 📺️/📻️ object

### Composite
- Composite is a structural design pattern that lets you compose objects into tree structures & then work with these structures as if they were individual objects.
- Useful when the core model of your app can be represented as a **tree**.

#### e.g
- you want to develop an ordering system, which will consist of Box(🎁) & Product(🍎)
  - the 🎁 can further have small 🎁s or the actual end 🍎s
- now imagine you want to get the total prize of an order
- the solution is simple, make an interface with a common method like getPrize() which will be extended by both 🎁/🍎
  - the 🎁 will loop over all its child & get the total prize
  - the end 🍎 will just return its actual prize
- & as it should each concrete implementation will have their own additional methods or fields
  - for e.g
    - box will have array of this interface

### Decorator
- Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.

#### e.g
- suppose you are making a file writing library product(🍎), but your clients also wish to have possibility to add their own additional implementations say compression (🎁️) & encryption(🔑)
- to achieve there are generaly 4 things
  - 1. an common interface(ℹ️) with common fields/methods
  - 2. a default implementation of ℹ️, writing data to file(📄)
      - writeData()
      - readData()
  - 3. a decorator ℹ️ extending the above common ℹ️ and **only** adding a field for **wrapping an original object**
  - 4. decoration layers, achieved by implementing decorator ℹ️ & linking original source object as **wrapee**, i.e wrapped object representing original 📄️ object
    - in our example we can have 2 layer
      - one for 🎁
        - writeData() -> compress data of wrapped object, call parent's writeData()
      - one for 🔑
        - writeData() -> encrypts data of wrapped object, call parents's writeData()
- result
  - when you call writeData() on final object which is decorated by 🎁 & 🔑, it calls wrapped object's(🎁) writeData()
    - the writeData() in 🎁 does it's job & calls wrapped object's(🔑) writeData() 
      - the writeData() in 🔑 does it's job & calls wrapped object's(📄️) writeData()
        - finally the writeData() in 📄️ does actual writing to file job

### Facade
- Facade is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes.

#### e.g
- our application(🍎️) requires to be able to convert videos, which depends on 3rd party complex system/library(🔁️).
- to make it easy to update 🔁️ & keep our 🍎️ least coupled with it, we introduce an interface(ℹ️) as a layer between 🍎️ & 🔁️
- the ℹ️ exposes least required things for 🍎️, and the implementation takes care of complexities.
- now when 🔁️ gets an update the implementation need to be updated but the relation/contract between 🍎️ & ℹ️ stays same, thus saving us from introducing changes in our 🍎️

### Flyweight
// TODO - add notes

### Proxy
// TODO - add notes


## Behavioural Patterns

### Chain of responsibility
- Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.

#### e.g
- suppose there's a request coming to server and as usual you want to perform a series of checks before you can actually process the request
  - the checks can be
    1. Sanitization of data(🧹)
    2. Validation of data(✅)
    3. Authentication(🔑)
    4. Authorization(🛡️)
- now as per the names of individual checks/processes you would've guessed that these are sequential checks which means we proceed to next check only if previous one was successful
- also we only start actually processing the request after **ALL** of the checks 🧹 -> ✅ -> 🔑 -> 🛡️ are successfully performed

#### Implementation
- to achieve this define an interface(ℹ️) with 2 ()s
  1. execute() - used to handle the process of 1 step in chain
  2. setNext() - used to set the next handler in the chain (basically a setter method)
- **for each** handler implement the ℹ️ as follows 
  1. declare a private field that will hold the next handler's reference
  2. define execute() having handlers logic 
  3. define setNext() to set private field to next handler in chain
- so in our e.g we will have atleast 1 ℹ️ and 4 implementations

#### Additional info
- the chain can be seen as connected by logical ANDs or ORs, here's how
  - if the implementation is such that any one of the N handler should be executed successfully, you can see this as OR connected chain
  - if the implementation is such that all of them should be executed successfully, you can see this as AND connected chain
- pro tip - you can use abstract class instead of ℹ️ to define following for once and be done
  - the private field that will hold the reference to next handler
  - the code for setNext() which will be now same for all implementation since the private field will also be same for all 

### 

# Reference
- [Refactoring guru - Design patterns](https://refactoring.guru/design-patterns)