package com.nuist.javabase.generic.selfdefine.home.exer1;

import java.util.List;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-15 22:56
 * @description 定义一个测试类：
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001", new User(1, 33, "周杰伦"));
        dao.save("1002", new User(2, 23, "陈志远"));

        dao.update("1002", new User(3,32,"蔡依林"));
        dao.delete("1002");

        List<User> list = dao.list();
//        遍历
        for (User u : list) {
            System.out.println(u);
        }
    }
}
