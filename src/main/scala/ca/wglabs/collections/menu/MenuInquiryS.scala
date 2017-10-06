package ca.wglabs.collections.menu

import ca.wglabs.streams.menu.Dish.Type

import ca.wglabs.streams.menu.Dish.CaloricLevel
import ca.wglabs.streams.menu.Dish.CaloricLevel._


object MenuInquiryS extends MenuInquiry {

  /**
   *  Find the names of all the dishes with more than 400 calories.
   */
  def getHighCaloricDishNames = menu.filter(d => d.calories > 400)
      .sortBy(d => d.calories)
      .map(d => d.name)

  /**
    * Return the name of all the dishes separated by comma.
    */
  def getShortMenuCommaSeparated = menu.map(d => d.name).mkString(", ")

  /**
    * Group the dishes by its type.
    */
  def groupDishesByType : Map[Type, List[Dish]] = menu.groupBy(dish => dish.dtype)

  /**
    * Group the dishes by their caloric level. (DIET: less than 400, NORMAL: between 400 and 700, FAT: more than 700)
    */
  def groupDishesByCaloricLevel : Map[CaloricLevel, List[Dish]] = menu.groupBy(mapDishToCaloricLevel)

  def mapDishToCaloricLevel : (Dish => CaloricLevel) = { dish =>
    if (dish.calories <= 400) DIET
    else if (dish.calories <= 700) NORMAL
    else FAT
  }

  /**
    * Group the dishes by their types and within those groups, re-group them by caloric level.
    *
    * Hint: Use map and pattern matching.
    */
  def groupDishesByTypeAndCaloricLevel : Map[Type, Map[CaloricLevel, List[Dish]]] = {
     groupDishesByType.map {
       case (dtype , dishes) => (dtype -> dishes.groupBy(mapDishToCaloricLevel))
     }
  }

  /**
    * Return the number of dishes of each group.
    */
  def countDishesInGroups : Map[Type, Int] = menu.groupBy(d => d.dtype).mapValues(dishes => dishes.size)

  /**
    * Return the total amount of calories for each group.
    */
  def sumCaloriesByType : Map[Type, Int] = {
    groupDishesByType.map {
      case (dtype , dishes) => (dtype -> dishes.map(d => d.calories).foldLeft(0)((c1, c2) => c1 + c2))
    }
  }

  /**
    * Returns the dish caloric levels grouped by their type.
    */
  def caloricLevelsByType : Map[Type, Set[CaloricLevel]] = {
    groupDishesByType.map {
      case (dtype , dishes) => (dtype -> dishes.map(mapDishToCaloricLevel).toSet)
    }
  }

  /**
    * Partition the list of dishes in two groups: vegetarian and non-vegetarian.
    */
  def partitionByVegetarian : (List[Dish], List[Dish]) = menu.partition(d => d.vegetarian)

  /**
    * Partition the list of dishes in two groups: vegetarian and non-vegetarian.
    * Within those groups, re-group them by dish type.
    */
  def vegetarianDishesByType : (Map[Type, List[Dish]], Map[Type, List[Dish]]) = {
    val (vegetarian, nonvegetarian) = partitionByVegetarian
    (vegetarian.groupBy(_.dtype), nonvegetarian.groupBy(_.dtype))
  }

  /**
    * Return the most caloric vegetarian and non-vegetarian dishes.
    *
    * Hint: Use pattern matching.
    */
  def mostCaloricPartitionedByVegetarian : (Dish, Dish) = {
    partitionByVegetarian match {
      case (vegetarian, nonvegetarian) => (vegetarian.maxBy(_.calories), nonvegetarian.maxBy(_.calories))
    }
  }
}
