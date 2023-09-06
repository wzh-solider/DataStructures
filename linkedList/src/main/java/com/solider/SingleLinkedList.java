package com.solider;


/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/5 19:53
 * @since 1.0
 */

// 单链表，管理node节点
public class SingleLinkedList {
    // 初始化一个空的头节点
    private static final HeroNode head = new HeroNode(0, "", "");

    // 添加节点
    public void add(HeroNode heroNode) {
        // 遍历所有的节点，找到链尾
        HeroNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = heroNode;
    }

    // 遍历节点
    public void iterator() {
        HeroNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            System.out.println(tmp);
        }
    }

    // 根据对应id排名，将节点加入到相应位置
    public void addByOrder(HeroNode heroNode) {
        // 添加一个辅助变量，指向添加节点的前节点
        HeroNode tmp = head;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false
        // 遍历节点，找到添加的位置
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
            System.out.println(heroNode.no + "节点no值重复，不能添加");
            return;
        }
        // 插入到相应位置
        heroNode.next = tmp.next;
        tmp.next = heroNode;
    }

    // 将节点插入到相应位置
    public void addIndex(int index, HeroNode heroNode) {
        // 对应位置的前置节点
        HeroNode tmp = head;
        int count = 0; // count记录下标

        while(tmp.next != null) {
            if (count++ == index) {
                heroNode.next = tmp.next;
                tmp.next = heroNode;
                break;
            }
            tmp = tmp.next;
        }

        if (heroNode.next == null) {
            tmp.next = heroNode;
        }
    }

    /**
     * 单链表的修改
     * @param index
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode) {
        // 设置临时变量
        HeroNode tmp = head;
        boolean flag = false;
        // 循环遍历，找到和index值相同的节点
        while (tmp.next != null) {
            if (tmp.next.no == newHeroNode.no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (!flag) {
            System.out.println("没有找到");
            return;
        }
        newHeroNode.next = tmp.next.next;
        tmp.next = newHeroNode;
    }

    /**
     * 删除节点
     */
    public void delete(HeroNode heroNode) {
        // 设置临时变量
        HeroNode tmp = head;
        boolean flag = false;

        // 循环遍历找到对应的节点
        while (tmp.next != null) {
            if (tmp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (!flag) {
            System.out.println("没有此节点");
            return;
        }
        tmp.next = tmp.next.next;
    }

    /**
     * 查找节点
     */
    public void findNode(int no) {
        // 设置临时变量
        HeroNode tmp = head;
        boolean flag = false;
        while(tmp.next != null) {
            if (tmp.next.no == no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (!flag) {
            System.out.println("没有找到");
            return;
        }
        System.out.println(tmp.next);
    }

    /**
     * 求链表中节点的个数
     */
    public int countNode() {
        int count = 0;
        HeroNode tmp = head;

        while (tmp.next != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    /**
     * 查找链表中的倒数第k个节点
     */
    public HeroNode findReverseNode(int k) {
        int size = countNode();
        HeroNode tmp = head;
        int count = 0;
        while (true) {
            if (count++ == size - k) {
                return tmp.next;
            }
            tmp = tmp.next;
        }
    }

    /**
     * 单链表的反转
     */
    public void linkedListReserve() {
        // 统计单链表的长度
        HeroNode heroNode = null;
        HeroNode tmp = head.next;
        while (tmp.next.next != null) {
            heroNode = tmp;
            tmp = tmp.next;
            heroNode.next = tmp;
            head.next = heroNode;
        }
    }
}
