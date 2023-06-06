package com.nuist.designpattern.principal.singleresponsibility;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-06 21:31
 */
public class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.run("汽车");
        vehicle2.runWater("轮船");
        vehicle2.runAir("飞机");
    }
}
//方式3分析
//1、这种修改方法，没有对原来的类做大的修改，只是增加了方法
//2、这里虽然没有在类这个级别上遵守单一职责原则，但是在方法级别上，遵守了单一职责原则
class Vehicle2{
    public void run(String vehicle){
        System.out.println(vehicle + "在公路上运行。。。");
    }
    public void runAir(String vehicle){
        System.out.println(vehicle + "在天空上运行。。。");
    }
    public void runWater(String vehicle){
        System.out.println(vehicle + "在水中运行。。。");
    }
}
