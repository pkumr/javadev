package com.compjava;

/*
* @author : Parveen Kumar
*
*   1.  Introduction
*   2.  Runtime stack mechanism
*   3.  Default exception handling in java
*   4.  Exception Hierarchy
*   5.  Customized exception handling by using try catch
*   6.  Control flow in try catch
*   7.  Methods to print exception information
*   8.  try with multiple catch blocks
*   9.  finally block
*   10. difference between final, finally, finalize
*   11. control flow in try-catch-finally
*   12. control flow in nested try-catch-finally
*   13. various possible combinations of try catch finally
*   14. throw keyword
*   15. throws keyword
*   16. Exception handling keywords summary
*   17. Various possible compile time errors in exception handling
*   18. Customized or user defined exceptions
*   19. Top -10 exceptions
*   20. 1.7 version enhancements
*           1.  try with resources.
*           2.  multi-catch block
*
* */

import java.io.FileNotFoundException;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/*
*
* Exception - An unwanted event that disrupts the normal flow of program is Exceptions.
* Parent Class for Exception is Throwable
* Types of Exceptions in JAVA :
*       1.  Checked -- compile time
*       2.  Unchecked -- usually runtime
*       3.  Partially check (Throwable & Exception)
*       4.  Fully checked
*
* Behavior of Following Exception
*   IOException                     Checked --> Fully Checked
*   RuntimeException                Unchecked
*   InterruptedException            Checked --> Fully Checked
*   Error                           Unchecked
*   Throwable                       Checked (Partially Checked)
*   ArithmeticException             Unchecked
*   NullPointerException            Unchecked
*   Exception                       Checked (Partially Checked)
*   FileNotFoundException           Checked --> Fully Checked
*
*
* */
public class JExceptions {
    public static void main(String[] args) {
        JExceptions obj = new JExceptions();
        ////Arithmetic Exception (Divide by 0)
        obj.arithmeticError();
        //Customized Message
        obj.customizedExceptions();
    }
    //Arithmetic Exception
    private void arithmeticError(){
        try {
            //Divide by 0 Exception
            int i = 10/0;
        }catch (ArithmeticException e){
            //Complete Info - printStackTrace
            //internally default exception handler will use
            //printStackTrace method to print exception information
            //to console
            e.printStackTrace();
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }
    /*
    * **************************** Definitions ***********************************
    * try       --> to maintain code that can fail
    * catch     --> to maintain exception handling code
    * finally   --> to maintain clean up code
    * throw     --> to handover our created exception object to JVM manually
    * throws    --> to delegate responsibility of exception handling to the caller
    *
    *
    * */
    //Exception Handling - best practice
    private void exceptionBestPractice(){
        try {
            /*
             * Suppose we have some code and following
             * exception can occur in code, so we should
             * have separate blocks for Exception Type
             *   a) Arithmetic Exception
             *   b) SQL Exception
             *   c) FileNotFoundException
             *   d) Default Exception
             *
             * For Every exception, it is recommended to take
             * separate catch block.
             *
             */
            System.out.println("Exception Handling Practice");

        }catch (ArithmeticException e){
            System.out.println("Exception Handling Practice");
        }/*catch (SQLException sqlException){
            System.out.println("Exception Handling Practice");
        }
        catch (FileNotFoundException fileNotFoundException){
            System.out.println("Exception Handling Practice");
        }*/catch (Exception exception){
            System.out.println("Exception Handling Practice");
        }
    }
    public void customizedExceptions(){
        throw new CustomExceptionClass("Message From Custom Exception Class");
    }
}
//Custom Exception Classes
class CustomExceptionClass extends RuntimeException{
    public CustomExceptionClass(String s){
        super(s);
    }
    @Override
    public String getMessage(){
        return "Failed Message from Customized Exception Class";
    }
}
