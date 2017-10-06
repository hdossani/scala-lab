package ca.wglabs.collections.transaction

import org.scalatest.FunSuite


class TransactionInquiryTest extends FunSuite {

  val fixture = TransactionInquiryS

  ignore("Total number of transactions from 2012") {
    assertResult(4)(fixture.findNumberOfTransactionsFrom2012)
  }

  ignore("Transactions from 2011 sorted by value") {

    val result = fixture.findTransactionsFrom2011

    assertResult(2)(result.size)
    assertResult(2011)(result(0).year)
    assertResult(300)(result(0).value)
    assertResult(2011)(result(1).year)
    assertResult(400)(result(1).value)
  }

  ignore("All unique cities") {

    val result = fixture.findAllUniqueCities

    assertResult(2)(result.size)
    assertResult("Cambridge")(result(0))
    assertResult("Milan")(result(1))
  }

  ignore("All traders from Cambridge") {

    val result = fixture.findAllTradersFromCambridge

    assertResult(3)(result.size)
    assertResult("Alan")(result(0).name)
    assertResult("Brian")(result(1).name)
    assertResult("Raoul")(result(2).name)

  }

  ignore("All trader's names sorted alphabetically") {

    assertResult("AlanBrianMarioRaoul")(fixture.getAllTradersNames)
  }

  ignore("Trader from Milan") {

    assert(fixture.areThereAnyTraderFromMilan)
  }

  ignore("Update traders from Milan to Cambridge"){

    val result = fixture.updateTradersFromMilanToCambridge

    assertResult(6)(result.size)
    assertResult("Cambridge")(result(3).trader.city)
    assertResult("Cambridge")(result(4).trader.city)
  }

  ignore("Highest transaction value"){

    assertResult(1000)(fixture.getHighestTransactionValue)
  }

  ignore("Transaction total"){

    assertResult(4060)(fixture.getTransactionTotal)
  }

}
