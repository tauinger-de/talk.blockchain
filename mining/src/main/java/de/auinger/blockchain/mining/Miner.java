package de.auinger.blockchain.mining;

import de.auinger.blockchain.Block;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.Base64;

public class Miner {

    private static final MessageDigest digest;

    private final int difficulty;

    static {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Miner(int difficulty) {
        this.difficulty = difficulty;
    }

    public Block mine(Block block) {
        long startMillis = System.currentTimeMillis();
        int currentNonce = 0;
        while (true) {
            Block proovedBlock = proof(block, currentNonce);
            if (proovedBlock != null) {
                long duration = System.currentTimeMillis() - startMillis;
                System.out.println("Mined block with nonce " + currentNonce + " in " + duration + " ms");
                return proovedBlock;
            }
            currentNonce++;
        }
    }

    private Block proof(Block block, int nonce) {
        String now = ZonedDateTime.now().toString();
        String input = block.getTransactions().toString()
                + block.getBlockNumber()
                + block.getHashOfPreviousBlock()
                + nonce
                + now;
        var hash = Base64.getEncoder().encodeToString(digest.digest(input.getBytes()));
        System.out.println(hash);
        var requiredPrefix = StringUtils.repeat("0", difficulty);
        if (hash.startsWith(requiredPrefix)) {
            return block.withNonceAtDateTime(nonce, now);
        } else {
            return null;
        }
    }

}
