package day01_duoxiancheng;

public class T07_synchronized03 implements Runnable{

    private /*volatile*/ int count = 100;

    public /*synchronized*/ void run(){
        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }

    public static void main(String[] args){
        T07_synchronized03 t = new T07_synchronized03();
        for(int i = 0; i < 100;i++){
            new Thread(t,"THREAD" + i).start();
        }
    }
}
