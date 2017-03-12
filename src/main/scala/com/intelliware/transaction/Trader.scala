package com.intelliware.transaction

case class Trader(name: String, var city: String) {
  override def toString: String = "Trader:" + name + " in " + city
}
