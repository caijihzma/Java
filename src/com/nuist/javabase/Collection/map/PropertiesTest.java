package com.nuist.javabase.Collection.map;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-04 16:32
 */
public class PropertiesTest {
    @Test
    public void test1() throws IOException {//注意：因为涉及到流的操作，为了确保流能关闭，建议使用try-catch-finally
        //方式1：数据和代码耦合度高；如果修改的话，需要重写编译代码、打包发布、繁琐
//         String name = "陈志远";

         //方式2：将数据封装到具体的配置文件中，在程序中读取配置文件中的信息，实现了数据和代码的解耦;
         //由于我们没有修改代码，就省去了重新编译和打包的过程。
        File file = new File("info.properties");//注意：要提前创建好
//        System.out.println(file.getAbsolutePath());//单元测试和main方法得到的路径可能不一样
        FileInputStream fis = new FileInputStream(file);
        Properties pros = new Properties();
        pros.load(fis);//加载流中的文件中的数据

        //读取数据
        String name = pros.getProperty("name");
        String pwd = pros.getProperty("password");

        System.out.println(name + ":" + pwd);
        fis.close();
    }
}
