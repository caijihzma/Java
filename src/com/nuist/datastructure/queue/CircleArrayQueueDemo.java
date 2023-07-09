package com.nuist.datastructure.queue;

import java.util.Scanner;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-28 21:54
 * @description
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
//        测试
        System.out.println("测试数组模拟环形队列的案例--");
//        创建一个队列
//        实际有效数据最多只有2个，因为我有一个空的空间，所以设置成4，有效数据是3
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;//为了循环
//        输出1个菜单
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    try {
                        System.out.println("输入一个数：");
                        int value = scanner.nextInt();
                        arrayQueue.addQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g'://取出数据，这边可能会有一个异常，因为你没有数据可取,可以使用java中的异常处理机制try-catch
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是：%d\n", res);
                    } catch (Exception e) {//try抛出异常就会被catch抓住
                        System.out.println(e.getMessage());//输出异常信息，就是我们写的异常信息
                    }
                    break;
                case 'h'://查看队列头的数据是什么，也有可能为空，也会有异常的抛出
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e'://退出
//                    退出程序之前，先关闭scanner
                    scanner.close();//如果不关闭会有一个异常
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出··");
    }
}

class CircleArrayQueue {
    private int maxSize;//表示数组的最大容量
    /**
     * 1、front变量的含义做一个调整：front就指向队列的第一个元素
     * 【原先的front的指向第一个元素的前一个位置】，也就是说arrQueue[front]
     * 就是队列的第一个元素。front的初始值=0。
     */
    private int front;//队列头
    /**
     * 2、rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，
     * 因为我希望空出一个空间作为一个约定。rear的初始值=0。有的算法不预留空间，
     * 为了方便理解，这里预留。
     */
    private int rear;//队列尾
    private int[] arr;//该数据用于存放数据，模拟队列

    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
//        front = 0;front和rear默认值就是0，可以不写
//        rear = 0;
    }

    //    判断队列是否满

    /**
     * 3、当队列满时，【以前的条件是rear = maxSize-1,没有考虑到复用】条件是
     * (rear + 1)%maxSize ==front就是满。
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //    判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //    添加数据到队列
    public void addQueue(int n) {
//        判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
        }
//       因为rear指向本身就指向了后一个元素，直接将数据加入就可以了
        arr[rear] = n;
//        将rear后移，这里必须考虑取模,防止越界
        rear = (rear + 1) % maxSize;
    }
    //    获取队列的数据，出队列

    /**
     * 其实是有问题的，当我们数据从头部取出来了，队列的头部上去了，下面空间虽然没有有效数据了，但是你也用不了
     * 因为我们目前这个队列不是环形队列，没有取模，所以说即使你把所有的数据取出来了，你再往里面添加也添加不进去
     * 因为你这个数组只用了一次
     *
     * @return
     */
    public int getQueue() {
//        判断队列是否空
        if (isEmpty()) {
//            通过抛出异常来处理
            throw new RuntimeException("队列空，不能取数据");
//            return;//这个return是没有必要再写了，因为throw本身也会马上终止
        }
//        这里需要分析出front是指向队列的第一个元素
//        1先把front对应的值先保存到一个临时变量，因为直接返回的话，front就没有往后移的机会了
//        2将front后移,考虑取模
//        3将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //    显示队列的所有数据
    public void showQueue() {
//        遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }
//        for (int i = 0; i < arr.length; i++) {有可能前面数据都被取了，这样打就没有意义了，因此思路要发生变化
//            System.out.printf("arr[%d]=%d\n",i,arr[i]);
//        }

//        思路：从front开始遍历，要遍历多少个元素
        for (int i = front; i < front + size(); i++) {
//            有可能前面数据都被取了，这样打就没有意义了，因此思路要发生变化
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);//i%maxSize因为有可能超过数组的大小
        }
    }

    //    求出当前队列有效数据的个数，否则你无法遍历
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //    显示队列的头数据，注意不是取出数据
    public int headQueue() {
//        判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front];//因为front本身就指向队列的第一个元素
    }
}
