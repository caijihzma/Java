package com.nuist.javabase.Collection.set;

import java.util.Objects;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-05-31 21:17
 */
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    //List也是Collection，只要往Collection中存放数据，后期可能调remove，contains都会用到元素所属类的equals方法
    //推荐重写equals方法


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {//set中会专门讲
        return Objects.hash(name, age);
    }
}
