package com.interview.project.primenumber.services;

import org.springframework.stereotype.Service;

@Service
public class NumberService {

    private boolean isPrimeNumber(Integer num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public Integer getHighestPrimeNumber(Integer inputNumber) {
        if (inputNumber <= 2) {
            return -1;
        }
        for (int i = inputNumber - 1; ; i--) {
            if (isPrimeNumber(i)) {
                return i;
            }
        }
    }
}
