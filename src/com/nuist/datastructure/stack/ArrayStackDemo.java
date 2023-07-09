package com.nuist.datastructure.stack;

import java.sql.Statement;
import java.util.Scanner;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-07-09 21:38
 * @description
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
//        测试一下ArrayStack是否正确
//        先创建一个ArrayStack对象-->表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：表示添加数据到栈（入栈）");
            System.out.println("pop：表示从栈取出数据（出栈）");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出...");
    }
}

//定义一个ArrayStack表示栈
class ArrayStack {
    private int maxSize;//表示栈的大小
    private int[] stack;//数组，数组模拟栈，数据就放在该数组
    private int top = -1;//top表示栈顶，初始化为-1

//    构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
//    栈满
    public boolean isFull(){
        return top == maxSize-1;
    }
//    栈空
    public boolean isEmpty(){
        return top == -1;
    }
//    入栈push
    public void push(int value){
//        先判断栈是否满
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
//    出栈pop,将栈顶的数据返回
    public int pop(){//因为这个方法是有返回值int，所以可以抛出异常
        if (isEmpty()){
//            抛出异常处理,运行异常，因为运行异常可以直接抛出，你不捕获也没关系，捕获也能捕获到
            throw new RuntimeException("栈空，没有数据");//因为抛出异常本身就代表终止了，不需要return了
        }
        int value = stack[top];
        top--;
        return value;
    }
//    显示栈的情况【遍历栈】，遍历时，需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
