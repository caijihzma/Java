package com.nuist.javabase.generic.selfdefine.apply;

import java.util.List;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-13 23:45
 * @description
 *      DAO:data(base) access object[数据库访问对象，就是我们把操作数据库的相关的方法声明在DAO这个类当中
 *          内部封装了操作数据库相关表的增删改查操作]
 */
//查，对应到Java层面中的类型不一样了，如果你不用泛型的话，只能返回Object的类型
//    因为大家套路都一样，所以都写到一个类中
public class DAO<T> {
//    增
    public void insert(T bean){
//        通过相应的sql语句，将bean对象的属性值写入到数据表中。
    }
//    删
    public T deleteById(int id){
//        略
        return null;
    }
//    改
    public void update(int id ,T bean){
//        略
    }

//    查
//    查询1条记录
    public T queryForInstance(int id){
//        略
        return null;
    }
//    查询多条记录构成的集合
    public List<T> queryForList(int id){
        return null;
    }

//定义泛型方法
//   比如：查询表中的记录数。（E：Long类型）
//   比如：查询表中最大的生日。（E：Date类型）
    public<E> E getValue(String sql){
        return null;
    }

}
