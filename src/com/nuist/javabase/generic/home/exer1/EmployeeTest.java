package com.nuist.javabase.generic.home.exer1;

import org.testng.annotations.Test;
import org.testng.reporters.IBuffer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-10 22:10
 */
public class EmployeeTest {
    //    需求1：使用Employee实现Comparable接口，并按name排序；
    @Test
    public void test1() {
        TreeSet<Employee> set = new TreeSet<>();
        Employee e1 = new Employee("HanMeimei", 17, new MyDate(1998, 12, 11));
        Employee e2 = new Employee("LiLei", 20, new MyDate(1996, 11, 21));
        Employee e3 = new Employee("LiHua", 21, new MyDate(2000, 9, 12));
        Employee e4 = new Employee("ZhangLei", 19, new MyDate(1997, 5, 31));
        Employee e5 = new Employee("ZhangYi", 23, new MyDate(2001, 12, 21));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

//        遍历
        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee);
        }
    }

    //    需求2：创建TreeSet时传入Comparator对象，按生日日期的先后排序；
    @Test
    public void test2() {
//        咱们比较的是Employee，就传入Employee，生日只不过是其中的一个属性
        Comparator<Employee> comparator = new Comparator<>() {
            @Override
            public int compare(Employee o1, Employee o2) {

//                错误的写法：
//                比的时候也是一个一个字符进行比较，如1999年12月5日，2000年2月20日，这里比较讨巧，1确实比2小，所以2000大
//                但是这样就会有一个小问题年还好，比月的时候12月和2月，这里是拿着2和1去比的，会有问题，除非你写成05，但是
//                写成05就是8进制，因为8进制以0开头。所以这里不要拿字符串去比。
//                所以你老老实实的先比年再比月再比日
//                return o1.getBirthday().toString()|.compareTo(o2.getBirthday().toString());

//                正确的写法1：
//                int yeardistance = o1.getBirthday().getYear() - o2.getBirthday().getYear();
//                if (yeardistance != 0) {
//                    return yeardistance;
//                }
//                int monthdistance = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
//                if (monthdistance != 0) {
//                    return monthdistance;
//                }
//                return o1.getBirthday().getDay() - o2.getBirthday().getDay();

//                正确的写法2：
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        };
        TreeSet<Employee> set = new TreeSet<>(comparator);
        Employee e1 = new Employee("HanMeimei", 17, new MyDate(1998, 12, 11));
        Employee e2 = new Employee("LiLei", 20, new MyDate(1996, 11, 21));
        Employee e3 = new Employee("LiHua", 21, new MyDate(2000, 9, 12));
        Employee e4 = new Employee("ZhangLei", 19, new MyDate(1997, 5, 31));
        Employee e5 = new Employee("ZhangYi", 23, new MyDate(2001, 12, 21));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

//        遍历
        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee);
        }
    }
}
