package com.nuist.javabase.generic.selfdefine.apply;

import java.sql.Date;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-13 23:51
 * @description
 *      ORM思想（Object relational mapping）
 *      数据库中的一个表与Java中的一个类对应
 *      表中的一条记录与Java类中的一个对象对应
 *      表中的一个字段（或列）与Java类的一个属性（或字段）对应
 *
 */
public class Customer {
    int id;
    String name;
    String email;
    Date birth;
}
