package com.nuist.designpattern.simplefactory;

/**
 * @author shkstart
 * @create 2023-05-17 22:45
 */
public class Decline extends Operator{
    @Override
    public double getResult() {
        double result = 0;
        result = getNumberA() - getNumberB();
        return result;
    }
}
