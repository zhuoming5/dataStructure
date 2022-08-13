package com.sziit.linkedlist;

public class SingleLinkListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "王麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkList s1 = new SingleLinkList();
        //s1.show();
        /*s1.addNode(hero1);
        s1.addNode(hero2);
        s1.addNode(hero3);
        s1.addNode(hero4);*/
        s1.addNodeByorder(hero1);
        s1.addNodeByorder(hero4);
        s1.addNodeByorder(hero2);
        s1.addNodeByorder(hero3);
        s1.addNodeByorder(hero2);
        //s1.show();
        //hero4 = new HeroNode(3, "林冲1", "豹子头1");

        //s1.update(hero4);
        s1.show();
        s1.delete(hero1);
        s1.delete(hero4);
        s1.show();


    }
}

class SingleLinkList {
    private HeroNode head = new HeroNode(0, "", "");

    //添加node
    public void addNode(HeroNode node) {
        HeroNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    //遍历list
    public void show() {
        if (head.getNext() == null) {
            System.out.println("该链表为空");
            return;
        }
        HeroNode temp = head;
        while (temp.getNext() != null) {
            System.out.println(temp.getNext());
            temp = temp.getNext();
        }
        System.out.println("---------------");
    }

    //通过编号删除
    public void delete(HeroNode node){
        if(head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp= head;
        while (temp.getNext() != null && temp.getNext().getNo() != node.getNo()){
            temp = temp.getNext();
        }
        if(temp == null ){
            System.out.println("链表无该元素");
        }else if(temp.getNext().getNo() == node.getNo()){
            System.out.println("删除元素"+node.getNo());
            temp.setNext(temp.getNext().getNext());
        }

    }

    //通过编号更新
    public void update(HeroNode newNode){
        if(head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp= head.getNext();
        while (temp != null &&temp.getNo() != newNode.getNo()){
            temp = temp.getNext();
        }
        if(temp == null ){
            System.out.println("链表无该元素");
        }else if(temp.getNo() == newNode.getNo()){
            temp.setNickname(newNode.getNickname());
            temp.setName(newNode.getName());
        }
    }

    //插入排序
    public void addNodeByorder(HeroNode node) {
        HeroNode temp = head;

        while (temp.getNext() != null && temp.getNext().getNo() < node.getNo()) {
            temp = temp.getNext();
        }
        if (temp.getNext() == null) {
            temp.setNext(node);
            System.out.println("元素" + node.getNo() + "末尾插入！");
            show();
        } else if (temp.getNext().getNo() > node.getNo()) {
            node.setNext(temp.getNext());
            temp.setNext(node);
            System.out.println("元素" + node.getNo() + "之间插入");
            show();
        } else {
            System.out.println("元素" + node.getNo() + "编号已重复！");
            show();
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private String nickname;
    private HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
