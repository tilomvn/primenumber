package com.interview.project.primenumber.controller;

import com.interview.project.primenumber.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/number")
public class NumberController {

    @Autowired
    private NumberService numberService;

    @GetMapping("/primenumber/{number}")
    public ResponseEntity<?> getHighestPrimeNumber(@PathVariable("number") Integer inputNumber) {
        Integer primeNumber = numberService.getHighestPrimeNumber(inputNumber);
        Map<String, Integer> res = new HashMap<>();
        res.put("prime_number", primeNumber);
        return ResponseEntity.ok(res);
    }
}
