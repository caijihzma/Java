package com.nuist.javabase.selfdefine;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-11 22:27
 */
public class GenericTest {
    @Test
    public void test1(){
        Person p1 = new Person();
        ArrayList list = new ArrayList();//向下兼容，JDK5.0之前集合是没有声明为泛型的。
        list.add(123);
        list.add("AA");
    }

//    测试自定义泛型类
    @Test
    public void test2(){
//        实例化时，就可以指明类的泛型参数的类型
        Order order = new Order();
        Object obj = order.getT();
//        order.setT();

//        泛型参数在指明时，是不可以使用基本数据类型的,但是可以使用包装类替代基本数据类型。
//        在实例化时,可以指明类型的具体类型。一旦指明了泛型的类型，则在泛型类中凡是使用泛型
//        参数的位置，都替换为指定的类型。
        Order<Integer> order2 = new Order<>();
        Integer t = order2.getT();

        Order<String> order3 = new Order<>();
        order3.setT("AA");
    }

    /**
     * 厕所Order的子类
     */
    @Test
    public void test3(){
//        实例化subOrder1
        SubOrder1 subOrder1 = new SubOrder1();
        Object t = subOrder1.getT();
//        SubOrder1<Integer> subOrder2 = new SubOrder1<>();//因为SubOrder1不是泛型类，此处编译错误

    }

    @Test
    public void test4(){
        SubOrder2 subOrder2 = new SubOrder2();
        Integer t = subOrder2.getT();//因为继承的Order是泛型的，所以返回的元素类型是Integer类型的

//        父类不确定，子类也不确定，只是对功能实现扩展
        SubOrder3<String> sub2 = new SubOrder3<>();
        String t1 = sub2.getT();
        sub2.show("AA");

        SubOrder4<String> sub3 = new SubOrder4<>();
        Integer t2 = sub3.getT();
        String e = sub3.getE();

        SubOrder5<String, Integer> sub4 = new SubOrder5<>();
        String t3 = sub4.getT();
        Integer e1 = sub4.getE();
    }

    /**
     * 测试泛型方法的使用
     */
    @Test
    public  void test5(){
//        order1调用copyFromArrayToList方法，与<String>无关，因为Order是T，方法是E，一点关系都没有
        Order<String> order1 = new Order<>();
        Integer[] arr = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = order1.copyFromArrayToList(arr);
        for(Integer i : list){
            System.out.println(i);
        }
    }
}
