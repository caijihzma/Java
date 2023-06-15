package com.nuist.javabase.generic.selfdefine;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-12 21:45
 * @description
 *      SubOrder3是泛型类
 */
public class SubOrder3<T> extends Order<T>{
    public void show(T t){
        System.out.println(t);
    }
}
