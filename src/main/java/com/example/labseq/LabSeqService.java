package com.example.labseq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

/**
 * Service responsible for calculating values of the LabSeq series.
 * It utilizes caching to optimize repeated requests for the same value.
 */
@Service
public class LabSeqService {

    // Logger for this service class
    private static final Logger logger = LoggerFactory.getLogger(LabSeqService.class);

    /**
     * Calculate and return the LabSeq value for a given 'n'.
     * This method benefits from caching. If a value is not found in cache, it computes and caches it.
     *
     * @param n The input for which the LabSeq value is needed.
     * @return The computed LabSeq value.
     */


    @Cacheable(value = "labseq", key = "#n")
    public BigInteger calculateLabSeq(int n) {
        // Log when a value is not found in the cache and needs computation.
        logger.info("Cache miss for n={}", n);

        // Base Cases for LabSeq series
        if (n == 0 || n == 2) return BigInteger.ZERO;
        if (n == 1 || n == 3) return BigInteger.ONE;

        BigInteger[] labSeq = new BigInteger[4];
        labSeq[0] = labSeq[2] = BigInteger.ZERO;
        labSeq[1] = labSeq[3] = BigInteger.ONE;

        // Calculate the LabSeq series using a bottom-up approach.
        // Only the last 4 values are kept to prevent stack overflow for large inputs.
        for (int i = 4; i <= n; i++) {
            BigInteger newVal = labSeq[(i - 4) % 4].add(labSeq[(i - 3) % 4]);
            labSeq[i % 4] = newVal;
        }

        // Return the LabSeq value for 'n'. Using 'n % 4' gives the correct index
        // within the circular buffer of size 4.
        return labSeq[n % 4];
    }
}
