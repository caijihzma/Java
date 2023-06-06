package com.nuist.designpattern.simplefactory;

/**
 * @author shkstart
 * @create 2023-05-17 22:44
 */
public class Add extends Operator{
    @Override
    public double getResult() {
        double result = 0;
        result = getNumberA() + getNumberB();
        return result;
    }
}
