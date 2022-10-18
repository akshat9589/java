package com.nexturn.reflection;
// Java Program to demonstrate the Use of Reflection

// Importing required classes
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Class 1
// Of Whose object is to be created
class TestReflection {
    // creating a private field
    private String s;

    // Constructor of this class

    // Constructor 1
    // Public constructor
    public TestReflection() { s = "Reflection"; }

    // Constructor 2
    // no arguments
    public void method1()
    {
        System.out.println("The string is " + s);
    }

    // Constructor 3
    // int as argument
    public void method2(int n)
    {
        System.out.println("The number is " + n);
    }

    // Constructor 4
    // Private method
    private void method3()
    {
        System.out.println("Private method invoked");
    }
}

// Class 2
// Main class
@SuppressWarnings("deprecation")
public class Reflection {

    // Main driver method
    public static void main(String args[]) throws Exception
    {
        // Creating object whose property is to be checked

        // Creating an object of class 1 inside main()
        // method
        TestReflection obj = new TestReflection();

        // Creating class object from the object using
        // getClass() method
        Class cls = obj.getClass();

        // Printing the name of class
        // using getName() method
        System.out.println("The name of class is "
                + cls.getName());

        // Getting the constructor of the class through the
        // object of the class
        Constructor constructor = cls.getConstructor();

        // Printing the name of constructor
        // using getName() method
        System.out.println("The name of constructor is "
                + constructor.getName());

        // Display message only
        System.out.println(
                "The public methods of class are : ");

        // Getting methods of the class through the object
        // of the class by using getMethods
        Method[] methods = cls.getMethods();

        // Printing method names
        for (Method method : methods)
            System.out.println(method.getName());

        // Creates object of desired method by
        // providing the method name and parameter class as
        // arguments to the getDeclaredMethod() method
        Method methodcall1
                = cls.getDeclaredMethod("method2", int.class);

        // Invoking the method at runtime
        methodcall1.invoke(obj, 19);

        // Creates object of the desired field by
        // providing the name of field as argument to the
        // getDeclaredField() method
        Field field = cls.getDeclaredField("s");

        // Allows the object to access the field
        // irrespective of the access specifier used with
        // the field
        field.setAccessible(true);

        // Takes object and the new value to be assigned
        // to the field as arguments
        field.set(obj, "JAVA");

        // Creates object of desired method by providing the
        // method name as argument to the
        // getDeclaredMethod()
        Method methodcall2
                = cls.getDeclaredMethod("method1");

        // Invokes the method at runtime
        methodcall2.invoke(obj);

        // Creates object of the desired method by providing
        // the name of method as argument to the
        // getDeclaredMethod() method
        Method methodcall3
                = cls.getDeclaredMethod("method3");

        // Allows the object to access the method
        // irrespective of the access specifier used with
        // the method
        methodcall3.setAccessible(true);

        // Invoking the method at runtime
        methodcall3.invoke(obj);





        Class aClass =Class.forName("com.nexturn.reflection.A"); // making object of class A
        Constructor con=aClass.getConstructor(String.class,int.class); //geting the constructor
        Object a=con.newInstance("Aksh",20);//
         Field f=aClass.getDeclaredField("sts");
         f.setAccessible(true);


        Method getstsMethod=aClass.getMethod("getSts");
        getstsMethod.invoke(a);


        Method getIMethod=aClass.getMethod("getI");
        getIMethod.invoke(a);

        Method printShowMethod =aClass.getMethod("showDetail", String.class,int.class);
        printShowMethod.invoke(a, "aksh", 13);

    }
}


class A {
    private String sts;
    private int i;
    public A(){

    }
    public A(String sts, int i){
        this.sts = sts;
        this.i = i;
    }
    public String getSts(){
        return this.sts;

    }

    public void setSts(String sts){
        this.sts=sts;
    }
    public int getI(){

        return this.i;
    }
    public  void  setI(int i){
        this.i=i;
    }
    public void showDetail(String sts,int i){
        System.out.println("This is value of Sts "+ sts + " & this is value of i "+ i);
    }
}


