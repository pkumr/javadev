package com.compjava;
/**
 * *********** METHOD OVERLOADING *****************
 * @author : Parveen Kumar
 *
 * In Overloading, method resolution is always takes care at compile time by compiler. thus
 * overloading is also called static binding, early binding or compile time polymorphism.
 * (REFERENCE OBJECT)
 * */
public class JOverLoading {
    public static void main(String[] args) {
        MethodOverloading objOne = new MethodOverloading();
        //SCENARIO #1
        objOne.methodOne();
        objOne.methodOne(2);

        //SCENARIO #2
        objOne.methodTwo(1);
        objOne.methodTwo("Hello");

        //SCENARIO #3
        objOne.methodThree(1);//int is fine
        objOne.methodThree('a'); //char will be converted to int
        byte b = 2;
        objOne.methodThree(b);
        //objOne.methodThree(1F);  ERROR because Float is next to int

        //Compiler will promote to next levels and not previous levels
        //************************Level (left to right)***************
        //          byte -> short ->
        //                            ->int -> long -> float -> double
        //                  char ->
        //************************************************************
        //Now Created a method methodThree with input parameter as double
        objOne.methodThree(1F);

        //SCENARIO #4
        objOne.methodFour(new String());
        objOne.methodFour(new Object());
        // Now null is a valid String Argument or Object Argument too
        // Child class will take priority over parent, So
        // null will be passed to methodFour with String input argument!
        objOne.methodFour(null);

        //SCENARIO #5
        //objOne.methodFive(5, 5);
        //ERROR
        //Error:(43, 15) java: reference to methodFive is ambiguous

        //SCENARIO #6
        //objOne.methodSix(null);

        //The above call will give compile time error. We have seen in Scenario that
        //child class is given high priority.

        //But here String and String Buffer are at same level and that is why java
        //compiler will throw error while identifying the method to overload

        //Error: java: reference to methodSix is ambiguous
        //  both method methodSix(java.lang.String) in com.compjava.MethodOverloading and
        //  method methodSix(java.lang.StringBuffer) in com.compjava.MethodOverloading match

        //SCENARIO #7
        objOne.methodSeven();//var-arg method
        objOne.methodSeven(10, 20); //var-arg method
        objOne.methodSeven(10); //General Method
        //var - arg method will get least priority

        //SCENARIO #8
        Test test = new Test();
        Parent p = new Parent();
        test.method(p); // Parent Version called

        Child c = new Child();
        test.method(c); //Child Version called

        Parent p1 = new Child();
        test.method(p1); //Parent Version called
        //because reference used here (p1) is of Parent
        //and compiler will give preference to reference
        //in overloading
    }
}
class MethodOverloading{
    //SCENARIO #1
    public void methodOne(){
        System.out.println("1 - methodOne");
    }
    public void methodOne(int x){
        System.out.println("2 - methodOne with int x");
    }

    //SCENARIO #2 Different Types
    public void methodTwo(int i){
        System.out.println("3 - methodTwo with only int");
    }
    public void methodTwo(String s){
        System.out.println("4 - methodTwo with only String");
    }

    //SCENARIO #3 DataTypes conversions
    public void methodThree(int x){
        System.out.println("5 - methodThee - " + x);
    }
    public void methodThree(double x){
        System.out.println("6 - methodThree(double)" + x);
    }

    //SCENARIO #4
    public void methodFour(String s){
        System.out.println("7 methodFour - String Version ");
    }
    public void methodFour(Object o){
        System.out.println("8 methodFour - Object Version");
    }
    //SCENARIO #5
    public void methodFive(int i, float f){
        System.out.println("9 methodFive - int and float");
    }
    public void methodFive(float f, int i){
        System.out.println("10 methodFive - int and float");
    }

    //SCENARIO #6
    public void methodSix(String s){
        System.out.println("11 methodSix - String Version ");
    }
    public void methodSix(StringBuffer stringBuffer){
        System.out.println("12 methodSix - String Buffer Version");
    }

    //SCENARIO #7
    public void methodSeven(int x){
        System.out.println("13 - methodSeven - General Method");
    }
    public void methodSeven(int... x){
        System.out.println("14 - methodSeven - Var - arg method");
    }
}
//SCENARIO #8
//In overloading Method Resolution always takes care by compiler
//based on reference type
class Parent{

}
class Child extends Parent{

}
class Test{
    public void method(Parent p){
        System.out.println("Parent Version");
    }
    public void method(Child c){
        System.out.println("Child Version");
    }
}

