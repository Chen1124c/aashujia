package day03_juc;

import java.util.concurrent.TimeUnit;

public class T01_ReentractLock1 {
    synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if(i == 2 ) m2(); //锁可重入
        }
    }

    synchronized void m2(){
        System.out.println("m2 ...");
    }

    public static void main(String[] args) {
        T01_ReentractLock1 rl = new T01_ReentractLock1();
        new Thread(rl::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(rl::m2).start();
    }
}
