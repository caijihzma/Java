package com.nuist.javabase.generic.selfdefine.home.exer1;

import java.util.*;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-14 23:17
 * @description
 */
public class DAO<T> {
//    这里不能为空
//    Map<String,T> map = new HashMap<>();//显示赋值

    //    或者代码块中写，由于是非静态的，所以就写一个非静态的代码块
    Map<String, T> map;

    {
        map = new HashMap<>();
    }

    public void save(String id, T entity) {// 保存 T 类型的对象到 Map 成员变量中
//        所以需要判断一下
        if (!map.containsKey(id)) {
            map.put(id, entity);//id没有进行添加，id要是有的话就成了替换了
        }
    }

    public T get(String id) {//从 map 中获取 id 对应的对象
        return map.get(id);
    }

    public void update(String id, T entity) {//替换 map 中key为id的内容,改为 entity 对象
//        修改在map里面也是put
        if (map.containsKey(id)) {
            map.put(id, entity);//若map中没有这个id，就变成添加了，与这个方法不太相符，所以应该是没改成，而不是添加进去
        }
    }

    public List<T> list() {//返回 map 中存放的所有 T 对象
//        实际情况是不能这么写的，这又回到咱们讲的多态了
        /**
         * 比如现在我们有一个Person和Student类，Student继承Person
         * 如果我们new了一个Student把它赋值给Person了这就是多态，
         * 将Person强转成Student这叫向下转型，而且没报错，而你现在new的就是Person，
         * 你向下转型成Student，这就错了，就是这里出现的问题
         */
//        错误的
//        Collection<T> values = map.values();
//        System.out.println(values.getClass());
//        return (List<T>) values;//values instanceOf List<T>报ClassCastException异常,咱们讲map强调过这件事，要是List早写成List了

//        正确的方式1：那你就造一个List
//        Collection<T> values = map.values();
//        ArrayList<T> list = new ArrayList<>();
//        list.addAll(values);//会自动遍历将元素添加进去，跟我们自己遍历的性能是一样的，只不过写的时候省点事
//        return list;
//        正确的方式2：
        Collection<T> values = map.values();
        //在造ArrayList的过程当中，就把values里面的内容取出来，添加进来了类似于上面的操作
        ArrayList<T> list = new ArrayList<>(values);//ArrayList有一个构造器
        list.addAll(values);
        return list;
    }

    public void delete(String id) {//删除指定 id 对象
        map.remove(id);
    }
}
