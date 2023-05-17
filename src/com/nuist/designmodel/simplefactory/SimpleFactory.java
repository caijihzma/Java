package com.nuist.designmodel.simplefactory;

/**
 * @author shkstart
 * @create 2023-05-17 22:41
 */
public class SimpleFactory {
    public static Operator createOperator(String operate){
        Operator oper = null;
        switch (operate){
            case"+":
                oper = new Add();
                break;
            case "-":
                oper = new Decline();
                break;
            case "*":
                oper = new Mutiply();
                break;
            case"/":
                oper = new Divide();
                break;
        }
        return oper;
    }
}
