package com.nuist.javabase.selfdefine;

import java.util.ArrayList;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-11 23:15
 */
//泛型类
public class Order <T>{
//    声明了类的泛型参数以后，就可以在此类的内部使用此泛型参数。
    T t;
    int orderId;
//    static T t1;

    public Order() {
    }

    public Order(T t, int orderId) {
        this.t = t;
        this.orderId = orderId;
    }

//    如下的两个方法不是泛型方法
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "t=" + t +
                ", orderId=" + orderId +
                '}';
    }


//    不可以在静态方法中使用类的泛型
//    public static void method1(){
//        System.out.println("t:" + t);
//    }

//    自定义泛型方法
    public <E> E method(E str){

        return null;

    }

//    定义泛型方法，将E[]数组元素添加到对应类型的ArrayList中，并返回。
//    ArrayList<E> 返回值类型
    public <E> ArrayList<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
//        遍历数组添加到集合
        for (E e : arr){
            list.add(e);
        }
        return list;
    }
}
