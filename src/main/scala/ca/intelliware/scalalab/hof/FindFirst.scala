package ca.intelliware.scalalab.hof

object FindFirst {


  /**
    * Implement a function that returns the first number greater than ten.
    *
    * hint: The possible values for an Option are None and Some.
    */
  def findFirstNumberGreaterThanTen(ns: Array[Int]): Option[Int] = {
    val index = findFirst[Int](ns, ???)
    if (index == -1) ???
    else ???
  }

  /**
    * Implement a function that returns the first word starting with the letter S.
    */
  def findFirstWordStartingWithLetterS(ns: Array[String]): Option[String] = {
    val index = findFirst[String](ns, ???)
    if (index == -1) None
    else ???
  }

  /**
    * Implement a function that returns the index of the first element that satisfies the predicate.
    */
  def findFirst[T](as: Array[T], predicate: T => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= as.length) -1
      else if (predicate(???)) ???
      else loop(???)

    loop(???)
  }
}
