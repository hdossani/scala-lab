package ca.intelliware.scalalab.collections.menu

import ca.intelliware.j8lab.streams.menu.Dish.Type


case class Dish(name: String, vegetarian: Boolean, calories: Int, dtype: Type) {

  override def toString = name
}