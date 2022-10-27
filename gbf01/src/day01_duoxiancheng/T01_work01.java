package day01_duoxiancheng;

import java.util.concurrent.TimeUnit;

public class T01_work01 {
    private static class T1 extends Thread{
        public void run(){
            for (int i = 0 ; i< 10; i++){
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }


    public static void main(String[] args) {
//        new T1().run();
        new T1().start();  //start 产生分支  和主方法一起调用   线程 ：一个程序里不同的执行路径
        for(int i=0 ; i<10;i++){
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }
}
