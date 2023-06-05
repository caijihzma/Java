package com.nuist.Collection.set;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-02 18:27
 */
public class SetTest {
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add("AA");
        set.add(123);
        set.add("BB");
        set.add(new Student("陈志远",27));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(set.contains(new Student("陈志远",27)));//false,打开注释掉的hashCode就变成true了
    }

    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add("AA");
        set.add(123);
        set.add("BB");
        set.add(new Student("陈志远",27));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
