package com.nuist.javabase.generic.more;

import com.google.common.io.LittleEndianDataInputStream;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-16 22:49
 * @description
 */
public class GenericTest {
    @Test
    public void test1() {
        //1、
        Object obj = null;
        String str = "AA";

        obj = str;//基于继承性的多态的使用

        //2、
        Object[] arr = null;
        String[] arr1 = null;

        arr = arr1;//基于继承的多态的使用
    }

    @Test
    public void test2() {
        ArrayList<Object> list1 = null;
        ArrayList<String> list2 = null;

//        list1 = list2;报错
        /**正面证比较困难
         * 反证法
         * 假设list1 = list2是可以的
         * list2.add("AA");
         *list1.add(123)只通过这样一个简单操作绕过泛型了
         * String str = list2.get(1);//相当于取出的123赋值给了str，错误的。
         */
        method(list1);//只能将list1放进去
//        method(list2);list2放进去就报错
    }

    @Test
    public void test3() {
        Person<Object> per = null;
        Person<String> per1 = null;

//        per = per1;报错
    }

    public void method(ArrayList<Object> list) {

    }
    @Test
    public  void test4(){
        List<String> list1 = null;
        ArrayList<String> list2 = new ArrayList<>();

        list1 = list2;//没问题，它俩的泛型一样，属性都是String类型，涉及到的属性方法都是String类型
                      //大家都是一致的，只需要看泛型的前面就行，前面有子父类的关系，或者说继承关系都可以，
                      //就可以使用多态。
        list1.add("AA");
        method(list2);//可以扔进去
    }

    public void method(List<String> list){

    }
}
