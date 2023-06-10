package com.nuist.javabase.generic;
import org.testng.annotations.Test;
import java.util.*;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-08 23:58
 */
public class CollectionMapTest {
    //    体会集合中使用泛型的场景
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(67);
        list.add(78);
        list.add(76);
        list.add(99);

//        1问题1：类型不安全。因为add()的参数是Object类型，意味着任何类型的对象都可以添加成功
//        list.add("AA");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
//          2、问题2：需要使用强转操作，繁琐，还有可能导致ClassCastException异常
            Integer i = (Integer) iterator.next();
            int score = i;

            System.out.println(score);
        }
    }

    //    在集合中使用泛型的例子
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(78);
        list.add(76);
        list.add(66);
        list.add(99);
//编译报错，保证类型的安全
//        list.add("AA");

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
//          因为添加的都是Integer类型，避免了强转操作
            Integer i = iterator.next();
            int score = i;//自动拆箱
            System.out.println(score);
        }
    }

    /**
     * 泛型在Map中使用的例子
     */
    @Test
    public void test3() {
//        HashMap<String, Integer> map = new HashMap<String,Integer>();

//        jdk7的新特性
        HashMap<String, Integer> map = new HashMap<>();//类型推断
        map.put("Tom", 67);
        map.put("Jerry", 87);
        map.put("Rose", 99);

        //Entry是内部的接口，需要使用外部的接口去调用
//        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

//        上面alt+回车就会自动生成前面的类型，既然能够生成，那它就是知道类型是什么，为了
//        不让自己看到这么复杂，var一下，总之来讲，我们知道，不如编译器知道，自己调用完之后
//        就能够自动判断什么类型，就可以写var，自己定义var类型的变量，根本就不知道怎么回事。
        var entrySet = map.entrySet();//jdk10新特性
        var iterator = entrySet.iterator();


        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "-->" + value);
        }

    }
}
