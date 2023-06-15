package com.nuist.javabase.generic.selfdefine;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-12 22:13
 * @description
 * 父类已经确定类型了，子类有不确定的类型
 * SUbOrder4是泛型类
 */
public class SubOrder4<E> extends Order<Integer>{
    E e;

    public SubOrder4() {
    }

    public SubOrder4(E e) {
        this.e = e;
    }

    public SubOrder4(Integer integer, int orderId, E e) {
        super(integer, orderId);
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
