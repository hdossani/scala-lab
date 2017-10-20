def factorial(n: Int) : Int = n match {
  case 0 => 1
  case n => n * factorial(n - 1)
}

factorial(4)

//--------------------------------------------------

var obj: Any = 42.0
obj match {
  case x: Int => x
  case s: String => Integer.parseInt(s)
  case _: BigInt => Int.MaxValue
  case _ => 0
}

//--------------------------------------------------

val numbers = List(42, "42", BigInt(42), 42.0)
numbers.map {
  case x: Int => x
  case s: String => Integer.parseInt(s)
  case _: BigInt => Int.MaxValue
  case _ => 0
}

//--------------------------------------------------

val pair = (1, 1)

pair match {
  case (0, _) => "0 ..."
  case (y, 0) => y + " 0"
  case _ => "neither is 0"
}


