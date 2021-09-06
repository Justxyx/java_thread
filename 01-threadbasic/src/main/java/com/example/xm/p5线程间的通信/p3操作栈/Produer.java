package com.example.xm.p5线程间的通信.p3操作栈;


public class Produer extends Thread {
    private MyStack stack;

    public Produer(MyStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true){
            stack.push();

        }
    }
}
