package ca.wglabs.pattern

import org.scalatest.{FunSuite, Ignore}

@Ignore
class MathTest extends FunSuite {

  val fixture = Math

  test("Sum the numbers from a list of integers") {

    assertResult(7)(fixture.sum(List(1, 2, 3, 6, -6, 1)))
    assertResult(0)(fixture.sum(List()))
  }

  test("Multiplies the numbers from a list of doubles"){

    assertResult(6)(fixture.product(List(1, 2, 3)))
    assertResult(3)(fixture.product(List(1, 1, 3)))
    assertResult(0)(fixture.product(List(1, 0, 3)))
    assertResult(1)(fixture.product(List()))
  }
}
