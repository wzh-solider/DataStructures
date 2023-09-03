package com.demo;

import java.util.Arrays;

/**
 * 数据结构---稀疏数组
 * @author Solider
 * @version 1.0
 * @Date 2023/9/3 18:57
 * @since 1.0
 */
public class SparseArray {
    private static final int[][] chessArr1 = new int[11][11];

    static {
        // 原始11*11的二维数组
        // 0：表示没有棋子，1：表示黑子，2：表示蓝子
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
    }

    public static void main(String[] args) {
        SparseArray sparseArray = new SparseArray();

        int[][] sparseArr = sparseArray.twoArrToSparseArr(chessArr1);
        // 测试输出
        sparseArray.iteratorToPrint(sparseArr);

        System.out.println("\n\t-----------------------------------------\n");

        int[][] restoreArray = sparseArray.sparseArrToTwoArr(sparseArr);
        // 测试输出
        sparseArray.iteratorToPrint(restoreArray);
    }

    /**
     * 循环输出
     */
    public void iteratorToPrint(int[][] o) {
        // 测试输出
        for (int[] ints : o) {
            for (int data : ints) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }
    }

    /**
     * 二维数组 ---> 稀疏数组
     *
     * @param chessArr 二维数组
     * @return 稀疏数组
     */
    public int[][] twoArrToSparseArr(int[][] chessArr) {
        // 将二维数组，转换为稀疏数组
        // 1、遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("有效的数据总数：" + sum);

        // 2、创建稀疏数组
        // 0列：原二维数组的行row
        // 1列：原二维数组的列col
        // 2列：所对应的值val
        int[][] sparseArray = new int[sum + 1][3];

        // 记录稀疏数组的行和列
        int row = 0;

        // 初始化稀疏数组的第0行
        // 初始化第0行
        sparseArray[row][0] = chessArr.length;
        sparseArray[row][1] = chessArr[0].length;
        sparseArray[row][2] = sum;

        // 循环遍历二维数组，并将相应的值存入
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    ++row;
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = chessArr[i][j];
                }
            }
        }
        return sparseArray;
    }

    /**
     * 稀疏数组 ---> 二维数组
     *
     * @param sparseArr 稀疏数组
     * @return 二维数组
     */
    public int[][] sparseArrToTwoArr(int[][] sparseArr) {
        // 将稀疏数组，转换为二维数组

        // 初始化
        int[][] restoreArray = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 循环赋值
        for (int i = 1; i < sparseArr.length; i++) {
            int rows = sparseArr[i][0];
            int cols = sparseArr[i][1];
            restoreArray[rows][cols] = sparseArr[i][2];
        }
        return restoreArray;
    }

}