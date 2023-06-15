package com.nuist.javabase.generic.selfdefine.apply;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-14 22:00
 * @description
 */
public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();
        dao1.insert(new Customer());
        Customer customer = dao1.queryForInstance(1);
    }

    @Test
    public void test2(){
        OrderDAO dao1 = new OrderDAO();
        dao1.insert(new Order());
        List<Order> list = dao1.queryForList(1);
    }
}
