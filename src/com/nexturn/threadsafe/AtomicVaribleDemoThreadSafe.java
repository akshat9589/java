package com.nexturn.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

class MyThread {
    AtomicInteger count=new AtomicInteger();
//    int count;
    public  int incrementMethod(){

        return count.incrementAndGet();//Method to increment the Atomic variable
//        return count++;
    }
}

public class AtomicVaribleDemoThreadSafe {

    public static void main(String[] args) throws InterruptedException {
        MyThread th=new MyThread();
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    th.incrementMethod();
                }
            }
        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    th.incrementMethod();
                }
            }
        });


        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(th.count);
    }


}
