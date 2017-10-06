# J7 -> J8 => Scala: a Refactoring Exercise 

The goal of this activity is to introduce a few basic concepts of the the Scala Programming Language through code refactoring exercises.
Based on challenges and their solutions already implemented in Java 7 and Java 8, the idea is to solve the same set of questions in Scala so it will pass the unit tests, also provided.
After complete, you will be able to compare your answers with the corresponding ones in Java and have a taste of how awesome Scala really is!


### Setup

This set of instructions assumes the following pieces of software are ***already installed*** on the machine:

- Java 8
- Scala 2.11
- Maven 3
- Git 

Then follow the steps:
 
1. Clone this GitHub repository `git clone https://github.com/wanderpgomes/scala-lab.git`
2. Run `mvn clean compile scala:compile scala:testCompile test`

At this point, you should have a `SUCCESSFUL` maven build with 40 JUnit tests *passed* and 30 ScalaTest tests *ignored*.

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
6. Make sure you use Scala 2.11 (ScalaTest compatibility)
   - File | Project Structure... | Global Libraries
   - Choose `scala-sdk-2.11`

7. Right click on the `scala-lab` project and Run | All Tests 
8. Right click on the `scala-lab` project and Run | ScalaTest in 'scala'

At this point, you should get a *green bar* for the last two steps.
   

## Exercises


The exercises for this lab are organized in an implementation/unit test format. Partial implementations for the functions are supplied and you then have to replace the `???` (not yet implemented operator) with Scala code so the unit tests will pass.


Initially all the ScalaTest cases are ignored. In order to enable them, just change `ignore` to `test` for each individual test case. 

- Enable the tests one by one as you implement each method. `An implementation is missing` Exception is thrown if the method with `???` operator is executed.

- Start with the warm up exercises about high order functions `hof`  and  `pattern` matching.

- Then proceed to the refactoring exercises in `collections`.


### Solutions

The solutions for all the exercises can be found on the `solutions` branch.
