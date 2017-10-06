package ca.wglabs.collections.transaction

object TransactionInquiryS extends TransactionInquiry {

   /**
    *  Find how many transactions are from 2012.
    */
  def findNumberOfTransactionsFrom2012 = transactions.count(t => t.year == 2012)

  /**
    *  Find all transactions from year 2011 and sort them by value (small to high).
    */
  def findTransactionsFrom2011 : List[Transaction]= transactions.filter(t => t.year == 2011).sortBy(_.value)

  /**
    * Find all the unique cities where the traders work.
    */
  def findAllUniqueCities = transactions.map(t => t.trader.city).distinct

  /**
    * Find all traders from Cambridge and sort them by name.
    */
  def findAllTradersFromCambridge: List[Trader] = {
    transactions.map(t => t.trader).filter(_.city equals "Cambridge").distinct.sortBy(_.name)
  }

  /**
    * Get a string of all traders’ names sorted alphabetically.
    */
  def getAllTradersNames = transactions.map(t => t.trader.name).distinct.sorted.foldLeft("")(_+_)

  /**
    * Are there any trader based in Milan?
    */
  def areThereAnyTraderFromMilan = transactions.exists(_.trader.city equals "Milan")

  /**
    * Update all transactions so that the traders from Milan are set to Cambridge.
    *
    * hint: Use foreach function to mutate transactions.
    */
  def updateTradersFromMilanToCambridge : List[Transaction] = {
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