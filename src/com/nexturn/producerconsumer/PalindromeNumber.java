package com.nexturn.producerconsumer;
import java.util.LinkedList;
import java.util.Scanner;
class ProducerConsumer {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 1;


    public void produce_num() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        synchronized (this) {
            while (list.size() == capacity)
                wait();
            System.out.println("Number Produced by Producer :" + num);
            list.add(num);
            notify();
            Thread.sleep(1000);
        }

    }

    public void consume_num() throws InterruptedException {
        synchronized (this) {
            wait();
            int val = list.removeFirst();
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
        Thread.sleep(1000);
    }
}
 class Producer extends Thread {
        ProducerConsumer pc;

        Producer(ProducerConsumer pc) {
            this.pc = pc;
        }
        @Override
         public void run(){
                       try {
                this.pc.produce_num();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

     class Consumer extends Thread {
        ProducerConsumer pc;

        Consumer(ProducerConsumer pc) {
            this.pc = pc;
        }

        @Override
        public void run() {
            try {
                pc.consume_num();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public class PalindromeNumber {
        public static void main(String[] args) {
           ProducerConsumer producerConsumer = new ProducerConsumer();
            Producer p = new Producer(producerConsumer);
            Consumer c = new Consumer(producerConsumer);

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


