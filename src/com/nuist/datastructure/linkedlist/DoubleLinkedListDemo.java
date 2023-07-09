package com.nuist.datastructure.linkedlist;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-07-04 21:18
 * @description
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
//        测试
        System.out.println("双向链表的测试");
        //        先创建结点
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");
//      创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.list();

//        修改
        HeroNode2 newHeroNode = new HeroNode2(4, "陈志远", "傻逼");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表的额情况");
        doubleLinkedList.list();
//        删除
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表的情况");
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    //    先初始化一个头结点，头结点不要动，不存放具体的数据，因为你将来进行遍历的时候，
//    是在最前面的，如果这个结点变化了，将来就找不到了
    private HeroNode2 head = new HeroNode2(0, "", "");

    //    返回头结点
    public HeroNode2 getHead() {
        return head;
    }

    //    遍历双向链表的方法
    public void list() {
//        判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
//        因为头结点不能动，因此需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
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

    //    添加一个结点到双向链表
    public void add(HeroNode2 heroNode) {
//        因为head结点不能动，因此我们需要一个辅助变量temp
        HeroNode2 temp = head;
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
//        形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //    修改一个结点的内容，可以看到双向链表的结点内容修改和单向链表一样
    //    只是结点类型改成HeroNode2
    public void update(HeroNode2 newHeroNode) {
//      判断是否为空
        if (head.next == null) {
            System.out.println("链表为空...");
            return;
        }
//        找到需要修改的结点，根据no编号
//        定义一个辅助变量
        HeroNode2 temp = head.next;
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

    //    从双向链表中删除一个结点
//    说明：
//    1 对于双向链表，我们可以直接找到要删除的这个结点
//    2 找到之后，自我删除即可
    public void delete(int no) {
//        判断当前链表是否为空
        if (head.next == null) {//空链表
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;//是一个辅助变量（指针）,原先是等于head，因为原来我希望找的是待删除结点的前一个结点
        boolean flag = false;//标志是否找到待删除的结点
        while (true) {
            if (temp == null) {//已经到链表的最后结点的next
                break;
            }
            if (temp.no == no) {
//                找到待删除结点的前一个结点temp
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，进行遍历
        }
//        判断flag
        if (flag) {//找到
//        可以删除
            temp.pre.next = temp.next;
//            这里我们的代码有问题?
//            假设我们删除的是最后一个结点，下面的有问题，有条件，如果是最后一个结点，就不需要执行下面这句话，否则会出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的%d结点不存在\n", no);
        }
    }
}


//定义一个HeroNode，每个HeroNode对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点，默认为null
    public HeroNode2 pre;//指向前一个结点，默认为null

    //    构造器
    public HeroNode2(int hNo, String hName, String hNickname) {
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

