package com.example.xm.p3锁.p1sync;

/**
 * 脏读问题
 * 问题的源头在于，两个线程
 * 一个线程在修改对象中的属性值
 * 一个线程在读取对象中的属性值
 * 没有加锁 必然会发生脏读问题
 */

/*
解决方案：
    修改与读取共享数据，都要加同步锁
 */
public class Test08 {

    public static void main(String[] args) {
        PublicValue publicValue = new PublicValue();
        Threadxx threadxx = new Threadxx(publicValue);
        threadxx.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        publicValue.getValue();

    }

    static class Threadxx extends Thread{
        private PublicValue publicValue;

        public Threadxx(PublicValue publicValue) {
            this.publicValue = publicValue;
        }

        @Override
        public void run() {
            publicValue.setValue("linjunjie","caocao");
        }
    }

    static class PublicValue{
        private String name = "zhoujielun";
        private String pwd = "qingtian";

        public synchronized void setValue(String name,String pwd){
            this.name = name;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.pwd = pwd;
            System.out.println("子线程修改完成---------------------------------");
        }

        public synchronized void getValue(){
            System.out.println("=====================");
            System.out.println(name + "-----" + pwd);
        }
    }
}
