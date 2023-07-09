package com.nuist.datastructure.queue;

import java.time.temporal.ValueRange;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-27 21:07
 * @description
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
//        测试一把
//        创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;//为了循环
//        输出1个菜单
        while (loop){
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
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
                        System.out.printf("取出的数据是：%d\n",res);
                    }catch (Exception e){//try抛出异常就会被catch抓住
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
//使用数组模拟队列--编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数据用于存放数据，模拟队列

//    创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
//        初始化工作
        front = -1;//指向队列的头部,分析出front是指向队列头的前一个位置。
        rear = -1;//指向队列尾，指向队列尾的数据，即就是队列最后一个数据。
    }

//    判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }
//    判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

//    添加数据到队列
    public void addQueue(int n){
//        判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据");
        }
        rear++;//让rear后移
        arr[rear] = n;
    }
//    获取队列的数据，出队列

    /**
     * 其实是有问题的，当我们数据从头部取出来了，队列的头部上去了，下面空间虽然没有有效数据了，但是你也用不了
     * 因为我们目前这个队列不是环形队列，没有取模，所以说即使你把所有的数据取出来了，你再往里面添加也添加不进去
     * 因为你这个数组只用了一次
     * @return
     */
    public int getQueue(){
//        判断队列是否空
        if (isEmpty()){
//            通过抛出异常来处理
            throw new RuntimeException("队列空，不能取数据");
//            return;//这个return是没有必要再写了，因为throw本身也会马上终止
        }
        front++;//front后移，因为front本身是指向队列的前一个位置
        return arr[front];
    }
//    显示队列的所有数据
    public void showQueue(){
//        遍历
        if (isEmpty()){
            System.out.println("队列空的，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
//    显示队列的头数据，注意不是取出数据
    public int headQueue(){
//        判断
        if (isEmpty()){
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front+1];
    }
}
