package io.maxiplux.tdd.utility;

import java.math.BigDecimal;

public class UtilyClass {
    public static BigDecimal sum(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    public static Double sum(Double a2, Double b2) {
        Integer a = (int) (a2*100.0);
        Integer b = (int) (b2*100f);
        Double base = 100d;


        return (a+b)/base;
    }

    public static Float sum(Float a3, Float b3) {
        Integer a = (int) (a3*100.0);
        Integer b = (int) (b3*100f);
        return  (a+b)/100f;
    }
}
