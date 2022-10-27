package day01_duoxiancheng;

import java.util.concurrent.TimeUnit;
//写加锁  读不加锁
//脏读现象

public class T08_Account {
    String name;
    double balance;

    public synchronized void set(String name,double balance){
        this.name = name;

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    public /*synchronized*/ double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        T08_Account a = new T08_Account();
        new Thread(()->a.set("zhangsan", 100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));
    }
}
