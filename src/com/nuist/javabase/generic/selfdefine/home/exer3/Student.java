package com.nuist.javabase.generic.selfdefine.home.exer3;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-15 23:41
 * @description
 */
public class Student<T> {
    private String name;
    private T score;//成绩

    public Student() {
    }

    public Student(String name, T score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

}
