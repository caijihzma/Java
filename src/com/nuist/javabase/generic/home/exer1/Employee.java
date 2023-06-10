package com.nuist.javabase.generic.home.exer1;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-10 20:07
 * 1. 定义一个Employee类
 *     该类包含：private成员变量name，age，birthday，其中birthday是MyDate类对象；
 *     并为每一个属性定义getter、setter方法；
 *     并重写toString方法输出name，age，birthday
 */
public class Employee implements Comparable<Employee> {
    private  String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=[" + birthday +
                "]}";
    }

//    按照name由低到高排序
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);//this表示的是当前对象，由低到高排序
    }
}
