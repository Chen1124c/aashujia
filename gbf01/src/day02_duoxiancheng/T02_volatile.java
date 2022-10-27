package day02_duoxiancheng;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
volatile的作用：
* 保证线程可见性
    MESI--缓存一致性协议
* 禁止指令重排序
    DCL单例
    Double Check Lock
* */
public class T02_volatile {

    volatile int count = 0;
    void m(){
        for(int i = 0 ; i < 10000 ; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T02_volatile t = new T02_volatile();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m,"thread-"+i));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        System.out.println(t.count);
    }
}