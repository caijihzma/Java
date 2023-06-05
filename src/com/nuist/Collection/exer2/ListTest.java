package com.nuist.Collection.exer2;

import org.omg.PortableInterceptor.ObjectReferenceFactory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-02 17:53
 */
public class ListTest {
    public static void main(String[] args) {
        //需求1：随机生成30个字符，存放在ArrayList中
        ArrayList list = new ArrayList();
        for(int i = 0;i < 30;i++){
            //'a'-'z' [97,122]
            list.add((char)(Math.random() * (122 - 97 + 1) + 97) + "");//建议这么做，将它变成一个字符串，防止当数去算
        }
        System.out.println(list);

        int aCount = listTest(list,"a");
        int bCount = listTest(list,"b");
        int cCount = listTest(list,"c");
        int xCount = listTest(list,"x");
        System.out.println("a:"+aCount);
        System.out.println("b:"+bCount);
        System.out.println("c:"+cCount);
        System.out.println("x:"+xCount);
    }

    //需求2：遍历ArrayList，查找指定的元素出现的次数
    public static  int listTest(Collection list,String s){
        int count = 0;
        for(Object obj : list){
            if(s.equals(obj)){
                count++;
            }
        }
        return count;
    }

}
