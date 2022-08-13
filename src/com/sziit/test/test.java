package com.sziit.test;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        test01();
        test02();
        //System.out.println(3%3);
    }

    public static void test01() throws IOException {
        int[][] arr = new int[3][3];
        arr[0][0] = 11;
        arr[0][1] = 11;
        arr[0][2] = 1;
        arr[1][0] = 0;
        arr[1][1] = 0;
        arr[1][2] = 1;
        arr[2][0] = 0;
        arr[2][1] = 1;
        arr[2][2] = 2;
        FileOutputStream fos = new FileOutputStream("data.txt");
        for (int[] row : arr) {
            for (int data : row) {
                fos.write(data);
            }
        }
        fos.flush();
        fos.close();
    }

    public static void test02() throws IOException {
        FileInputStream fio = new FileInputStream("data.txt");
        byte[] bytes = new byte[1024];
        int count = 0;
        int sum = 0;
        int[][] ints = new int[3][3];
        ints[0][0] = 11;
        ints[0][1] = 11;
        ints[0][2] = 1;
        while ((count = fio.read()) != -1) {
            sum++;
            //System.out.print(count+" ");
            //if(sum % 3 == 0){
            //    System.out.println();
            //}
            ints[sum][0] = count;


        }
    }
}
