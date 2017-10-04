package ca.intelliware.scalalab.hof

import org.scalatest.{FunSuite, Ignore}


class AbsoluteTest extends FunSuite {

  val fixture = Absolute

  ignore("Calculate absolute values") {

    val ns = List(1, -3, -5, 7, 9, -4, 0)

    val result = fixture.abs(ns)

    assertResult(List(1, 3, 5, 7, 9, 4, 0), "All numbers should be non-negative")(result)
  }

}
