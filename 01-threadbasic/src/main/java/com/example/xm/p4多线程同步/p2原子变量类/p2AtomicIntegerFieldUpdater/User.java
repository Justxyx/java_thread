package com.example.xm.p4多线程同步.p2原子变量类.p2AtomicIntegerFieldUpdater;


/**
 * 使用AtomicIntegerFieldUpdater 更新的字段必须用volatile修饰
 */
public class User {
     int id;
     volatile int age;

    public User(int id, int age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
