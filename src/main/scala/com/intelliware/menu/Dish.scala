package com.intelliware.menu

import ca.intelliware.menu.Dish.Type


case class Dish(name: String, vegetarian: Boolean, calories: Int, dtype: Type) {

  override def toString = name
}