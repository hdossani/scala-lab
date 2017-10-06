package ca.wglabs.hof

object FindFirst {


  /**
    * Implement a function that returns the first number greater than ten.
    *
    * hint: The possible values for an Option are None and Some.
    */
  def findFirstNumberGreaterThanTen(ns: Array[Int]): Option[Int] = {
    val index = findFirst[Int](ns, n => n > 10)
    if (index == -1) None
    else Some(ns(index))
  }

  /**
    * Implement a function that returns the first word starting with the letter S.
    */
  def findFirstWordStartingWithLetterS(ns: Array[String]): Option[String] = {
    val index = findFirst[String](ns, s => s.startsWith("S"))
    if (index == -1) None
    else Some(ns(index))
  }

  /**
    * Implement a function that returns the index of the first element that satisfies the predicate.
    */
  def findFirst[T](as: Array[T], predicate: T => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= as.length) -1
      else if (predicate(as(n))) n
      else loop(n + 1)

    loop(0)
  }
}
