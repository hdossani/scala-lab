package ca.wglabs.collections.menu

import ca.wglabs.streams.menu.Dish.Type

import ca.wglabs.streams.menu.Dish.CaloricLevel


object MenuInquiryS extends MenuInquiry {

  /**
   *  Find the names of all the dishes with more than 400 calories.
   */
  def getHighCaloricDishNames = menu.filter(d => d.calories > 400)
      .sortBy(d => d.calories)
      .map(???)

  /**
    * Return the name of all the dishes separated by comma.
    */
  def getShortMenuCommaSeparated = ???


  /**
    * Group the dishes by its type.
    */
  def groupDishesByType : Map[Type, List[Dish]] = ???

  /**
    * Group the dishes by their caloric level. (DIET: less than 400, NORMAL: between 400 and 700, FAT: more than 700)
    */
  def groupDishesByCaloricLevel : Map[CaloricLevel, List[Dish]] = {

    menu.groupBy(???)
  }

  def mapDishToCaloricLevel : (Dish => CaloricLevel) = {
    dish => ???
  }

  /**
    * Group the dishes by their types and within those groups, re-group them by caloric level.
    *
    * Hint: Use map and pattern matching.
    */
  def groupDishesByTypeAndCaloricLevel : Map[Type, Map[CaloricLevel, List[Dish]]] = ???

  /**
    * Return the number of dishes of each group.
    */
  def countDishesInGroups : Map[Type, Int] = ???

  /**
    * Return the total amount of calories for each group.
    */
  def sumCaloriesByType : Map[Type, Int] = {
    groupDishesByType.map {
      ???
    }
  }

  /**
    * Returns the dish caloric levels grouped by their type.
    */
  def caloricLevelsByType : Map[Type, Set[CaloricLevel]] = ???

  /**
    * Partition the list of dishes in two groups: vegetarian and non-vegetarian.
    */
  def partitionByVegetarian : (List[Dish], List[Dish]) = ???

  /**
    * Partition the list of dishes in two groups: vegetarian and non-vegetarian.
    * Within those groups, re-group them by dish type.
    */
  def vegetarianDishesByType : (Map[Type, List[Dish]], Map[Type, List[Dish]]) = {
    val (vegetarian, nonvegetarian) = partitionByVegetarian
    ???
  }

  /**
    * Return the most caloric vegetarian and non-vegetarian dishes.
    *
    * hint: Use pattern matching.
    */
  def mostCaloricPartitionedByVegetarian : (Dish, Dish) = ???


}
