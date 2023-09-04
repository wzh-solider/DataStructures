# 数据结构



## 线性结构 和 非线性结构

- 线性结构

  > 数组、队列、链表、栈

​	1、线性结构是最常用的数据结构，特点：**数据元素之间存在一对一的线性关系**

​	2、线性结构有两种不同的存储结构（**顺序存储结构**、**链式存储结构**）

​	3、链式存储的线性表称为链表，存储元素**地址**不连续，元素节点中存放数据元素以及相邻元素的**地址信息**

- 非线性结构

  > 二维数组、多维数组、广义表、树结构、图结构



### 稀疏数组（sparsearray）

> 当一个数组中，大部分元素为0，或者为一个值的数组时，可以采用**稀疏数组**进行保存

处理方法：

- 记录数组一共有几行几列，有多少不同的值
- 把具有不同值的元素行列值，记录在一个小规模的数组中，从而缩小程序规模

![image-20230903174922686](imgs/image-20230903174922686.png)



## 队列

> 队列是一个有序列表，可以使用**数组**和**链表**进行实现
>
> 队列遵循**先进先出**的原则



因为队列的输入、输出分别从前后端处理，因此需要两个变量**front**和**rear**分别记录队列前后端的下标

**front**会随着数据输出而改变，而**rear**则是随着数据输入而改变

![image-20230904183829358](imgs/image-20230904183829358.png)

