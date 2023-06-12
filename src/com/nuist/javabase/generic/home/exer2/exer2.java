package com.nuist.javabase.generic.home.exer2;

import org.testng.mustache.Value;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-10 23:38
 */
public class exer2 {
    public static void main(String[] args) {
//        1. 创建一个ArrayList集合对象，并指定泛型为<Integer>。
        ArrayList<Integer> list = new ArrayList<>();
//        2. 添加5个[0,100)以内的随机整数到集合中。
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * (99 - 0 + 1));
            list.add(random);
        }
//        3. 使用foreach遍历输出5个整数。
        for (Integer value : list) {
            System.out.println(value);
        }
//        4. 使用集合的removeIf方法删除偶数，为Predicate接口指定泛型<Integer>
//        Predicate是讲新特性的时候的函数式接口。
        list.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {//抽象方法
                return value % 2 == 0;//如果是true就给你remove
            }
        });
        System.out.println();
//        5. 再使用Iterator迭代器输出剩下的元素，为Iterator接口指定泛型<Integer>
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer value = iterator.next();
            System.out.println(value);
        }
    }
}
