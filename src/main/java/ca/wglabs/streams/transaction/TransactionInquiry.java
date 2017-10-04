package ca.wglabs.streams.transaction;

import java.util.List;

public interface TransactionInquiry {


    Long findNumberOfTransactionsFrom2012();

    List<Transaction> findTransactionsFrom2011();

    List<String> findAllUniqueCities();

    List<Trader> findAllTradersFromCambridge();

    String getAllTradersNames();

    Boolean areThereAnyTraderFromMilan();

    List<Transaction> updateTradersFromMilanToCambridge();

    Integer getHighestTransactionValue();

    Integer getTransactionTotal();
}
