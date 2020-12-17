package com.compjava;

/**
 *
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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.util.Arrays;

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
        //obj.arithmeticError();
        //Customized Message
        //obj.customizedExceptions();

        obj.topTenExceptions();
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
    /*
    * ********************** Multi Catch Block **********************
    * Until 1.6V separate catch blocks used to each exception type
    * From 1.7V onwards we can have multiple exceptions merged in
    * single catch block (separated by or (|) sign)
    *
    * In Multi Catch Block, Exceptions should not have relations for
    * Either Parent to Child or Child to Parent
    * Else we will get Compile Time Error!
    * Example - ArithmeticException is Child and Exception is Parent
    *           If both will be there in Multi Catch Block, Compile
    *           Time Error will occur!
    *
    * */
    public void multiCatchBlock(){
        try {
            int i = 10 / 0;
            FileReader reader = new FileReader("some_file.txt");
            String s = null;
            System.out.println(s.length());
        }catch (ArithmeticException | IOException | NullPointerException e){
            e.getMessage();
        }
    }

    //Custom Exceptions
    public void customizedExceptions(){
        throw new CustomExceptionClass("Message From Custom Exception Class");
    }


    /*
    *  ******************************** Top 10 Exceptions *********************************
    *       1.  ArrayIndexOutOfBoundsException          |   Raised automatically by
    *       2.  NullPointerException                    |   JVM and hence these are
    *       3.  ClassCastException                      |   JVM exceptions
    *       4.  StackOverflowError                      |
    *       5.  NoClassDefFoundError                    |
    *       6.  ExceptionInInitializerError             |
    *       -------------------------------------------------------------------------------
    *       7.  IllegalArgumentException                |   Raised explicitly by programmer
    *       8.  NumberFormatException                   |   (or) by API developer. These
    *       9.  IllegalStateException                   |   are programatic Exceptions
    *       10  AssertionError                          |
    *
    *       IllegalArgumentException: this will be raised when passed argument is not a
    *           legal argument for the method. Say Thread priority values is passed 15,
    *           but accepted values for thread priority is between 1 and 10, so
    *           IllegalArgumentException is raised!
    *
    *       NumberFormatException: this is part (child) of IllegalArgumentException. this
    *           is raised when number formatting failed. Example Integer i = Integer.parseInt("10")
    *           is valid but if we try to convert ten to integer, NumberFormatException is
    *           raised --> Integer i = Integer.parseInt("ten")
    *
    *       IllegalStateException : suppose we started a thread t (t.start()) and if thread is
    *           in running state and we try to start again the same thread t. we will get
    *           IllegalStateException.
    *
    *
    * */
    private void topTenExceptions(){
        //1. ArrayIndexOutOfBoundsException
        int[] arr = new int[5];
        Arrays.fill(arr, 1);
        for(int i = 0; i <=arr.length; i++){
            if(i >= 5){
                //ArrayIndexOutOfBoundsException will be raised by JVM;
            }
        }

        //2. NullPointerException
        String s = null;
        //Since s is null if we try to access or operate on string
        //NullPointerException is raised by JVM
        System.out.println(s.charAt(0));

        Object o = new Object();
        //Following code trying to case object (upper/parent) to
        // String, JVM will raise ClassCastException
        String s1 = (String)o;

        //ExceptionInInitializerError > it will be raised with static assignments
        //or static blocks


    }
    /*
    * ******************** try with Resources ***********************************
    * Until v1.6 if we were reading file using Buffer reader,
    * we were using finally block to close the buffer reader,
    * if not null/closed! it was highly recommended until 1.6
    * version to close resources which are open
    *
    * In v1.7 onwards, we have option to put resources like buffer reader
    * in try condition and buffer reader will be closed automatically
    * at the end of try block
    *
    * Until 1.6V finally / catch block was mandatory with try block
    * but with 1.7V onward, try block can exist in code (with resources)
    * alone!
    *
    * */

    public void tryEnhancements() throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("some_file.txt"));
            System.out.println(bufferedReader.read());
        }catch (IOException e){
            e.getMessage();
        }finally {
            if(bufferedReader != null){
                bufferedReader.close();
            }
        }
    }
    public void tryEnhancementsWithResources(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("some_file.txt"))) {
        } catch (IOException e) {
            e.getMessage();
        }
    }
    //Try block without catch or finally
    public void onlyTryEnhancementsWithResources() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("some_file.txt")))
            {
                System.out.println();
            }
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
