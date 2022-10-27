package day01_duoxiancheng;

public class T06_synchronized02 {

    private static int count = 10;

    public synchronized static void m(){ //这等同于 synchronized (T05_synchronized02.class)
        count--;
        System.out.println(Thread.currentThread().getName() + "count = "+ count);
    }

    public static void mm(){
        synchronized (T06_synchronized02.class){
            count--;
        }
    }
}
