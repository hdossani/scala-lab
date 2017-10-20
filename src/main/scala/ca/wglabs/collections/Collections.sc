import scala.collection.mutable._

// Arrays preserve order, can contain duplicates, and are mutable.
val numbersA= Array(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)

numbersA(3) = 10

numbersA foreach println


//------------------------------------------------------------------

// Lists preserve order, can contain duplicates, and are immutable.
val numbersL = List(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
//numbersL(3) = 10

val numbersIL = MutableList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
numbersIL(3) = 10


//------------------------------------------------------------------


// Sets do not preserve order and have no duplicates
val numbersS = Set(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)

numbersS foreach println


//------------------------------------------------------------------

// A Tuple groups together simple logical
// collections of items without using a class.
val hostPort = ("localhost", 80)

hostPort._1
hostPort._2

val (host, port) = ("localhost", 8080)
host
port


//------------------------------------------------------------------

// Ranges
1 to 12 foreach println
1 to 12 by 2 foreach println

1 until 12 toList

val someNumbers = Range(0, 10)
val moreNumbers = Range(0, 10).inclusive

//------------------------------------------------------------------

// Maps
Map(1 -> 2)
Map("foo" -> "bar", 1 -> "one")
var myMap = Map(1 -> "one", 2 -> "two")
myMap(1)
myMap(2)
myMap.get(2)
myMap.getOrElse(3, "missing data")

myMap = Map(4 -> "four", 5 -> "five") withDefaultValue("key not found")
myMap(1)


//------------------------------------------------------------------

val fruitList = List("apples", "oranges", "pears")

// Alternative syntax for lists
val fruits = "apples" :: ("oranges" :: ("pears" :: Nil))
fruits.head
fruits.tail
val emptyL = List()
val emptyN = Nil

//------------------------------------------------------------------

// map
// Evaluates a function over each element in the list,
// returning a list with the same number of elements.
val numbers = List(1, 2, 3, 4)
numbers.map((i: Int) => i * 2)


// or pass in a function
def timesTwo(i: Int): Int = i * 2
numbers.map(timesTwo)


//------------------------------------------------------------------

// foreach is like map but returns nothing.
numbers.foreach((i: Int) => i * 2)  //returns nothing

// foreach is intended for side-effects only.
var sum = 0
numbers.foreach(sum += _)
sum

//------------------------------------------------------------------

// filter
// Removes any elements where the function you pass in evaluates to false.
// Functions that return a Boolean are often called predicate functions.
numbers.filter((i: Int) => i % 2 == 0)
def isEven(i: Int): Boolean = i % 2 == 0

numbers.filter(isEven)

//------------------------------------------------------------------

// zip
// Aggregates the contents of two lists into a single list of pairs.
List(1, 2, 3).zip(List("a", "b", "c"))

(0 to 100 by 10).zip(0 to 100 by 10 tail)