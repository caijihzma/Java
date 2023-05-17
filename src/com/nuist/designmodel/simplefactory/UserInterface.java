package com.nuist.designmodel.simplefactory;

import org.testng.annotations.Test;

import java.io.Reader;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2023-05-17 22:27
 */
public class UserInterface {
    public static void main(String[] args) throws Exception {
        double numberA = 0;
        double numberB = 0;
        System.out.println("请输入第一个数：");
        Scanner scanner = new Scanner(System.in);
        numberA = scanner.nextDouble();
        System.out.println("请输入运算符：");
        String str = scanner.next();
        System.out.println("请输入第三个数：");
        numberB = scanner.nextDouble();

        Operator oper = SimpleFactory.createOperator(str);
        oper.setNumberA(numberA);
        oper.setNumberB(numberB);
        double result = oper.getResult();
        System.out.println(result);
    }
}
