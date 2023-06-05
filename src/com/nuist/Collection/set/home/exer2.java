package com.nuist.Collection.set.home;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-03 19:12
 */
public class exer2 {
    public static void main(String[] args) {
        Set set = new HashSet();
        while(set.size() < 10) {
            int random = (int) (Math.random() * (20 - 1 + 1) + 1);
            set.add(random);
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
