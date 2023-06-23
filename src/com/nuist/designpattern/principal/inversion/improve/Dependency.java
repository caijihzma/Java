package com.nuist.designpattern.principal.inversion.improve;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-22 16:52
 * @description
 */
public class Dependency {
    public static void main(String[] args) {

    }
}

//方式1：通过接口传递实现依赖
//开关的接口
interface IOpenAndClose {
    public void open(ITV tv);//抽象方法，接收接口
}

interface ITV {//ITV接口

    public void play();
}

//实现接口
class OpenAndClose implements IOpenAndClose {

    @Override
    public void open(ITV tv) {//体现接口传递：ITV
        tv.play();
    }
}

//方式2：通过构造器依赖传递
interface IOpenAndClose2 {
    public void open();//抽象方法
}

interface ITV2 {
    //    ITV接口
    public void play();
}

class OpenAndClose2 implements IOpenAndClose2 {
    public ITV2 tv;//成员，怎么把tv接口传进去的呢
    public OpenAndClose2(ITV2 tv) {//通过构造器（传入一个实现的ITV2接口的对象）
        this.tv = tv;//体现接口传递
    }

    @Override
    public void open() {
        this.tv.play();
    }
}

//方式3：通过setter方法传递
interface IOpenAndClose3{
    public void open();//抽象方法
    public void setTv(ITV3 tv);
}

interface ITV3{
    public void play();
}
class OpenAndClose3 implements IOpenAndClose3{
    private ITV3 tv;//成员

    public void setTv(ITV3 tv){//通过set的方式将把实现ITV接口的对象实例传递给了OpenAndClose3的成员
        this.tv = tv;
    }

    @Override
    public void open() {
        this.tv.play();
    }
}
