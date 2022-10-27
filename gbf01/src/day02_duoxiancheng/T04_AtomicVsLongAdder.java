package day02_duoxiancheng;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class T04_AtomicVsLongAdder {
    static long count2 = 0L;
    static AtomicLong count1 = new AtomicLong();
    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
           threads[i] =
                   new Thread(()->{
                       for (int j = 0; j < 100000; j++) {
                           count1.incrementAndGet();
                       }
                   });
        }

        long start = System.currentTimeMillis();

        for (Thread t:threads) t.start();
        for (Thread t:threads) t.join();

        long end = System.currentTimeMillis();

        System.out.println("1---Atomic----"+ (start - end));

        //------------------------------------------------
        Object lock = new Object();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        synchronized (lock){
                            count2++;
                        }
                    }
                }
            });
        }

        start = System.currentTimeMillis();

        for (Thread t:threads) t.start();

        for (Thread t:threads) t.join();

        end = System.currentTimeMillis();

        System.out.println("2---sync----"+ (start - end));

        //------------------------------------------------
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j <100000; j++) {
                    count3.increment();
                }
            });
        }

        start = System.currentTimeMillis();

        for (Thread t:threads) t.start();

        for (Thread t:threads) t.join();

        end = System.currentTimeMillis();

        System.out.println("3---LongAdder----"+ (start - end));
    }
}
