package ca.wglabs.collections.transaction

trait TransactionInquiry {

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

  def findNumberOfTransactionsFrom2012

  def findTransactionsFrom2011 : List[Transaction]

  def findAllUniqueCities : List[String]

  def findAllTradersFromCambridge : List[Trader]

  def getAllTradersNames

  def areThereAnyTraderFromMilan : Boolean

  def updateTradersFromMilanToCambridge : List[Transaction]

  def getHighestTransactionValue

  def getTransactionTotal
}
