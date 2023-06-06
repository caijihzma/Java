package com.nuist.javabase.Collection.string;

import org.testng.annotations.Test;

/**
 * @author shkstart
 * @create 2023-05-13 22:38
 */
public class StringMethodTest1 {
    @Test
    public void test1(){
        String s1 =  "hello";
        String s2 = s1.replace('l','w');
        System.out.println(s1);
        System.out.println(s2);//hewwo

        String s3 = s1.replace("ll","wwww");
        System.out.println(s3);//hewwwwo

        //正则表达式：一个有规则要求的字符串--用户名大小写，邮箱
    }
}
