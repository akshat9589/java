package com.nexturn.StaticPractices;

class Solution{
    int val=10;

// we can call non-static member with the help of the instance of  class
    public static void Increase(){
        Solution so=new Solution();  //making the instance of the class whose static member is to be called
        System.out.println(so.val);
     //   System.out.println(val);
    }
}

public class SolutionAmbiguity {
    public static void main(String[] args) {
        Solution.Increase();
    }
}
