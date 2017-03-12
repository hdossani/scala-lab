package com.intelliware.transaction

case class Trader(name: String, city: String) {
  override def toString: String = "Trader:" + name + " in " + city
}
