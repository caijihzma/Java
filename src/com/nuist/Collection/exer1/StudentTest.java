package com.nuist.Collection.exer1;

import com.nuist.Collection.set.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-05-31 21:50
 */
public class StudentTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List list = new ArrayList();//为什么前面习惯上写List（多态），没有为什么写成ArrayList也可以
        System.out.println("请录入学生信息");
        //通过循环的方式，添加多个学生的信息
        while(true){
            System.out.println("1：继续录入，0:结束录入");
            int selection = scan.nextInt();
            if(selection == 0){
                break;
            }
            System.out.println("请输入学生的姓名：");
            String name = scan.next();
            System.out.println("请输入学生的年龄：");
            int age = scan.nextInt();

            Student s = new Student(name,age);
            list.add(s);
        }

        //遍历集合当中的学生信息
        System.out.println("遍历学生信息");
        for(Object s : list){//添加进来的确实都是Student，但是方法在调用的时候它认为我们添加的实际上是Object
            //看着有点变扭，你做一个强转也可以
            System.out.println(s.toString());
        }
        scan.close();
    }
}
