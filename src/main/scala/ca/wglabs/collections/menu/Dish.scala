package ca.wglabs.collections.menu

import ca.wglabs.streams.menu.Dish.Type


case class Dish(name: String, vegetarian: Boolean, calories: Int, dtype: Type) {

  override def toString = name
}