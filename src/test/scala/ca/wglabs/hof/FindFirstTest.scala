package ca.wglabs.hof

import org.scalatest.FunSuite



class FindFirstTest extends FunSuite  {

  val fixture = FindFirst


  ignore("Find first number greater than 10"){

    val as = Array(-1, 9, 8, 1, 2, -7, 11, 12, 9)

    val result = fixture.findFirstNumberGreaterThanTen(as)

    assertResult(Some(11))(result)
  }

  ignore("Find first number greater than 10 on an array of number smaller than 10"){

    val as = Array(-1, 9, 8, 1, 2, -7)

    val result = fixture.findFirstNumberGreaterThanTen(as)

    assertResult(None)(result)
  }

  ignore("Find first number greater than 10 on an empty array"){

    val as = Array.emptyIntArray

    val result = fixture.findFirstNumberGreaterThanTen(as)

    assertResult(None)(result)
  }

  ignore("Find first word starting with the letter 'S'"){

    val as = Array("Java", "Python", "C++", "Scala", "Javascript", "SQL")

    val result = fixture.findFirstWordStartingWithLetterS(as)

    assertResult(Some("Scala"))(result)
  }
}
