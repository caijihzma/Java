package com.nuist.javabase.selfdefine;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-12 22:25
 * @description
 *SubOrder5是泛型类型
 */
public class SubOrder5 <T,E>extends Order<T>{
    E e;

    public SubOrder5() {
    }

    public SubOrder5(T t, int orderId, E e) {
        super(t, orderId);
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
