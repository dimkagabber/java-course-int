package com.tieto.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimePredicateTest {

    PrimePredicate pp;

    @BeforeEach
    void init(){
        pp = new PrimePredicate();
    }

    @Test
    void testIfPrime() {
        assertTrue(pp.test(2));
        assertTrue(pp.test(3));
        assertTrue(pp.test(7));
        assertTrue(pp.test(11));
        assertFalse(pp.test(0));
        assertFalse(pp.test(1));
        assertFalse(pp.test(4));
        assertFalse(pp.test(6));
        assertFalse(pp.test(8));
        assertFalse(pp.test(9));
        assertFalse(pp.test(10));
    }


}