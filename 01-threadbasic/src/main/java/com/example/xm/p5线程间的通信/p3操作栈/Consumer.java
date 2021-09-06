package com.example.xm.p5线程间的通信.p3操作栈;

public class Consumer extends Thread{
    private MyStack myStack;

    public Consumer(MyStack myStack) {
        this.myStack = myStack;
    }

    @Override
    public void run() {
        while (true){
            myStack.pop();
        }
    }
}

