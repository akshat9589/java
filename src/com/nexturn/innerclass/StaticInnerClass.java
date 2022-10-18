package com.nexturn.innerclass;

class Outer1{
    //   String name="Akshat";  we can not access it in static method
    static String name="Akshat";

    static class Inner1{

        static void greet1(){
            System.out.println("Hello "+ name+"!");
        }

    }
}

public class StaticInnerClass {
    public static void main(String[] args) {

        Outer1.Inner1.greet1();//no need to make object of inner class to call the static method of inner class
    }
}
