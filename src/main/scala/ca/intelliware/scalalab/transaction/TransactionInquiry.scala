package ca.intelliware.scalalab.transaction

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
  def findNumberOfTransactionsFrom2012 = transactions.count(_.year == 2012)

  /**
    *  Find all transactions from year 2011 and sort them by value (small to high).
    */
  def findTransactionsFrom2011 = transactions.filter(_.year == 2011).sortBy(_.value)

  /**
    * Find all the unique cities where the traders work.
    */
  def findAllUniqueCities = transactions.map(_.trader.city).distinct

  /**
    * Find all traders from Cambridge and sort them by name.
    */
  def findAllTradersFromCambridge = transactions.map(_.trader).filter(_.city equals "Cambridge").distinct.sortBy(_.name)


  /**
    * Get a string of all traders’ names sorted alphabetically.
    */
  def getAllTradersNames = transactions.map(_.trader.name).distinct.sorted.foldLeft("")(_+_)

  /**
    * Are there any trader based in Milan?
    */
  def areThereAnyTraderFromMilan = transactions.exists(_.trader.city equals "Milan")

  /**
    * Update all transactions so that the traders from Milan are set to Cambridge.
    */
  def updateTradersFromMilanToCambridge = {
    transactions.map(_.trader).filter(_.city equals "Milan").foreach(_.city = "Cambridge")
    transactions
  }

  /**
    * Get the highest value in all the transactions.
    */
  def getHighestTransactionValue = transactions.maxBy(_.value).value

  /**
    * Get the sum of all transaction values.
    */
  def getTransactionTotal = transactions.map(_.value).fold(0)(_+_)

}