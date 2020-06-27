package com.compjava;
/*
* @author : Parveen Kumar
* OOPS
*
* */
public class JBasicOOPs {

}
/*
 * HAS - A relation
 * Let's have a class Person. the class person has name and age
 * properties. then class Person HAS A relation with name and
 * age
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