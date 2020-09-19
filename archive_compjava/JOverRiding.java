package com.compjava;
/**
 * Method Overriding in JAVA
 * @author parveenkumar
 *
 * */
public class JOverRiding {
    static class Parent{
        //SCENARIO #8 (static methods)
        public static void staticMethod(){
            System.out.println("Parent Static Method");
        }
    }
    static class Child extends Parent{
        //SCENARIO #8 (static methods)
        //@Override //Error (compile time) because we cannot override static methods
        //with same method present in child class, this will be treated as
        //Method Hiding
        public static void staticMethod(){
            System.out.println("Child Static Method");
        }
    }
    public static void main(String[] args) {
        //SCENARIO #1
        //In overriding, method resolution is based on runtime object.
        //Therefore, following code will print output of ORChild print method.
        //Overriding is runtime Polymorphism , Dynamic Polymorphism or Late Binding
        //Late Binding is at Runtime. Early binding is at compile time
        //JVM will execute child object based on runtime object (method resolution
        //is always take care by JVM based on runtime object) (RUNTIME OBJECT)

        ORParent orParent = new ORChild();
        orParent.print();

        //SCENARIO #2
        //Covariant Return Type (Java 1.5 V onwards)
        orParent.covariantReturnType();

        //SCENARIO #8 (static methods)

        Parent.staticMethod();
        Child.staticMethod();
        Parent p = new Child();

    }
}
class ORParent{
    //SCENARIO #1
    public void print(){
        System.out.println("Print Parent");
    }
    //SCENARIO #2
    /*
    * Covariant Return type (From Java 1.5 Version onwards)
    * Please not that return type of child can be child of return type
    *
    * Example : String is child of Object so we can have Object return type
    *           in parent method and String return type in child type. But we
    *           cannot make say Boolean Return type in parent and String in
    *           child class
    * */
    public Object covariantReturnType(){
        return new String ("Parent Class");
    }
    public Number covariantNumber(){
        System.out.println("Number Covariant");
       return null;
    }
    //Covariant Return Type -> Not applicable for Primitive Types
    //Only applicable for Object Types
    public double covariantPrimitive(){
        return 10;
    }
    //SCENARIO #3
    /*
    * How about private method
    * */
    private void privateMethod(){
        System.out.println("Private Method");
    }

    //SCENARIO #4
    //We cannot override final method in child class
    public final void finalMethod(){
        System.out.println("Final Parent Method");
    }
    //but non final parent class method can be overridden
    //as final in child class

    public void nonFinalMethod(){
        System.out.println("Non - Final Parent Method");
    }

    //SCENARIO #5
    //abstract method of abstract class MUST be overridden in Child Class

    //SCENARIO #6
    // In overriding following modifier won't keep any restriction
    //  1. synchronized
    //  2. native
    //  3. strictfp

    //SCENARIO #7
    //In Overriding we cannot reduce the scope of access modifier
    // public > protected > default > private
    public void accessModifier(){

    }
    //But we can increase the scope of access modifier
    //increasing from default to protected
    void defaultModifier(){

    }
}
//SCENARIO #5
class OPParent{
    //We can override not abstract method as an abstract method
    public void parentParentMethod(){

    }
}
abstract class OParent extends OPParent{
    public abstract void abstractMethod();
    //Override Parent class non-abstract method as abstract method in
    //abstract class. the main advantage is parent method implementation is
    //not available once this abstract is extended in child class. Child class
    //of this abstract class has to implement their own implementation

    @Override
    public abstract void parentParentMethod();

    public void check(){
        System.out.println("Non Abstract Method");
    }
}
class OChild extends OParent {
    //SCENARIO #5
    @Override
    public void abstractMethod() {
        System.out.println("Override Abstract Class Method");
    }

    @Override
    public void parentParentMethod(){

    }
}
class ORChild extends ORParent{
    @Override
    public void print(){
        System.out.println("Print Child");
    }
    @Override
    public String covariantReturnType(){
        System.out.println("Child Class Covariant Return Type");
        return new String ("Child Class");
    }
    @Override
    public Integer covariantNumber() {
        return new Integer(9);
    }
    /* Only applicable for Object Type (Compile time Error)
    @Override
    public int covariantPrimitive(){
        return 1;
    }*/
    //@Override //ERROR - Error:(72, 5) java: method does not override or
    // implement a method from a supertype
    //Following is treated as separate method od child class
    //This is not Overriding
    private void privateMethod(){
        System.out.println("Private Method");
    }

    /*
    //Parent class final method can not be overridden in child classes
    //Compile time error OVERRIDDEN METHOD IS FINAL
    @Override
    public void finalMethod(){
        //Error:() java: finalMethod() in com.compjava.ORChild cannot override
        // finalMethod() in com.compjava.ORParent
        // overridden method is final
    }
    */

    //SCENARIO #4
    //non-final method of parent can be overridden as final method.
    @Override
    public final void nonFinalMethod(){

    }

    //SCENARIO #7
    //Error: java: accessModifier() in com.compjava.ORChild
    // cannot override accessModifier() in com.compjava.ORParent
    // attempting to assign weaker access privileges; was public
    /*
    void accessModifier(){

    }
    */

    @Override
    protected void defaultModifier(){
    //increasing the scope of access modifier
    }
}
