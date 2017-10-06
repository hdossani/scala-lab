package ca.wglabs.collections.menu

import org.scalatest.{FunSuite, Ignore}
import ca.wglabs.streams.menu.Dish.CaloricLevel._
import ca.wglabs.streams.menu.Dish.Type._


class MenuInquiryTest extends FunSuite {

  val fixture = MenuInquiryS

  test("Dishes with more than 400 calories") {

    val result = fixture.getHighCaloricDishNames

    assertResult(List("salmon", "french fries", "pizza", "beef", "pork"))(result)
  }

  test("Comma separated list of dishes"){

    val result = fixture.getShortMenuCommaSeparated

    assertResult("pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon")(result)
  }

  test("Dishes grouped by type"){

    val result = fixture.groupDishesByType

    assertResult(2)(result(FISH).size)
    assertResult(3)(result(MEAT).size)
    assertResult(4)(result(OTHER).size)

    assertResult(FISH)(result(FISH)(0).dtype)
    assertResult(MEAT)(result(MEAT)(0).dtype)
    assertResult(OTHER)(result(OTHER)(0).dtype)
  }

  test("Dishes grouped by caloric level"){

    val result = fixture.groupDishesByCaloricLevel

    assertResult(4)(result(DIET).size)
    assertResult(1)(result(FAT).size)
    assertResult(4)(result(NORMAL).size)

    assert(result(DIET)(0).calories <= 400)
    assert(result(NORMAL)(0).calories <= 700)
    assert(result(FAT)(0).calories > 700)
  }

  test("Dishes grouped by type and then caloric level") {

    val result = fixture.groupDishesByTypeAndCaloricLevel

    assertResult(1)(result(FISH)(NORMAL).size)
    assertResult(1)(result(MEAT)(DIET).size)
    assertResult(0)(result(OTHER).getOrElse(FAT, 0))

  }

  test("Count dishes group by caloric level"){

    val result = fixture.countDishesInGroups

    assertResult(2)(result(FISH))
    assertResult(3)(result(MEAT))
    assertResult(4)(result(OTHER))
  }

  test("Sum dish calories by type"){

    val result = fixture.sumCaloriesByType

    assertResult(850)(result(FISH))
    assertResult(1900)(result(MEAT))
    assertResult(1550)(result(OTHER))
  }

  test("Group caloric level by type"){

    val result = fixture.caloricLevelsByType

    assertResult(2)(result(FISH).size)
    assertResult(3)(result(MEAT).size)
    assertResult(2)(result(OTHER).size)

    assert(result(FISH).contains(DIET))
    assert(result(FISH).contains(NORMAL))

    assert(result(MEAT).contains(NORMAL))
    assert(result(MEAT).contains(DIET))
    assert(result(MEAT).contains(FAT))

    assert(result(OTHER).contains(DIET))
    assert(result(OTHER).contains(NORMAL))
  }

  test("Partition vegetarian dishes"){

    val (vegetarian, nonvegetarian) = fixture.partitionByVegetarian

    assertResult(5)(nonvegetarian.size)
    assertResult("pork")(nonvegetarian(0).name)
    assertResult("beef")(nonvegetarian(1).name)
    assertResult("chicken")(nonvegetarian(2).name)
    assertResult("prawns")(nonvegetarian(3).name)
    assertResult("salmon")(nonvegetarian(4).name)

    assertResult(4)(vegetarian.size)
    assertResult("french fries")(vegetarian(0).name)
    assertResult("rice")(vegetarian(1).name)
    assertResult("season fruit")(vegetarian(2).name)
    assertResult("pizza")(vegetarian(3).name)
  }

  test("Partition vegetarian dishes and group by type") {

    val (vegetarian, nonvegetarian) = fixture.vegetarianDishesByType

    assertResult(4)(vegetarian(OTHER).size)

    assertResult("french fries")(vegetarian(OTHER)(0).name)
    assertResult("rice")(vegetarian(OTHER)(1).name)
    assertResult("season fruit")(vegetarian(OTHER)(2).name)
    assertResult("pizza")(vegetarian(OTHER)(3).name)


    assertResult(2)(nonvegetarian(FISH).size)
    assertResult("prawns")(nonvegetarian(FISH)(0).name)
    assertResult("salmon")(nonvegetarian(FISH)(1).name)

    assertResult(3)(nonvegetarian(MEAT).size)
    assertResult("pork")(nonvegetarian(MEAT)(0).name)
    assertResult("beef")(nonvegetarian(MEAT)(1).name)
    assertResult("chicken")(nonvegetarian(MEAT)(2).name)
  }

  test("Most caloric dish by type"){

    val (vegetarian, nonvegetarian) = fixture.mostCaloricPartitionedByVegetarian

    assertResult("pizza")(vegetarian.name)
    assertResult("pork")(nonvegetarian.name)
  }

}
