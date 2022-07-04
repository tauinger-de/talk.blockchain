package de.auinger.blockchain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Transaction {

    private String fromKey;
    private String toKey;
    private float amount;

}
