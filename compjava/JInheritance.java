package com.compjava;
//@author : Parveen Kumar

//P is base class
class P{
    public double getNumber(){
        double x =  Math.random();
        return x;
    }
}
//Q is child class
class Q extends P{
    public String getString(){
        return "random";
    }
}
public class JInheritance {
    public static void main(String[] args) {
        //Instance of Q has all methods available from base (P) class (public methods)
        Q ob1 = new Q();
        double qNo = ob1.getNumber();
        String qStr = ob1.getString();
        

        //Simple polymorphism
        P ob2 = new Q();
        double pNo = ob2.getNumber();
        //We cannot have method getString() from Q!
    }
}
