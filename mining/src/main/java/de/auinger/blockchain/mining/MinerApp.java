package de.auinger.blockchain.mining;

import de.auinger.blockchain.Block;
import de.auinger.blockchain.Transaction;

import java.util.List;

public class MinerApp {

    public static void main(String[] args) {
        int difficulty = (args.length == 1) ? Integer.parseInt(args[0]) : 3;
        System.out.println("Running with difficulty " + difficulty);

        var miner = new Miner(difficulty);
        Block minedBlock = miner.mine(
                new Block(
                        1,
                        "",
                        List.of(
                                new Transaction("from", "to", 1.00f)
                        )
                )
        );
        System.out.println(minedBlock);
    }
}
