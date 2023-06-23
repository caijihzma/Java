package com.nuist.designpattern.principal.liskov.improve;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-23 21:41
 * @description
 */
public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11 - 3 = " + a.func1(11, 3));
        System.out.println("1 -8 = " + a.func1(1, 8));
        System.out.println("-------------------------------");

        B b = new B();
//        通过b去调用func1还用的是我们父类的func1方法,但是b这个实例重写了这个方法
//        因为B类不再继承A类，因此调用者，不会再认为func1是求减法了。
//        调用完成的功能就会很明确，就不是11-3，而是11+3
        System.out.println("11+3 = " + b.func1(11, 3));//11 + 3
        System.out.println("1 + 8 = " + b.func1(1, 8));//1 + 8
        System.out.println("11+3+9 = " + b.func2(11, 3));

//        使用组合仍然可以使用到A类的相关方法
        System.out.println("11 - 3 = "+ b.func3(11, 3));//这里本意是求出11 - 3
    }
}

//改进：创建一个更加基础的基类
class Base {
//    把更加基础的方法和成员写到Base类
}

//A类
class A extends Base {
    //    返回2个数的差
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

//B类继承了A
//增加了一个新的功能：完成2个数相加，然后和9求和。
class B extends Base {
//    如果B需要使用A类的方法，使用组合关系
    private A a = new A();//
//    写代码的时候，无意间将func1重写了
    public int func1(int a, int b) {
        return a + b;
    }
    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

//    我们仍然想使用A的方法
    public int func3(int a,int b){
        return this.a.func1(a, b);//用this是因为参数也是a
    }
}
