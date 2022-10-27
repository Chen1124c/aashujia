package day02_duoxiancheng;

import java.util.concurrent.TimeUnit;

public class T01_volatile {
    volatile boolean running = true;

    void m(){
        System.out.println("m . start");
        while(running){

        }
        System.out.println("m . end!");
    }

    public static void main(String[] args) {
        T01_volatile t = new T01_volatile();

        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;

    }
}
