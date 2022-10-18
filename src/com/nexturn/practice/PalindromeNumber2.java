package com.nexturn.practice;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer2 extends Thread{
  BlockingQueue<Integer> bqueue;
  public Producer2(BlockingQueue<Integer> bqueue){
      this.bqueue=bqueue;
  }

    public void produce_num() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        bqueue.put(num);
            System.out.println("Number Produced by Producer :" + num);

        }
        @Override
    public void run(){
        try {
            while(true) {
                produce_num();
//                notify();
//                wait();
            }
          //  Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Consumer2 extends Thread{
   BlockingQueue<Integer>bqueue;

   public Consumer2(BlockingQueue<Integer> bqueue)  {
       this.bqueue=bqueue;
   }


    public void consume_num() throws InterruptedException {
            int val=bqueue.take();
            System.out.println("consumed value: " + val);
            int r, sum = 0, temp;
            temp = val;
            while (val > 0) {
                r = val % 10;  //getting remainder
                sum = (sum * 10) + r;
                val = val / 10;
            }
            if (temp == sum)
                System.out.println("palindrome number ");
            else
                System.out.println("not palindrome");
        }
    @Override
    public void run() {
        try {
            while(true) {
                consume_num();
//                notify();
//                wait();
            }
           // Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class PalindromeNumber2 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer>bqueue=new ArrayBlockingQueue<>(1);

        Producer2 p = new Producer2(bqueue);
        Consumer2 c = new Consumer2(bqueue);
        p.start();
        c.start();
        try {
            p.join();
            c.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


