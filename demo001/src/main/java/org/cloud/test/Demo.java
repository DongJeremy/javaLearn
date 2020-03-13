package org.cloud.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        lists.add(7);
        System.out.println(lists);
    }

}
