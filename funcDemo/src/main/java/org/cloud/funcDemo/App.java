package org.cloud.funcDemo;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = (x, y) -> x+y;
        int m = add.apply(12, 34);
        System.out.println(m);
        Predicate<Integer> atLeast5 = x -> x > 5;
        System.out.println(atLeast5.test(4));
        
    }
}
