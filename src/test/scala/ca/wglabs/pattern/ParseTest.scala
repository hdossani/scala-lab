package ca.wglabs.pattern

import org.scalatest.FunSuite

class ParseTest extends FunSuite {

  val fixture = Parse

  ignore("Parse 0 or 1 into 'yes' or 'no'") {

    assertResult("no")(fixture.intToYesOrNo(0))
    assertResult("yes")(fixture.intToYesOrNo(1))
    assertResult("error")(fixture.intToYesOrNo(2))
    assertResult("error")(fixture.intToYesOrNo(-1))
  }

  ignore("Parse command line argument") {

    assertResult("Sorry, I can't help you.")(fixture.parseArgument("-h"))
    assertResult("Sorry, I can't help you.")(fixture.parseArgument("--help"))
    assertResult("Beta")(fixture.parseArgument("-v"))
    assertResult("Beta")(fixture.parseArgument("--version"))
    assertResult("Unknown argument: -f")(fixture.parseArgument("-f"))
  }

  ignore("Parse instance type") {

    assertResult("Integer: 1")(fixture.parseType(1))
    assertResult("a Double")(fixture.parseType(1.0))
    assertResult("I want to say 'bla'")(fixture.parseType("bla"))
  }
}
