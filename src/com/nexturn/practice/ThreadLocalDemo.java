package com.nexturn.practice;


class MyRunnable implements Runnable{
    ThreadLocal<Integer> threadLocal= new ThreadLocal(){  //creating a thread local varible
        protected Integer initialValue(){      //initializing initial value to threadLocal
            return 0;
        }
    };


    @Override
    public void run() {
        for(int i=0;i<5;i++){
         threadLocal.set(threadLocal.get()+1);  //setting the value to the thread local variable
            System.out.println( Thread.currentThread().getName()+" "+threadLocal.get());
        }
    }
}
public class ThreadLocalDemo {
    public static void main(String[] args) {
        MyRunnable runnable= new MyRunnable();
        Thread  t1= new Thread(runnable);
        Thread  t2= new Thread(runnable);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
