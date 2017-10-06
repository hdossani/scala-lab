package ca.wglabs.collections.menu

import ca.wglabs.streams.menu.Dish.{CaloricLevel, Type}

trait MenuInquiry {

  val menu = List(
    Dish("pork", vegetarian = false, 800, Type.MEAT),
    Dish("beef", false, dtype = Type.MEAT, calories = 700),
    Dish("chicken", false, 400, Type.MEAT),
    Dish("french fries", true, 530, Type.OTHER),
    Dish("rice", true, 350, Type.OTHER),
    Dish("season fruit", true, 120, Type.OTHER),
    Dish("pizza", true, 550, Type.OTHER),
    Dish("prawns", false, 400, Type.FISH),
    Dish(vegetarian = false, calories = 450, dtype = Type.FISH, name = "salmon")
  )

  def getHighCaloricDishNames : List[String]

  def getShortMenuCommaSeparated : String

  def groupDishesByType : Map[Type, List[Dish]]

  def groupDishesByCaloricLevel : Map[CaloricLevel, List[Dish]]

  def groupDishesByTypeAndCaloricLevel : Map[Type, Map[CaloricLevel, List[Dish]]]

  def countDishesInGroups : Map[Type, Int]

  def sumCaloriesByType : Map[Type, Int]

  def caloricLevelsByType : Map[Type, Set[CaloricLevel]]

  def partitionByVegetarian : (List[Dish], List[Dish])

  def vegetarianDishesByType : (Map[Type, List[Dish]], Map[Type, List[Dish]])

  def mostCaloricPartitionedByVegetarian : (Dish, Dish)
}
