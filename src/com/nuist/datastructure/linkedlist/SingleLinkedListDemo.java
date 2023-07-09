package com.nuist.datastructure.linkedlist;

import java.security.Signature;
import java.sql.SQLOutput;
import java.util.Stack;
import java.util.zip.DeflaterInputStream;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-28 23:42
 * @description
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
//        进行测试
//        先创建结点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

//        创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        加入
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

//        //按照编号的顺序加入
//        singleLinkedList.addByOrder(heroNode1);
//        singleLinkedList.addByOrder(heroNode4);
//        singleLinkedList.addByOrder(heroNode2);
//        singleLinkedList.addByOrder(heroNode3);

        //按照编号的顺序加入
//        singleLinkedList.addByOrder(heroNode1);
//        singleLinkedList.addByOrder(heroNode4);
//        singleLinkedList.addByOrder(heroNode2);
//        singleLinkedList.addByOrder(heroNode3);
//        singleLinkedList.addByOrder(heroNode3);
/*
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);
//      修改前显示一下
        singleLinkedList.list();
//        测试修改结点的代码
        System.out.println("修改后的链表情况~~");
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);
//        显示一把
        singleLinkedList.list();
//        删除一个结点
        singleLinkedList.delete(1);
        System.out.println("删除后链表的情况....");
        singleLinkedList.list();

//        测试一下求单链表中有效节点的个数
        System.out.println("有效结点的个数="+getLength(singleLinkedList.getHead()));
        //测试一下看看是否得到了倒数第k个结点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),1);
        System.out.println("res="+res);
*/
//        测试一下单链表的反转功能
        System.out.println("原来链表的情况~~");
        singleLinkedList.list();

//        System.out.println("反转单链表~~");
//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();

        System.out.println("测试逆序打印单链表,没有改变链表的结构~~");
        reversePrint(singleLinkedList.getHead());

    }

    //    方式2：可以利用栈这个数据结构，将各个结点压入栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果。
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;//空链表，不能打印
        }
//        创建一个栈，将各个结点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;//将当前结点保存起来，方便后面遍历
//        将链表的所有结点压入栈中
        while (cur != null) {
            stack.push(cur);//与add方法相同
            cur = cur.next;//后移，这样就可以压入下一个结点
        }
//        将栈中的结点进行打印，pop出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());//stack的特点是先进后出
        }
    }

    //    将单链表反转
    public static void reverseList(HeroNode head) {
//        若果当前链表为空，或者只有一个结点，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
//        定义一个辅助的指针（变量），帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//定义指向当前结点的【cur】下一个结点，因为cur指向除头结点的之外的第一个结点，cur要往后面挪，挪之前要用
//        它一下，如果我挪开了，又没有记录下一个结点，整个链表就断掉了。
        HeroNode reverseHead = new HeroNode(0, "", "");
//        遍历原来的链表，并从头到尾遍历原来的链表，每遍历一个结点，就将其取出，并放在链表的最前端
        while (cur != null) {
            next = cur.next;//先暂时保留当前结点的下一个结点，因为后面需要使用
            cur.next = reverseHead.next;//将cur下一个结点指向新的链表的最前端
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;//让cur后移
        }
//        将head.next指向reverseHead.next,实现单链表的反转
        head.next = reverseHead.next;
    }
//    查找单链表中的倒数第k个结点【新浪面试题】

    /**
     * - 思路：
     * - 1编写一个方法，接收head结点，同时接受一个index
     * - 2index表示的是倒数第index个结点
     * - 3先把链表从头到尾遍历，得到链表的总的长度getLength
     * - 4得到size后，我们从链表的第一个开始遍历（size-index）个，就可以得到
     * - 5如果找到了，则返回该结点，否则返回null
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
//        判断如果链表为空，返回null
        if (head.next == null) {
            return null;//没有找到
        }
//        第一次遍历得到链表的长度（结点个数）
        int size = getLength(head);
//      第二次遍历size-index个位置，就是我们倒数的第k个结点
//      先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
//      定义一个辅助变量,for循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {//3//3-1=2
            cur = cur.next;
        }
        return cur;
    }

//    方法：获取到单链表的结点个数（如果是带头结点的链表，需要不统计头结点）

    /**
     * @param head 链表的头结点
     * @return返回的就是有效结点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {//空链表
            return 0;
        }
        int length = 0;
//        定义一个辅助变量
        HeroNode cur = head.next;//体现出我没有统计头结点
        while (cur != null) {
            length++;
            cur = cur.next;//遍历
        }
        return length;
    }
}

//定义SingleLinkedList管理我们的英雄
class SingleLinkedList {
    //    先初始化一个头结点，头结点不要动，不存放具体的数据，因为你将来进行遍历的时候，
//    是在最前面的，如果这个结点变化了，将来就找不到了
    private HeroNode head = new HeroNode(0, "", "");
//    添加结点到单向链表

    //    返回头结点
    public HeroNode getHead() {
        return head;
    }

    /**
     * 思路：当不考虑编号的顺序时
     * 1、找到当前链表的最后结点
     * 2、将最后这个结点的next指向新的结点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
//        因为head结点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
//        遍历链表，找到最后
        while (true) {
//        找到链表的最后
            if (temp.next == null) {
                break;
            }
//            如果没有找到最后，将temp后移
            temp = temp.next;
        }
//        当退出while循环时，temp就指向了链表的最后
//        将最后这个结点的next指向新的结点
        temp.next = heroNode;
    }

    /**
     * 第二种方式在添加英雄时，根据排名将英雄插入到指定的位置【如果有这个排名，则添加失败，并给出提示】
     */
    public void addByOrder(HeroNode heroNode) {
//        因为头结点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
//        因为是单链表，因此找到的temp是位于添加位置的前一个结点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//flag标识添加的编号是否存在，默认false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {//位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;//后移，遍历当前的链表
        }
//        判断flag的值
        if (flag) {//不能添加，说明编号存在
//            printf可以格式化
            System.out.printf("准备插入的英雄的编号%d已经存在了，不能加入\n", heroNode.no);
        } else {
//            加入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 修改结点的信息，根据no编号来修改，即no编号不能改
     * 说明
     * 1、根据newHeroNode的no来修改即可
     */
    public void update(HeroNode newHeroNode) {
//      判断是否为空
        if (head.next == null) {
            System.out.println("链表为空...");
            return;
        }
//        找到需要修改的结点，根据no编号
//        定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该结点
        while (true) {
            if (temp == null) {
                break;//已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
//                找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
//        根据flag判断是否找到需要修改的结点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {//没有找到
            System.out.printf("没有找到编号%d的结点,不能修改\n", newHeroNode.no);
        }
    }

    //    删除结点
//    思路
//    1、head不能动，因此我们需要一个temp辅助结点找到待删除节点的前一个结点
//    2、说明我们在比较时，是temp.next.no和需要删除的结点no进行比较
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;//标志是否找到待删除的结点
        while (true) {
            if (temp.next == null) {//已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
//                找到待删除结点的前一个结点temp
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，进行遍历
        }
//        判断flag
        if (flag) {//找到
//        可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d结点不存在\n", no);
        }
    }

    //    显示链表【遍历】
    public void list() {
//        判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
//        因为头结点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
//            判断是否到链表最后
            if (temp == null) {
                break;
            }
//            输出结点的信息
            System.out.println(temp);
//            将next后移，一定小心
            temp = temp.next;
        }
    }
}

//定义一个HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //    构造器
    public HeroNode(int hNo, String hName, String hNickname) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }

    //    为了显示方便，我们重写一下toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
