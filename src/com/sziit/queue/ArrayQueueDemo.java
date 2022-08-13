package com.sziit.queue;

public class ArrayQueueDemo {
    private int maxSize;
    private int[] arr;
    private int front;
    private int rear;

    public ArrayQueueDemo(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }
    public ArrayQueueDemo() {
        this.maxSize = 10;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    //判断队列是满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据
    public void addQueue(int n){
        if(isFull()){
            throw new RuntimeException("栈已满");
        }else {
            rear++;
            arr[rear]=n;
        }
    }

    //取出数据
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("栈已空");
        }
        return arr[++front];
    }

    //取出数据
    public void show(){
        if(isEmpty()){
            throw new RuntimeException("栈已空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+"="+arr[i]);
        }
    }

    //展现头数据
    public int head(){
        if(isEmpty()){
            throw new RuntimeException("栈已空");
        }
        return arr[front+1];
    }


}
