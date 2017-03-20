package ca.intelliware.scalalab.transaction

case class Trader(name: String, var city: String) {
  override def toString = "Trader:" + name + " in " + city
}
