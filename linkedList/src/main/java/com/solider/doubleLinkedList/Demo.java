package com.solider.doubleLinkedList;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/7 19:02
 * @since 1.0
 */
public class Demo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        // doubleLinkedList.add(new HeroNode(1, "张三", "100"));
        // doubleLinkedList.add(new HeroNode(2, "李四", "1000"));
        // doubleLinkedList.add(new HeroNode(3, "王五", "2000"));

        doubleLinkedList.addByNo(new HeroNode(1, "张三", "100"));
        doubleLinkedList.addByNo(new HeroNode(4, "张三", "100"));
        doubleLinkedList.addByNo(new HeroNode(3, "张三", "100"));
        doubleLinkedList.addByNo(new HeroNode(5, "张三", "100"));

        doubleLinkedList.delete(5);

        doubleLinkedList.iterator();
    }
}
