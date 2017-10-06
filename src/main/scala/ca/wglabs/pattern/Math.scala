package ca.wglabs.pattern

object Math {

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case x :: xs => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1
    case 0.0 :: _ => 0.0
    case head :: tail => head * product(tail)
  }

}
