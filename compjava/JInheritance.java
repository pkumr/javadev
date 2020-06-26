package com.compjava;
//@author : Parveen Kumar
/*  INHERITANCE : Java classes allow single inheritance but interfaces can
*   extend multiple interfaces
*
*  Example :
*   Java classes allow multilevel inheritance. ie. Class M is parent class
*   Class N can be child class and extends M and then Class O also extends
*   class N (N is parent for O)
*
*
* */

//Multilevel  Inheritance
class M {

}
class N extends M{

}
class O extends N{

}

//Example of Inheritance with methods
//P is base class
class P{
    public double getNumber(){
        double x =  Math.random();
        return x;
    }
}
//Q is child class
//
class Q extends P{
    public String getString(){
        return "random";
    }
}

/*
* Interfaces allow multiple inheritance.
* One interface can extends multiple interfaces.
*
* Ambiguity problem won't happen with Interfaces unlike classes
* because we can declare same method (name) in separate interfaces,
* but finally we will have only one implementation in class.
*
* Example:
*   Interface A has print method, Interface B has same name method
*   print() and C extends both A and B (multiple inheritance for
*   interfaces) and has its own print() -- same name method
*   When we implement A, B and C for InterClass, we just have to
*   implement print() method once.
*
* */
interface A{
    void print();
}
interface B{
    void print();
}
interface C extends A, B{
    void print();
}
class InterClass implements A, B, C{

    @Override
    public void print() {

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
