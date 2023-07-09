package com.nuist.datastructure.linkedlist;

import java.util.Stack;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-07-03 23:03
 * @description
 */
//演示栈Stack的基本使用
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
//        入栈
        stack.add("jack");
        stack.add("Tom");
        stack.add("smith");
//        出栈
//        smith,tom,jack
        while (stack.size()>0){
            System.out.println(stack.pop());//pop就是将栈顶的数据取出
        }

    }
}
