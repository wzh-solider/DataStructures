package com.solider.doubleLinkedList;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/5 19:54
 * @since 1.0
 */

// 定义node节点
public class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode pre; // 指向前一个节点
    public HeroNode next; // 指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
