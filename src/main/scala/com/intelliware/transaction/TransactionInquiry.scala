package com.intelliware.transaction

object TransactionInquiry {

  val raoul = Trader("Raoul", "Cambridge")
  val mario = Trader("Mario", "Milan")
  val alan = Trader("Alan", "Cambridge")
  val brian = Trader("Brian", "Cambridge")

  val transactions = List(
    Transaction(brian, 2011, 300),
    Transaction(raoul, 2012, 1000),
    Transaction(raoul, 2011, 400),
    Transaction(mario, 2012, 710),
    Transaction(mario, 2012, 700),
    Transaction(alan, 2012, 950)
  )

   /**
    *  Find how many transactions are from 2012.
    */
  def findNumberOfTransactionsFrom2012 = transactions.count( _.year == 2012)

}