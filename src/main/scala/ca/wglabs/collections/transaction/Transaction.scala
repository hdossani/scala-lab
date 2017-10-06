package ca.wglabs.collections.transaction

case class Transaction(trader: Trader, year: Int, value: Int) {
  override def toString = s"{$trader, year: $year, value: $value}"
}
