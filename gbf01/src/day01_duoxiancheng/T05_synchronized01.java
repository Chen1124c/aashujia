package day01_duoxiancheng;

public class T05_synchronized01 {

    private int count = 10;
    private Object o = new Object();

//    public void m(){
//        synchronized (o){
//            count--;
//            System.out.println(Thread.currentThread().getName() + "count = " + count);
//        }
//    }


//    public void m(){
//        synchronized (this){//锁定当前对象
//            count--;
//            System.out.println(Thread.currentThread().getName() + "count = " + count);
//        }
//    }

    public synchronized void m(){//与锁this等值
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
    }
}
