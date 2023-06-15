package com.nuist.javabase.generic.selfdefine.home.exer1;

import java.util.Objects;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-15 22:52
 * @description
 *      定义一个 User 类：
 *      该类包含：private成员变量（int类型） id，age；（String 类型）name。
 */
public class User {
    private int id ;
    private int age;
    private String name;

    public User() {
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
//    除了TreeMap、TreeSet跟equals和hashMap是没关系的，但是其它的有关

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }
}
