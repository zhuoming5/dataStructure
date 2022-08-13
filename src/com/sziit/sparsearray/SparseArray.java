package com.sziit.sparsearray;

import java.io.Serializable;

public class SparseArray implements Serializable {

    private static final Long serialVersionUID = 4575444566551233L;

    public static void main(String[] args) {
        /**
         * 1.二维数组转稀疏数组
         * 2.稀疏数组转二维数组
         */
        int[][] chessArr1 = new int[11][11];
        chessArr1[0][0] = 1;
        chessArr1[8][8] = 2;
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[2][4] = 2;
        System.out.println("原始二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print(data + "  ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
        System.out.println("原始二维数组转稀疏数组");
        int sum = 0;
        for (int[] row : chessArr1) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < sparseArray[0][0]; i++) {
            for (int j = 0; j < sparseArray[0][1]; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("稀疏二维数组");
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.print(data + "  ");
            }
            System.out.println();
        }
        System.out.println("稀疏数组转二维数组");
        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("----------------");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.print(data + "  ");
            }
            System.out.println();
        }
    }
}
