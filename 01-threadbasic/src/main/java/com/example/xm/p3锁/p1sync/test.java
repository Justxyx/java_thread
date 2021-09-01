package com.example.xm.p3锁.p1sync;

public class test {
    public static void main(String[] args) {
        demo demo = new demo();

        System.out.println("--------------");
        demo.setName("linzhixuan");
        demo.setPwd("liren");;
        System.out.println(Thread.currentThread().getName() + "设置了数据" );
        System.out.println("--------------");
        System.out.println(Thread.currentThread().getName() + "读取了数据" + demo.getName() + demo.getPwd());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("--------------");
                demo.setName("linjuejie");
                demo.setPwd("qingtian");;
                System.out.println(Thread.currentThread().getName() + "设置了数据" );
                System.out.println("--------------");
                System.out.println(Thread.currentThread().getName() + "读取了数据" + demo.getName() + demo.getPwd());
            }
        }).start();


    }

    static class  demo{
        private String name = "zhoujielun";
        private String pwd = "qingtian";

        public synchronized String getName() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return name;
        }

        public synchronized void setName(String name) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.name = name;
        }

        public synchronized String getPwd() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return pwd;
        }

        public synchronized void setPwd(String pwd) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.pwd = pwd;
        }
    }
}
