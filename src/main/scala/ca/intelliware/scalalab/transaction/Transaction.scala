package ca.intelliware.scalalab.transaction

case class Transaction(trader: Trader, year: Int, value: Int) {
  override def toString: String = "{" + trader + ", year: " + year + ", value:" + value + "}"
}
