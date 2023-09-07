package com.solider.doubleLinkedList;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/7 19:03
 * @since 1.0
 */
public class DoubleLinkedList {
    private static final HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加数据
     */
    public void add(HeroNode heroNode) {
        // 定义临时变量，指向头指针
        HeroNode tmp = head;
        // 循环遍历节点，找到尾节点
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = heroNode;
        heroNode.pre = tmp;
    }

    /**
     * 遍历数据
     */
    public void iterator() {
        // 定义临时变量
        HeroNode tmp = head;
        while (tmp.next != null) {
            System.out.println(tmp.next);
            tmp = tmp.next;
        }
    }

    /**
     * 按排名序号插入数据
     */
    public void addByNo(HeroNode heroNode) {
        // 定义临时变量
        HeroNode tmp = head;
        boolean flag = false;
        while (tmp.next != null) {
            if (tmp.next.no > heroNode.no) {
                break;
            } else if (tmp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            System.out.println(heroNode.no + "是重复节点，不能添加");
            return;
        }
        // 位置已找到，执行插入操作
        if (tmp.next == null) {
            tmp.next = heroNode;
            heroNode.pre = tmp;
        } else {
            heroNode.next = tmp.next;
            heroNode.pre = tmp;
            tmp.next.pre = heroNode;
            tmp.next = heroNode;
        }
    }

    /**
     * 删除操作
     */
    public void delete(int index) {
        HeroNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.no == index) {
                if (tmp.next.next == null) {
                    tmp.next = null;
                } else {
                    tmp.next.next.pre = tmp;
                    tmp.next = tmp.next.next;
                }
                break;
            }
            tmp = tmp.next;
        }
    }
}
