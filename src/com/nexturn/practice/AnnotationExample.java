package com.nexturn.practice;


@MyAnnotation(id=1,name = "Aksh")
class A{
    void show(){
        System.out.println("I am in A class");
    }
    @Deprecated//annotation
    void display(){
        System.out.println("I am display method of A");
    }


}
class B extends A{
    @Override//annotation
     void show(){
        System.out.println("I am in B class");

    }
}


public class AnnotationExample {
    public static void main(String[] args) {
        A a= new A();
        Class d=a.getClass();
        System.out.println("the Custom Annotation is :" + d.getAnnotation(MyAnnotation.class));
        a.show();
        a.display();

    }
}
