package ca.wglabs.streams.transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TransactionInquiryJ8 implements TransactionInquiry {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    /**
     * Find how many transactions are from 2012.
     */
    public Long findNumberOfTransactionsFrom2012() {
        return 0L;
    }

    /**
     * Find all transactions from year 2011 and sort them by value (small to high).
     */
    public List<Transaction> findTransactionsFrom2011() {
        return new ArrayList<>();
    }

    /**
     * Find all the unique cities where the traders work.
     */
    public List<String> findAllUniqueCities() {
        return new ArrayList<>();
    }

    /**
     * Find all traders from Cambridge and sort them by name.
     */
    public List<Trader> findAllTradersFromCambridge() {
        return new ArrayList<>();
    }

    /**
     * Get a string of all traders’ names sorted alphabetically.
     */
    public String getAllTradersNames() {
        return "";
    }

    /**
     * Are there any trader based in Milan?
     */
    public Boolean areThereAnyTraderFromMilan() {
        return false;
    }

    /**
     * Update all transactions so that the traders from Milan are set to Cambridge.
     */
    public List<Transaction> updateTradersFromMilanToCambridge() {
        return transactions;
    }

    /**
     * Get the highest value in all the transactions.
     */
    public Integer getHighestTransactionValue() {
        return 0;
    }

    /**
     * Get the sum of all transaction values.
     */
    public Integer getTransactionTotal() {
        return 0;
    }

}