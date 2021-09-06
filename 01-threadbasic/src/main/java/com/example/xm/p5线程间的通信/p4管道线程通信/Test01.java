package com.example.xm.p5线程间的通信.p4管道线程通信;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.StreamCorruptedException;

/**
 * 这一节笔记中没有
 *      一个线程发送数据到输出管道，另一个线程从输入管道中读取相应的数据
 *      字节流：
 *          PipedInputStream PipedOuputStream
 *       字符流：
 *          PipedReader PipeWriter
 **/
public class Test01 {
    public static void main(String[] args) throws IOException {
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();

        inputStream.connect(outputStream);

        new Thread(new Runnable() {
            @Override
            public void run() {
                writeDate(outputStream);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    readData(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static void writeDate(PipedOutputStream out) {
        for (int i = 0; i < 100; i++) {
            String data = i + "";
            try {
                out.write(data.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readData(PipedInputStream in) throws IOException {
        byte[] bytes = new byte[1024];

            int read = in.read(bytes);

        while (read != -1){
            System.out.println(new String(bytes,0,read));
            read = in.read(bytes);

        }

        in.close();
    }

}