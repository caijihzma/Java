package com.nuist.designmodel.simplefactory;

/**
 * @author shkstart
 * @create 2023-05-17 22:45
 */
public class Divide extends Operator{
    @Override
    public double getResult() throws Exception {
        double result = 0;
        if(getNumberB() == 0){
            throw new Exception("除数不能为0");
        }else{
            result = getNumberA() / getNumberB();
        }
        return result;
    }
}
