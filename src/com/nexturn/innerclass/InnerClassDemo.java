package com.nexturn.innerclass;

class Outer{
String name="Akshat";

    class Inner{

   void greet(){
           System.out.println("Hello "+ name+"!");
       System.out.println("This Simple Inner Class Demo");
       }

    }
}

public class InnerClassDemo {
    public static void main(String[] args) {
     Outer ou = new Outer();
     Outer.Inner in= ou.new Inner();
     in.greet();

        }
}
