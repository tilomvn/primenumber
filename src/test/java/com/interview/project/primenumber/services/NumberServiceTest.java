package com.interview.project.primenumber.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NumberServiceTest {

    @Autowired
    private NumberService numberService;

    @Test
    void testGetHighestPrimeNumberNormalCase() {
        Integer primeNumber = numberService.getHighestPrimeNumber(55);
        assertEquals(53, primeNumber);
    }

    @Test
    void testGetHighestPrimeNumberFrom3() {
        Integer primeNumber = numberService.getHighestPrimeNumber(3);
        assertEquals(2, primeNumber);
    }

    @Test
    void testGetHighestPrimeNumberFrom2() {
        Integer primeNumber = numberService.getHighestPrimeNumber(2);
        assertEquals(-1, primeNumber);
    }

    @Test
    void testGetHighestPrimeNumberFrom1() {
        Integer primeNumber = numberService.getHighestPrimeNumber(1);
        assertEquals(-1, primeNumber);
    }

    @Test
    void testGetHighestPrimeNumberFrom0() {
        Integer primeNumber = numberService.getHighestPrimeNumber(0);
        assertEquals(-1, primeNumber);
    }

    @Test
    void testGetHighestPrimeNumberFromHaifu1() {
        Integer primeNumber = numberService.getHighestPrimeNumber(-1);
        assertEquals(-1, primeNumber);
    }
}
