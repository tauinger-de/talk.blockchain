package de.auinger.blockchain;

import lombok.Getter;
import lombok.ToString;

import java.util.List;


@Getter
@ToString
public class Block {

    private final int blockNumber;

    private final String hashOfPreviousBlock;

    private final List<Transaction> transactions;

    private int nonce;

    private String minedDateTime;

    public Block(int blockNumber, String hashOfPreviousBlock, List<Transaction> transactions) {
        this.blockNumber = blockNumber;
        this.hashOfPreviousBlock = hashOfPreviousBlock;
        this.transactions = transactions;
    }


    public Block withNonceAtDateTime(int nonce, String dateTime) {
        this.nonce = nonce;
        this.minedDateTime = dateTime;
        return this;
    }
}
