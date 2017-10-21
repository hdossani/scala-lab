

def hello(arg: String) = s"Hello $arg!!"

hello("World")

//-----------------------------------------------

def helloWithDefault(arg: String = "World") = s"Hello $arg!!"

helloWithDefault("Scala")
helloWithDefault()

//-----------------------------------------------

def formatHello(arg: String) = {
  val msg = "Hello %s!!"
  msg.format(arg)
}

formatHello("Scalator")

//-----------------------------------------------

def factorial(n: Int) = {
  var res = 1
  for(i <- 1 to n) res = res * i
  res
}

factorial(4)

//-----------------------------------------------

def factorialRec(n: Int) : Int =
  if (n <= 0) 1 else n * factorialRec(n -1)


factorialRec(4)

//-----------------------------------------------

def factorialTailRec(n: Int): Int = {

  @annotation.tailrec
  def fac(n: Int, acc: Int) : Int =
    if (n <= 0) acc
    else fac(n - 1, n * acc)

  fac(n, 1)
}

factorialTailRec(4)


//------------------------------------------------

val addOne = (x: Int) => x + 1

addOne(4)

val add = (x: Int, y: Int) => x + y

add(3, 2)

//------------------------------------------------

def addC(x: Int)(y: Int) = x + y

addC(1)(2)


val addTwo = addC(2)(_)

addTwo(3)

