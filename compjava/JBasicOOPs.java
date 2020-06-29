package com.compjava;
/*
* @author : Parveen Kumar
* OOPS
*
* Three Pillars of OOPS
*   1.  Encapsulation --> Security
*   2.  Inheritance --> Reusability
*   3.  Polymorphism --> Flexibility to Programmer
*
* */

/*
* Encapsulation (data/information hiding)
* */
class Employee{
    //Salary is hidden
    private double salary = 10000;
    //To access salary getSalary is method to access from Employee
    public double getSalary(){
        return salary;
    }
}

public class JBasicOOPs {
    public static void main(String[] args) {
        //Encapsulation example
        Employee employee = new Employee();
        double salary = employee.getSalary();
    }
}
/*
 * HAS - A relation
 * Let's have a class Person. the class person has name and age
 * properties. then class Person HAS A relation with name and
 * age
 *
 *
 * Example: When to go for IS-A and HAS-A relation
 *  1.  when we have Parent class and we need whole functionality of Parent
 *      class we extend Parent class in Child class. This way all methods and
 *      functionality of Parent is available in Child class. So we can say
 *      IS-A relation when we need total functionality of Parent in Child.
 *      (Whole Functionality)
 *
 * 2.   when we have class A and we create instance of class A in class B and
 *      use only one or two methods (not all available methods in A) of class A
 *      in B class. This is where we went for HAS-A relation (PART of Functionality)
 *
 * */
class Person{
    String name;
    int age;
}
/*
* COMPOSITION (HAS - A relation)
* University has four departments - Computer, Electronics, Electrical
* and Mechanical departments.
* University in container object and Departments are contained objects
*
* if instance of University is destroyed or cleaned (finalize by GC)
* all the contained objects will be destroyed. This means container and
* contained objects are strongly associated. this strong association is
* called COMPOSITION
*
*
*/

class University{
    //Computer Engineering Department
    class ComputerDept{

    }
    //Electronics and Communication Engineering Department
    class ElectronicDept{

    }
    //Electrical Engineering Department
    class ElectricalDept{

    }
    //Mechanical Engineering Department
    class MechanicalDept{

    }
    //Instances for Aggregation Scenario
    Professor mathProfessor = new Professor();
    Professor csProfessor = new Professor();
    Professor eceProfessor = new Professor();
}
/*
* AGGREGATION (HAS - A relation)
* The instances of Professor class is used in University Object. If
* GC finalize University Object all objects are destroyed and also
* instances (mathProfessor,csProfessor,eceProfessor). But if Professor
* class is used in any other class, those instances will not be affected.
* This means Professor and University are weekly connected. This week
* association is called AGGREGATION
*
 */

class Professor{

}

/*
* Polymorphism
* There are two type of Polymorphism
*   1. Static Polymorphism (or) Compile Time Polymorphism (or) Early Binding
*       Example :   a) Overloading
*                   b) Method Hiding (static method example)
*   2. Dynamic Polymorphism (or) Runtime Polymorphism (or) Late Binding
*       Example :   a) Overriding
*
* */


/*
*                      Difference between Overloading & Overriding
*   ----------------------------------------------------------------------------------------------------
*   #      PROPERTY                OVERLOADING                 OVERRIDING
*   1     method names            must be same                 must be same
*   2     argument types         must be different            must be same
*   3     method signature      must be different             must be same
*   4     return type           no restriction                must be same (until 1.4 V) co-variant (1.5)
*   5     private, static       can be overloaded             can't be overridden
*         final methods
*   6     Access Modifiers      no restrictions               the scope of access modifier
*                                                             can't be reduced but can be increased
*   7     throws clause         no restrictions               if child class method throws any
*                                                             checked exception, then parent class
*                                                             method must throw the same checked
*                                                             exception or its parent. No restriction
*                                                             for unchecked exception
*   8    method resolution      taken care by compiler        taken care by JVM based on runtime
*                               based on reference type       object
*   9    Also known as          Compile Time Polymorphism     Runtime Polymorphism
*                               Static Polymorphism           Dynamic Polymorphism
*                               Early Binding                 Late Binding
*
* */

/*
*
* *******************  PARENT / CHILD Reference *********************
*
*   If we don't know exact runtime type of object then we should go for
*   parent reference.
*   Example :
*       Let's have an arrayList hold objects of person, customer, string
*       and string buffer.
*       When we are trying to access objects in arraylist then,
*       First element present in arraylist can be any type. It may be
*       customer object, person object, string object or string buffer
*       object.
*       Hence return type of get Method is object type, that can hold
*       any object
*
*   ChildClass child = new ChildClass()     |      ParentClass parent = new ChildClass();
*   eg ArrayList al = new ArrayList();      |      List l = new ArrayList();
*                                           |
*   1. Runtime type of object is known      | 1.   Exact Runtime type of object is not known
*   2. we can use both child class and      | 2.   We can use only parent class methods
*       parent class methods                |
*   3. Here we can hold child object of     | 3.   Here we can hold child object of any type
*       particular type (ArrayList Only)    |      in parent object (ex List can hold ArrayList
*                                           |       LinkedList etc)
*
* */