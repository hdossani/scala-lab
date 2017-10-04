package ca.wglabs.pattern

object Parse {

  def intToYesOrNo(choice: Int): String = choice match {
    case 1 => "yes"
    case 0 => "no"
    case _ => "error"
  }

  /**
    * Implement a function that parses the command line argument.
    *
    * hint: Use | operator to indicate 'or'.
    */
  def parseArgument(arg: String) = ???


  def parseType(x: Any): String = ???

}
