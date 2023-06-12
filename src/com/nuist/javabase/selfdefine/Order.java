package com.nuist.javabase.selfdefine;

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

    public Order() {
    }

    public Order(T t, int orderId) {
        this.t = t;
        this.orderId = orderId;
    }

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
}
