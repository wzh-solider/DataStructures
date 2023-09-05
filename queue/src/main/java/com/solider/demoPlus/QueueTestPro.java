package com.solider.demoPlus;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/4 18:42
 * @since 1.0
 */
public class QueueTestPro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueuePlus queue = new QueuePlus(11);
        int count = 0;
        while (count++ != 10) {
            System.out.print("请输入数据：");
            queue.addQueue(scanner.nextInt());
        }

        // 显示队列的所有数据
        queue.showQueueData();

        // 显示队列中的所有元素
        queue.getQueue();

        // 取出头部数据
        System.out.println("\n" + queue.headQueue());
    }
}

// 环形队列
class QueuePlus {
    private int maxSize; // 队列最大容量, 但是环形队列的有效数据是 maxSize - 1
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 队列数组

    public QueuePlus(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     * @return 队列满返回true, 否则返回false
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     * @return 队列为空返回true, 否则返回false
     */
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    /**
     * 向队列中，添加数据
     */
    public void addQueue(int data) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，无法添加");
        } else {
            // 向队列中添加数据
            arr[rear] = data;

            // 环形队列，因额外有一个约定，所以需要将rear后移
            rear = (rear + 1) % maxSize;
            System.out.println("添加成功");
        }
    }

    /**
     * 取出队列中的数据
     * @return 取出的数据
     */
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int tmp = arr[front];
        front = (front + 1) % maxSize;
        return tmp;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueueData() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        // 遍历队列数组
        // Arrays.stream(arr).forEach(item -> System.out.println(item + "\t"));

        // 考虑使用for循环，以增强理解
        for (int i = front; i < front + size(); i++) {
            System.out.print(arr[i % maxSize] + "\t");
        }
    }

    /**
     * 记录循环队列中的有效数据
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的头部数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有头部数据");
        }
        return arr[front];
    }
}
