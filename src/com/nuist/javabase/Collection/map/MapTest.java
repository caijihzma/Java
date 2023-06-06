package com.nuist.javabase.Collection.map;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-04 10:25
 */
public class MapTest {
    @Test
    public void test1() {
        Map map = new HashMap();
        map.put(null, null);
        System.out.println(map);
    }

    @Test
    public void test2() {
        Map map = new Hashtable();
        map.put(null, 123);
        System.out.println(map);
    }

    @Test
    public void test3() {
        LinkedHashMap map = new LinkedHashMap();
        map.put("Tom", 23);
        map.put(34, "AA");
        map.put("CC", new Date());

        System.out.println(map);
    }

    /**
     * 测试Map中的实现类
     */
    @Test
    public void test4() {
        HashMap map = new HashMap();
        //put(Object key,Object value)
        map.put("AA", 56);
        map.put(67, "Tom");
        map.put("BB", 78);
        map.put(new Person(1001, "Jerry"), 56);

        System.out.println(map);
        System.out.println(map.size());

        System.out.println("________________________________");
        //        Object remove(Object key)
        Object value = map.remove("AA");
        System.out.println(value);
        System.out.println(map);

        System.out.println("________________________________");
        //修改
        Object oldValue = map.put("BB", 99);
        System.out.println(oldValue);
        System.out.println(map);

        System.out.println("________________________________");
        //查询
        Object value1 = map.get(67);
        System.out.println(value1);
    }

    /**
     * Map的遍历操作
     */
    @Test
    public void test5(){
//        遍历key集：Set keySet()
        HashMap map = new HashMap();
        //put(Object key,Object value)
        map.put("AA", 56);
        map.put(67, "Tom");
        map.put("BB", 78);
        map.put(new Person(1001, "Jerry"), 56);

//        Set keySet = map.keySet();//就两种遍历方式，因为set没有索引
//        //使用迭代器
//        Iterator iterator = keySet.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

//        遍历value集：Collection values()
//        方式1：推荐
        Collection values = map.values();
//      使用增强for
        for(Object obj : values){
            System.out.println(obj);
        }

//       方式2：
        Set keySet1 = map.keySet();
        for (Object key : keySet1) {
            map.get(key);
            System.out.println(values);
        }

    }
    @Test
    public void test6(){
        //        遍历entry集：Set entrySet()
        HashMap map = new HashMap();
        //put(Object key,Object value)
        map.put("AA", 56);
        map.put(67, "Tom");
        map.put("BB", 78);
        map.put(new Person(1001, "Jerry"), 56);

        //方式1：遍历entry集：Set entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            //方式1：
//            System.out.println(iterator.next());;
            //方式2：
            Map.Entry entry = (Map.Entry) iterator.next();//强转
            //为什么强转，我为我想调用getKey和getValue
            String s = entry.getKey() + "--->" + entry.getValue();
            System.out.println(s);
        }

        //方式2：遍历entry集：keySet()配合上get(key)
        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(key + "---->" + map.get(key));
        }
    }
}
