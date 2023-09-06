package com.solider;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/5 19:57
 * @since 1.0
 */
public class Demo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // singleLinkedList.add(new HeroNode(1, "张三", "100"));
        // singleLinkedList.add(new HeroNode(2, "李四", "200"));
        // singleLinkedList.addIndex(1, new HeroNode(3, "王五", "300"));

        singleLinkedList.addByOrder(new HeroNode(1, "张三", "100"));
        // singleLinkedList.addByOrder(new HeroNode(10, "lisi", "100"));
        singleLinkedList.addByOrder(new HeroNode(10, "李四", "100"));
        singleLinkedList.addByOrder(new HeroNode(5, "王五", "100"));
        singleLinkedList.addByOrder(new HeroNode(6, "刘二麻子", "100"));

        singleLinkedList.update(new HeroNode(10, "lisi", "100"));
        singleLinkedList.delete(new HeroNode(5, "王五", "100"));

        singleLinkedList.iterator();
        singleLinkedList.findNode(10);

        // 求单链表中节点的个数
        int countNodes = singleLinkedList.countNode();
        System.out.println("单链表的节点个数 = " + countNodes);

        // 取出倒数第k个节点
        int k = 1;
        HeroNode heroNode = singleLinkedList.findReverseNode(k);
        System.out.println("倒数第" + k + "个节点是：" + heroNode);

        // 反转链表
        singleLinkedList.linkedListReserve();
        singleLinkedList.iterator();
    }
}
