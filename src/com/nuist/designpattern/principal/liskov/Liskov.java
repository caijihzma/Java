package com.nuist.designpattern.principal.liskov;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-23 21:41
 * @description
 */
public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11 - 3 = "+a.func1(11,3));
        System.out.println("1 -8 = "+a.func1(1,8));
        System.out.println("-------------------------------");

        B b = new B();
//        通过b去调用func1还用的是我们父类的func1方法,但是b这个实例重写了这个方法
        System.out.println("11-3 = "+b.func1(11, 3));
        System.out.println("1-8 = "+b.func1(1,  8));
        System.out.println("11+3+9 = "+b.func2(11,  3));
    }
}

//A类
class A {
    //    返回2个数的差
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

//B类继承了A
//增加了一个新的功能：完成2个数相加，然后和9求和。
class B extends A {
    /**
     * 写代码的时候，无意间将func1重写了
     * @param a
     * @param b
     * @return
     */
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }
}
