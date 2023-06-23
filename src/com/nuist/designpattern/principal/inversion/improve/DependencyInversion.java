package com.nuist.designpattern.principal.inversion.improve;

/**
 * @author 陈志远
 * @version 1.0
 * @create 2023-06-22 16:30
 * @description
 */
public class DependencyInversion {
    public static void main(String[] args) {
//        客户端无需做出改变
        Person person = new Person();
        person.receive(new Email());


        person.receive(new WeiXin());
    }
}

//定义一个接口
interface IReceiver {
    public String getInfo();
}

class Email implements IReceiver {
    public String getInfo() {
        return "电子邮件信息:hello,word";
    }
}

//增加微信
class WeiXin implements IReceiver{

    @Override
    public String getInfo() {
        return "微信消息:hello world";
    }
}

//方式2：
class Person {
//    这里我们是对接口的依赖
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
