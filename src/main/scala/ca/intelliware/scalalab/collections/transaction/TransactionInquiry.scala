package ca.intelliware.scalalab.collections.transaction

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
  def findNumberOfTransactionsFrom2012 = transactions.count(t => t.year == 2012)

  /**
    *  Find all transactions from year 2011 and sort them by value (small to high).
    */
  def findTransactionsFrom2011 = ???

  /**
    * Find all the unique cities where the traders work.
    */
  def findAllUniqueCities = transactions.map(???).distinct

  /**
    * Find all traders from Cambridge and sort them by name.
    */
  def findAllTradersFromCambridge = ???


  /**
    * Get a string of all traders’ names sorted alphabetically.
    */
  def getAllTradersNames = ???

  /**
    * Are there any trader based in Milan?
    */
  def areThereAnyTraderFromMilan = transactions.exists(???)

  /**
    * Update all transactions so that the traders from Milan are set to Cambridge.
    *
    * hint: Use foreach function to mutate transactions.
    */
  def updateTradersFromMilanToCambridge = ???

  /**
    * Get the highest value in all the transactions.
    */
  def getHighestTransactionValue = ???

  /**
    * Get the sum of all transaction values.
    */
  def getTransactionTotal = transactions.map(???).fold(???)(???)

}