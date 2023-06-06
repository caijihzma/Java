package com.nuist.javabase.Collection.set.interview;

import java.util.HashSet;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-04 9:35
 */
public class HashCodeDemo {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        set.add(p1);
        set.add(p2);
//        System.out.println(set);

        p1.name = "CC";
        set.remove(p1);
//        System.out.println(set);

        set.add(new Person(1001, "CC"));
        System.out.println(set);
    }
}
