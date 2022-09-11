package com.example.pokemon.utility.easyr;

import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.number.BigDecimalRandomizer;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.math.RoundingMode.HALF_EVEN;

public final class EasyRandomConfig {

    private EasyRandomConfig() {
    }


    public static EasyRandomParameters getDefault() {

        return new EasyRandomParameters()
                .collectionSizeRange(2, 10)
                .dateRange(LocalDate.of(1990, 1, 1), LocalDate.now())
                .stringLengthRange(3, 12)
                .randomize(BigDecimal.class, new BigDecimalRandomizer(3, HALF_EVEN))
                .objectFactory(new RecordFactory());

    }

    public static EasyRandomParameters getDefaultLargeCollection() {

        return new EasyRandomParameters()
                .collectionSizeRange(30, 100)
                .dateRange(LocalDate.of(1990, 1, 1), LocalDate.now())
                .stringLengthRange(3, 12)
                .randomize(BigDecimal.class, new BigDecimalRandomizer(3, HALF_EVEN))
                .objectFactory(new RecordFactory());
    }

}
