package com.homework.contestservices.fibonacci.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciImpl {
    public static final int LEN_MIN = 1;
    public static final int LEN_MAX = 10;
    private FibonacciImpl() {
    }
   
    public static List<BigInteger> getFibonacci(int len) throws IllegalArgumentException {
    		List<BigInteger> series = new ArrayList<BigInteger>();
    		if (len < FibonacciImpl.LEN_MIN) {
            throw new IllegalArgumentException(String.format("Length was less than %d. [%d]", FibonacciImpl.LEN_MIN, len));
        }
    		BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        series.add(a);
        series.add(b);
        series.add(c);
        for (int j=2 ; j<=len; j++)
        {
            c =  a.add(b);
            series.add(c);
            a = b;
            b = c;
        }
        return series;
    }
}
