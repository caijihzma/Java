package com.nuist.javabase.generic.home.exer1;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-10 20:24
 * <p>
 * 1. MyDate类包含：
 * private成员变量year，month，day；并为每一个属性定义getter、setter方法；
 */

//需求2的第二种写法：既然比较的是MyDate，那么就在这里实现
public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "年" + month + "月" + day + "日";
    }

//    需求2：按照生日从小到大排序
    @Override
    public int compareTo(MyDate o) {
        //                正确的写法：
        int yeardistance = this.getYear() - o.getYear();
        if (yeardistance != 0) {
            return yeardistance;
        }
        int monthdistance = this.getMonth() - o.getMonth();
        if (monthdistance != 0) {
            return monthdistance;
        }
        return this.getDay() - o.getDay();
    }
}
