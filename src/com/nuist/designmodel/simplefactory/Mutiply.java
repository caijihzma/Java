package com.nuist.designmodel.simplefactory;

/**
 * @author shkstart
 * @create 2023-05-17 22:45
 */
public class Mutiply extends Operator{
    @Override
    public double getResult() {
        double result = getNumberA() * getNumberB();
        return result;
    }
}
