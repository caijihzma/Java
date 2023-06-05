package com.nuist.Collection.set;

import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-03 13:56
 */
public class TreeSetTest {
    /**
     * 自然排序（因为String已经天然实现了）
     */
    @Test
    public void test1() {
        TreeSet treeSet = new TreeSet();
        treeSet.add("CC");
        treeSet.add("AA");
        treeSet.add("DD");
        treeSet.add("MM");
        treeSet.add("GG");
        treeSet.add("SS");
        //有问题，必须同一个类型否则无法比较大小
//        treeSet.add(123);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 自然排序
     */
    @Test
    public void test2() {
        TreeSet treeSet = new TreeSet();
        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 43);
        User u3 = new User("Rose", 13);
        User u4 = new User("Jack", 23);
        User u5 = new User("Tony", 33);

        treeSet.add(u1);
        treeSet.add(u2);
        treeSet.add(u3);
        treeSet.add(u4);
        treeSet.add(u5);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 定制排序
     */
    @Test
    public void test3() {
        Comparator comparator = new Comparator() {
            /**
             * 按照姓名从小到大排列，如果姓名相同，继续比较age，按照从大到小排列
             * @param o1
             * @param o2
             * @return
             */
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    int value = u1.getName().compareTo(u2.getName());
                    if (value != 0) {
                        return value;
                    }
                    return -(u1.getAge() - u2.getAge());
                }
                throw new RuntimeException("类型不匹配");
            }

        };
        TreeSet treeSet = new TreeSet(comparator);
        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 43);
        User u3 = new User("Rose", 13);
        User u4 = new User("Jack", 23);
        User u5 = new User("Tony", 33);

        treeSet.add(u1);
        treeSet.add(u2);
        treeSet.add(u3);
        treeSet.add(u4);
        treeSet.add(u5);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
