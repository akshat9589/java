package com.nexturn.StaticPractices;

class StaticClass{
   int num;
    public static void Increment(){
       //num += 1;
        System.out.println("hello");
    }
}

public class AmbiguityProblem {
    public static void main(String[] args) {
        StaticClass sc1 = new StaticClass();
        StaticClass sc2 = new StaticClass();
        StaticClass sc3 = new StaticClass();
        sc1.num=1;
        sc2.num=3;
        sc3.num=4;
        StaticClass.Increment();
        System.out.println(sc1.num);
        System.out.println(sc2.num);
        System.out.println(sc3.num);
    }
}
