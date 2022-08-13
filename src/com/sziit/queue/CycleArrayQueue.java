package com.sziit.queue;

public class CycleArrayQueue {
    public static void main(String[] args) {
        //循环队列
    }
}

class CyclyArray {
    private int maxSize;
    private int[] arr;
    private int front;
    private int rear;

    public CyclyArray(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }


    //判断队列是满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据
    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("栈已满");
        } else {
            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }
    }

    //取出数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空");
        }
        int result = arr[front];
        front = (front + 1) % maxSize;
        return result;
    }

    //取出数据
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空");
        }
        //for (int i = 0; i < arr.length; i++) {
        //    System.out.println(i+"="+arr[i]);
        //}
        for (int i = front; i < front + size() % maxSize; i++) {
            System.out.println(i + "=" + arr[i%maxSize]);
        }

    }

    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    //展现头数据
    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空");
        }
        return arr[front];
    }
}
