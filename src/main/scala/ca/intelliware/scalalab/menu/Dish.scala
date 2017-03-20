package ca.intelliware.scalalab.menu

import ca.intelliware.j8lab.menu.Dish.Type


case class Dish(name: String, vegetarian: Boolean, calories: Int, dtype: Type) {

  override def toString = name
}