package com.nuist.designpattern.principal.segreation.improve;

import java.util.ArrayDeque;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-07 0:00
 */
public class Segreation1 {
    public static void main(String[] args) {
//        使用一把
        A a = new A();
        a.depend1(new B());//A类通过接口去依赖B类
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());//C类通过接口去依赖（使用）D类
        c.depend4(new D());
        c.depend5(new D());
    }
}

//接口1
interface Interface1 {
    void operation1();
}

//接口2
interface Interface2 {
    void operation2();

    void operation3();
}

//接口3
interface Interface3 {
    void operation4();

    void operation5();
}

//B实现了这个接口
class B implements Interface1, Interface2 {

    @Override
    public void operation1() {
        System.out.println("B中实现了operator1");
    }

    @Override
    public void operation2() {
        System.out.println("B中实现了operator2");
    }

    @Override
    public void operation3() {
        System.out.println("B中实现了operator3");
    }
}

//D实现了这个接口
class D implements Interface1, Interface3 {

    @Override
    public void operation1() {
        System.out.println("D中实现了operator1");
    }

    @Override
    public void operation4() {
        System.out.println("D中实现了operator4");
    }

    @Override
    public void operation5() {
        System.out.println("D中实现了operator5");
    }
}

class A {//A类通过接口Interface1依赖（使用）B类，但是只会用到1,2,3方法

    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend2(Interface2 i) {
        i.operation2();
    }

    public void depend3(Interface2 i) {
        i.operation3();
    }
}

class C {//A类通过接口Interface1依赖（使用）D类，但是只会用到1,4,5方法

    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend4(Interface3 i) {
        i.operation4();
    }

    public void depend5(Interface3 i) {
        i.operation5();
    }
}