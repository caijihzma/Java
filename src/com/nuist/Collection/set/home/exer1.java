package com.nuist.Collection.set.home;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-03 17:50
 */
public class exer1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(34);
        list.add(34);
        list.add(34);
        list.add(22);
        list.add(22);
        list.add(22);
        list.add(45);
        list.add(45);
        list.add(45);

        List newList = duplicateList(list);
        System.out.println(newList);
    }

    public static List duplicateList(List list){
        //方式1：
//        HashSet hashSet = new HashSet();
//        for(Object obj : list){
//            hashSet.add(obj);//Integer都已经重写了equals和hashCode了
//        }
//        //转换成为List
//        List list1 = new ArrayList();
//        for(Object obj : hashSet){
//            list1.add(obj);
//        }
//        return list1;
        //方式2：其实里面的逻辑是一样的，只不过不用我们自己写了而已
        HashSet hashSet = new HashSet(list);
        List list1 = new ArrayList(hashSet);
        return list1;

    }

}
