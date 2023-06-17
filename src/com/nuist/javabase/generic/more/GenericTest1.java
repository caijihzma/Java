package com.nuist.javabase.generic.more;

import org.testng.annotations.Test;
import org.w3c.dom.ls.LSInput;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-17 18:48
 * @description
 */
public class GenericTest1 {
    /**
     * ?的使用
     */
    @Test
    public void test1() {
        List<?> list = null;
        List<Object> list1 = null;
        List<String> list2 = null;

//        list = list1;//可以赋值
        list = list2;//可以赋值

        method(list1);//不会报错
        method(list2);//不会报错
    }

    public void method(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
//        list.add("AA");错误的，不可以写
    }

    @Test
    public void test2() {
        List<?> list = null;
        List<String> list1 = new ArrayList<>();
        list1.add("AA");

        list = list1;

//        读取数据（以集合为例说明）
        /**
         * 报错，因为get方法它的返回值类型是E，是接口的泛型，但是这里是?，
         * 所以这里按理来说应该是?,但是这里也没有?的类型啊，怎么整？
         * ?你可以理解为不确定的类型，不管你是什么类型，好歹你是引用类型，那
         * 一定是Object的
         */
//        读取
//        String str = list.get(0);错误
        Object obj = list.get(0);//具体里面是什么类型我不知道，但我知道你一定是Object或者是它子类的类型
        System.out.println(obj);

//        写数据（以集合为例说明）
        /**
         * //写?类型吗，不确定，能往里写吗。我也不知道你里面一开始是String类型的
         * 你整个Object类型更不能让你写，因为你整个123不就坏事了吗
         * 所以说：带通配符这样一个集合的类我们想往里面写数据是不行的
         * 就好比你下楼扔垃圾，这个垃圾桶明确写者了厨余的垃圾，你直接厨余垃圾没问题
         * 但是你这里有个垃圾桶上面写了一个?，假设你要往里面扔，就给你喷出来了
         */
//        list.add("BB");报错，？是啥类型啊，不知道，编译器就不敢让你添加，所以就不能添加
//        但是有个特例null
        list.add(null);//不管你这个?是个什么类型，总归是个引用类型，只要是引用类型大家都有个共同的值null
    }

    /**
     * 测试有限制条件的通配符的使用
     * ? extends A:
     * ? super A:
     */
    @Test
    public void test3() {
        List<? extends Farther> list = null;
        List<Object> list1 = null;
        List<Farther> list2 = null;
        List<Son> list3 = null;

//        list = list1;错误，不可以
        list = list2;
        list = list3;
    }

    /**
     * 针对于? extends A的读写
     */
    @Test
    public void test3_1(){
        List<? extends Farther> list = null;
        List<Farther> list1 = new ArrayList<>();
        list = list1;
//        读取数据:可以
        Farther farther = list.get(0);//因为<=Farther
//        写入数据：
        list.add(null);

        /**
         * ?用数学来表示，可以看做负无穷-正无穷，没有上届，也没有下届
         * 所以你完全不知道它是什么类型
         *
         * 而? extends A，相当于有上届，(负无穷，A],在Java中允许这样的情况出现
         * B是A的子类，要是我new了一个B的对象，必须往右放，这叫多态，但是你不能
         * new一个右边的对象往左赋，没有下届，?飘忽不定，假设?在一点，可以new一个左边的对象赋值给这一点，
         * 但只要我一但new了这个左边对象，我这个点还有可能在new的对象的左边呢，所以只要我想new一个对象，我总
         * 可以找到比你这个类型还靠左的，有可能会出现右边的往左边赋，言外之意就是我这是没有下届的，极限就是null
         *
         */
//        list.add(new Farther());报错
//        list.add(new Son());报错
    }
    @Test
    public void test4() {
        List<? super Farther> list = null;
        List<Object> list1 = null;
        List<Farther> list2 = null;
        List<Son> list3 = null;

        list = list1;
        list = list2;
//        list = list3;报错
    }
    @Test
    public void test4_1(){
        List<? super Farther> list = null;
        List<Farther> list1 = new ArrayList<>();
        list1.add(new Farther());

        list = list1;
//        读取数据：可以的，是Object
        Object obj = list.get(0);
//        写入数据：可以将Farther及其子类对象添加进来
        /**
         * [A,正无穷)这个是往上飘忽不定的，你整个Object都到头了，若？就是A类型的,你new了一个Object
         * 赋值给了A（Farther），显然不行。下届已经确定就是Farther了，左边的类型都可以给他赋值，体现了
         * 多态，你有下届的话，我new一个farther就行。
         */
        list.add(null);
//        list.add(new Object());报错
        list.add(new Farther());
        list.add(new Son());
    }
}
