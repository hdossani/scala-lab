package com.intelliware.menu


import ca.intelliware.menu.Dish.Type


object MenuInquiry {

  val menu = List(
     Dish("pork", false, 800, Type.MEAT),
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
    * Find the name of all the dishes with less than 400 calories.
    */

}
