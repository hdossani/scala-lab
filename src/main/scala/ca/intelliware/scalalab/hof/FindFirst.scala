package ca.intelliware.scalalab.hof

object FindFirst {


  /**
    * Implement a function that returns the first number greater than ten.
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
  def findFirst[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)

    loop(0)
  }
}
