package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigmacTestSuite {
    @Test
    void testBigmacNew() {
//    given
        Bigmac bigMac = new Bigmac.BigMacBuilder()
                .bun("Bun")
                .burgers(2)
                .sauce("Standard")
                .ingredient("Lettuce")
                .ingredient("Onion")
                .build();
        System.out.println(bigMac);
//        when
        int howManyIngredients = bigMac.getIngredients().size();
//        then
        assertEquals(2, howManyIngredients);
    }
}