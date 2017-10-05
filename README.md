# J7 -> J8 => Scala: a Refactoring Exercise 

The goal of this exercise is to have an introduction of a few basic concepts of the the Scala Programming Language through code refactoring.
Based on challenges and their solutions already implemented in Java 7 and Java 8, the idea is to write the can same solutions in Scala so they pass the also supplied set of unit tests.
After complete, the participants will be able to compare their answers with the corresponding ones in Java and have a taste of how awesome Scala really is!


### Setup

The instructions assume following pieces of software are ***already installed*** on the machine:

- Java 8
- Scala 2.11
- Maven 3
- Git 

Then follow the steps:
 
1. Clone this github repository `git clone https://github.com/wanderpgomes/scala-lab.git`
2. Run `mvn clean compile scala:compile scala:testCompile test`

At this point, you should have a `SUCCESSFUL` maven build with 40 JUnit tests passed and 30 ScalaTest tests ignored.

### Using IntelliJ IDEA
 
3. Install IntelliJ IDEA Community Edition 2017
4. Install the Scala plugin
   - Go to Preferences | Plugins
   - Search for Scala and click Install
5. Create a new IntelliJ project   
   - File | New | Project from Existing Sources...
   - Choose directory where the repo was cloned
   - Choose Maven 
   - Accept all default options

6. Right click on the scala-lab project and Run | All Tests 
7. Right click on the scala-lab project and Run | ScalaTest in 'scala'

At this point you should get a green bar for the last two steps.
   

## Exercises


The exercises for this lab are organized in an implementation/unit test format. Partial implementations for the functions are supplied and you then have to replace the **_???_** (not yet implemented operator) with Scala code so the unit tests will pass.


Initially all the ScalaTest cases are ignored. In order to enable them, just change `ignore` to `test` for each individual test case. 

- Start with the warm up exercises about high order functions `hof`  and  `pattern` matching.

- Enable the tests one by one as you implement each method. `An implementation is missing` Exception is thrown if the method with `???` operator is executed.


### Solutions

The solutions for all the exercises can be found on the `solutions` branch.
