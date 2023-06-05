package com.nuist.Collection.collections;

import org.testng.annotations.Test;
import org.w3c.dom.ls.LSInput;

import java.util.*;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-05 20:31
 */
public class CollectionsTest {
    /**
     * •reverse(List)：反转 List 中元素的顺序
     * •shuffle(List)：对 List 集合元素进行随机排序
     * •sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
     * •sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
     * •swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
     */
    @Test
    public void test1() {
        List list = Arrays.asList(32, 54, 32, 67, 87, 2, 14, 54, 43);//自动装箱
        System.out.println(list);//[32, 54, 32, 67, 87, 2, 14, 54, 43]

//        reverse(List)：反转 List 中元素的顺序
//        Collections.reverse(list);
//        System.out.println(list);//[43, 54, 14, 2, 87, 67, 32, 54, 32]

//        shuffle(List)：对 List 集合元素进行随机排序
//        Collections.shuffle(list);
//        System.out.println(list);//[32, 67, 54, 32, 87, 54, 2, 14, 43]

//        sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
//        Collections.sort(list);//既然排序就要元素类型相同
//        System.out.println(list);//[2, 14, 32, 32, 43, 54, 54, 67, 87]

//        sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    //方式1：
//                    return i1 - i2;//拆箱
                    //方式2：
                    return -(i1.intValue() - i2.intValue());//降序
                }
                throw new RuntimeException("类型不匹配");
            }
        });
        System.out.println(list);//[87, 67, 54, 54, 43, 32, 32, 14, 2]
    }


    /**
     * 查找
     * •Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
     * •Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
     * •Object min(Collection)：根据元素的自然顺序，返回给定集合中的最小元素
     * •Object min(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最小元素
     * •int binarySearch(List list,T key)在List集合中查找某个元素的下标，但是List的元素必须是T或T的子类对象，而且必须是可比较大小的，即支持自然排序的。而且集合也事先必须是有序的，否则结果不确定。
     * •int binarySearch(List list,T key,Comparator c)在List集合中查找某个元素的下标，但是List的元素必须是T或T的子类对象，而且集合也事先必须是按照c比较器规则进行排序过的，否则结果不确定。
     * •int frequency(Collection c，Object o)：返回指定集合中指定元素的出现次数
     */
    @Test
    public void test2() {
        List list = Arrays.asList(32, 54, 32, 67, 87, 2, 14, 54, 43);//自动装箱
        System.out.println(list);

//        Comparable max = Collections.max(list);
//        System.out.println(max);//87

        Object max1 = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    //方式1：
//                    return i1 - i2;//拆箱
                    //方式2：
                    return -(i1.intValue() - i2.intValue());//降序
                }
                throw new RuntimeException("类型不匹配");
            }
        });
//        System.out.println(max1);//2,认为按照降序排列后，最右边的数据是最大的

        int count = Collections.frequency(list, 32);
        System.out.println("32出现了：" + count + "次");//2
    }


    /**
     * 复制、替换
     * •void copy(List dest,List src)：将src中的内容复制到dest中
     * •boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
     * •提供了多个unmodifiableXxx()方法，该方法返回指定 Xxx的不可修改的视图。
     */
    @Test
    public void test3(){
        List src = Arrays.asList(32, 54, 32, 67, 87, 2, 14, 54, 43);//自动装箱
//        List dest = new ArrayList(20);//是容量为20，实际存储的个数还是0，错
//        List dest = new ArrayList();

        //正确的
        List dest = Arrays.asList(new Object[src.size()]);//很巧妙的写法
        System.out.println(dest.size());//0  size是说里面有几个元素，不是说初始化容量10

//        void copy(List dest,List src);//将src中的内容复制到dest中
        Collections.copy(dest, src);
        System.out.println(dest);

    }
    @Test
    public void test4(){
//      提供了多个unmodifiableXxx()方法，该方法返回指定 Xxx的不可修改的视图。

    }
}
