package ca.intelliware.scalalab.menu

import ca.intelliware.j8lab.menu.Dish.Type

import ca.intelliware.j8lab.menu.Dish.CaloricLevel
import ca.intelliware.j8lab.menu.Dish.CaloricLevel._


object MenuInquiry {

  val menu = List(
     Dish("pork", vegetarian = false, 800, Type.MEAT),
     Dish("beef", false, 700, Type.MEAT),
     Dish("chicken", false, 400, Type.MEAT),
     Dish("french fries", true, 530, Type.OTHER),
     Dish("rice", true, 350, Type.OTHER),
     Dish("season fruit", true, 120, Type.OTHER),
     Dish("pizza", true, 550, Type.OTHER),
     Dish("prawns", false, 400, Type.FISH),
     Dish("salmon", false, 450, Type.FISH)
  )

  /**
    * Find the name of all the dishes with more than 400 calories.
    */
  def getLowCaloricDishNames = {
     menu.filter(_.calories > 400)
       .sortBy(_.calories)
       .map(_.name)
  }

  /**
    * Return the name of all the dishes separated by comma.
    */
  def getShortMenuCommaSeparated = menu.map(_.name).mkString(", ")


  /**
    * Group the dishes by type.
    */
  def groupDishesByType : Map[Type, List[Dish]] = menu.groupBy(dish => dish.dtype)

  /**
    * Group the dishes by caloric level. (DIET: less than 400, NORMAL: between 400 and 700, FAT: more than 700)
    */
  def groupDishesByCaloricLevel : Map[CaloricLevel, List[Dish]] = {
    menu.groupBy(mapDishToCaloricLevel)
  }

  def mapDishToCaloricLevel : (Dish => CaloricLevel) = {
    dish => if (dish.calories <= 400) DIET
    else if (dish.calories <= 700) NORMAL
    else FAT
  }


  /**
    * Group the dishes by type and caloric level
    */
  def groupDishesByTypeAndCaloricLevel : Map[Type, Map[CaloricLevel, List[Dish]]] = {
    groupDishesByType.map {
      case (dtype , dishes) => (dtype -> dishes.groupBy(mapDishToCaloricLevel))
    }
  }

  /**
    * Count dishes in groups.
    */
  def countDishesInGroups : Map[Type, Int] = menu.groupBy(_.dtype).mapValues(_.size)

  /**
    * Get the sum of calories by dish type.
    */
  def sumCaloriesByType : Map[Type, Int] = {
    groupDishesByType.map {
      case (dtype , dishes) => (dtype -> dishes.map(_.calories).foldLeft(0)(_+_))
    }
  }

  /**
    * Group the caloric level by dish type.
    */
  def caloricLevelsByType : Map[Type, Set[CaloricLevel]] = {
    groupDishesByType.map {
      case (dtype , dishes) => (dtype -> dishes.map(mapDishToCaloricLevel).toSet)
    }
  }

  /**
    * Partition the menu by vegetarian dish.
    */
  def partitionByVegetarian : (List[Dish], List[Dish]) = menu.partition(_.vegetarian)

  /**
    * Group vegetarian dishes by type.
    */
  def groupVegetarianDishesByType : (Map[Type, List[Dish]], Map[Type, List[Dish]]) = {
    val partition = partitionByVegetarian
    (partition._1.groupBy(_.dtype), partition._2.groupBy(_.dtype))
  }

  /**
    * Get the most caloric vegetarian and non-vegetarian dishes.
    */
  def mostCaloricPartitionedByVegetarian : (Dish, Dish) = {
    partitionByVegetarian match {
      case (vegetarian, nonvegetarian) => (vegetarian.maxBy(_.calories), nonvegetarian.maxBy(_.calories))
    }

  }

}
