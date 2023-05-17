package com.nuist.designmodel.simplefactory;

/**
 * @author shkstart
 * @create 2023-05-17 22:28
 */
public abstract  class Operator {
    private double numberA;
    private double numberB;


    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public abstract double getResult() throws Exception;
}
