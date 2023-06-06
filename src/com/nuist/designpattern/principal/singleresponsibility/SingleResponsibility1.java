package com.nuist.designpattern.principal.singleresponsibility;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-06 21:05
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}

//交通工具类
//方式1：
//1.在方式1的run方法中，违反了单一职责原则
//2.解决方案非常的简单，根据交通工具运行的不同，分解成不同的类即可
class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在公路上运行....");
    }
}
