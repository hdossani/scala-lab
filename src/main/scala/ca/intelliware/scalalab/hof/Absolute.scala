package ca.intelliware.scalalab.hof

object Absolute {

  /**
    * Define a function to calculate the absolute value of a given number.
    */
  def abs(n: Int): Int = {
    if (n < 0) -n
    else n
  }

  /**
    *  Assign the function 'abs' to a variable 'fn'.
    */
  val fn : (Int => Int) = abs


  /**
    * Define a function that returns another function 'fn'.
    */
  def getFn : (Int => Int) = fn


  /**
    * Define a function that applies a function 'fn' to a given list of integers.
    */
  def calculate(ns: List[Int], fn: (Int => Int)) = {
    ns.map(fn)
  }


  /**
    * Define a function that returns a list of all absolute values for a given list of integers.
    */
  def abs(ns: List[Int]): List[Int] = {
    calculate(ns, getFn)
  }


  /**
    * Define a function that calculates the absolute value plus 10 for all elements of a list of integers.
    */
  def absPlusTen(ns: List[Int]): List[Int] = {
    calculate(ns, n => fn(n) + 10)
  }

}
