package day02_duoxiancheng;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class T03_AtomicInteger {
   AtomicInteger count = new AtomicInteger();
    /*synchronized*/void m(){
        for(int i = 0 ; i < 10000 ; i++) {
            count.incrementAndGet();  //count++
        }
    }

    public static void main(String[] args) {
        T03_AtomicInteger t = new T03_AtomicInteger();

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
