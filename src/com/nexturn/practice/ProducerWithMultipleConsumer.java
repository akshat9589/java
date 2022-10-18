package com.nexturn.practice;
import java.util.LinkedList;
import java.util.Scanner;
class ProducerConsumer1{
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;


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
class Producer1 extends Thread {
    ProducerConsumer1 pc;

    Producer1(ProducerConsumer1 pc) {
        this.pc = pc;
    }
    @Override
    public void run(){
        try {
            while(true) {
                this.pc.produce_num();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class Consumer1 extends Thread {
    ProducerConsumer1 pc;

    Consumer1(ProducerConsumer1 pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        try {
            while(true) {
                pc.consume_num();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

public class ProducerWithMultipleConsumer {
    public static void main(String[] args) {
        ProducerConsumer1 producerConsumer1 = new ProducerConsumer1();
        Producer1 p = new Producer1(producerConsumer1);
        Consumer1 c = new Consumer1(producerConsumer1);

        p.start();
        c.start();
        Producer1 p1 = new Producer1(producerConsumer1);
        Consumer1 c1 = new Consumer1(producerConsumer1);
        p1.start();
        c1.start();

        try {
            p.join();
            c.join();
            p1.join();
            c1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}


