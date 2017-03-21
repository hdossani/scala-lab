package ca.intelliware.scalalab.collections.menu

import ca.intelliware.j8lab.streams.menu.Dish.Type

import ca.intelliware.j8lab.streams.menu.Dish.CaloricLevel
import ca.intelliware.j8lab.streams.menu.Dish.CaloricLevel._


object MenuInquiry {

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

  /**
    * Find the name of all the dishes with more than 400 calories.
    */
  def getLowCaloricDishNames = {
     menu.filter(d => d.calories > 400)
         .sortBy(d => d.calories)
         .map(???)
  }

  /**
    * Return the name of all the dishes separated by comma.
    */
  def getShortMenuCommaSeparated = ???


  /**
    * Group the dishes by type.
    */
  def groupDishesByType : Map[Type, List[Dish]] = ???

  /**
    * Group the dishes by caloric level. (DIET: less than 400, NORMAL: between 400 and 700, FAT: more than 700)
    */
  def groupDishesByCaloricLevel : Map[CaloricLevel, List[Dish]] = {
    menu.groupBy(???)
  }

  def mapDishToCaloricLevel : (Dish => CaloricLevel) = {
    dish => ???
  }


  /**
    * Group the dishes by type and caloric level
    *
    * hint: Use map and pattern matching.
    */
  def groupDishesByTypeAndCaloricLevel : Map[Type, Map[CaloricLevel, List[Dish]]] = ???

  /**
    * Count dishes in groups.
    */
  def countDishesInGroups : Map[Type, Int] = ???

  /**
    * Get the sum of calories by dish type.
    */
  def sumCaloriesByType : Map[Type, Int] = {
    groupDishesByType.map {
      ???
    }
  }

  /**
    * Group the caloric level by dish type.
    */
  def caloricLevelsByType : Map[Type, Set[CaloricLevel]] = ???

  /**
    * Partition the menu by vegetarian dish.
    */
  def partitionByVegetarian : (List[Dish], List[Dish]) = ???

  /**
    * Group vegetarian dishes by type.
    */
  def groupVegetarianDishesByType : (Map[Type, List[Dish]], Map[Type, List[Dish]]) = {
    val (vegetarian, nonvegetarian) = partitionByVegetarian
    ???
  }

  /**
    * Get the most caloric vegetarian and non-vegetarian dishes.
    *
    * hint: Use pattern matching.
    */
  def mostCaloricPartitionedByVegetarian : (Dish, Dish) = ???


}
