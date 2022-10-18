package com.nexturn.StaticPractices;


class Employee{
    int empid;
    String eName;
    //Static variable
    static String company="Infosys";

    //Static Block For Initialisation of static variable
    static{
        company="Nexturn";

    }
    //Static Method
   static void change(){
        company="TCS";
    }
    Employee(int empid,String ename){
        this.empid=empid;
        this.eName=ename;
    }


    void displayEmpDetail(){
        System.out.println("This is "+eName +"  Employee Id is "+empid +" and working in "+ company);
    }
}
public class StaticDemo {
    public static void main(String[] args) {
        Employee emp1=new Employee(101,"Akshat jain");
        Employee emp2 =new Employee(102,"Bittu");
        emp1.displayEmpDetail();
        Employee.change();// Calling static Method/*//We can only call static method with the help of Class name only
        emp2.displayEmpDetail();

    }


}
