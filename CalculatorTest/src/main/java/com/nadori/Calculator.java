package com.nadori;

import java.util.HashSet;
import java.util.Set;

public class Calculator {
    public int add(int a, int b) {
        return a+b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public void longCalculation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Integer> digitsSet(int n) {
        Set<Integer> nums= new HashSet<>();
       // int n = 95897;
        if (n == 0)
            nums.add(0);
        if(n<0)
            n=-n;
        while (n > 0) {
            nums.add(n%10);
            n = n / 10;
        }

       return  nums;
    }
}
