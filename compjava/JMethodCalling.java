package com.compjava;


/*
* METHOD OVERLOAD AND OVERRIDE
* */
public class JMethodCalling {
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
        System.out.println("9 methodFive - int and float");
    }
}
