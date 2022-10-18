package com.nexturn.practice;


import java.util.LinkedList;
import java.util.Scanner;

public class ProducerC {
    public static void main(String[] args)throws InterruptedException {

       PC pc= new PC();
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });


        t1.start();
        t2.start();
        t1.join();
        t2.join();





    }
    public static class PC{
        LinkedList<Integer>list= new LinkedList<>();
        int capacity=1;
        public void produce() throws InterruptedException{
            Scanner sc =new Scanner(System.in);
            int num = sc.nextInt();
            synchronized (this){
                while (list.size()==capacity)
                wait();
                System.out.println("Value: "+ num);
                list.add(num);
                notify();
                Thread.sleep(1000);
            }
        }
        public void consume() throws InterruptedException{
            synchronized (this){
                wait();
                int val=list.removeFirst();
                System.out.println("consumer consumed:" + val);
                {
                    int r,sum=0,temp;


                    temp=val;
                    while(val>0){
                        r=val%10;  //getting remainder
                        sum=(sum*10)+r;
                        val=val/10;
                    }
                    if(temp==sum)
                        System.out.println("palindrome number ");
                    else
                        System.out.println("not palindrome");
                }
                notify();
                Thread.sleep(1000);
                }
            }
        }

    }


