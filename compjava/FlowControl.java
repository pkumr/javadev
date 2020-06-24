package com.compjava;
/*
* @author Parveen Kumar
* Flow Control
*
* */
public class FlowControl {
    /*
    * Selection Statements
    *   1. if else
    *   2. switch()
    *
    * */
    private void selectionStatements(){
        //***************** if else ********************
        //***************** 7 SCENARIOS ****************
        //Argument for if statement should be boolean type
        //Any other type throws compile time error
        boolean b = false;
        if(b){
            System.out.println("b is false");
        }else {
            System.out.println("b is true");
        }

        //SCENARIO #1
        //if we have x = 0, and we have it in if condition
        //it will work in c++ but in java it will fail
        int x = 0;
        /*
        if(x){ //<-- Error: java: incompatible types: int cannot be converted to boolean

        }
        */
        //SCENARIO #2 (boolean and int ==> assignment operator)
        boolean ba = true;
        if(ba = false){
            System.out.println("No Error!");
        }

        int xa = 10;
        /*
        if(xa = 20){ //Comiple time error <--incompatible types: int cannot be converted to boolean

        }
         */
        //SCENARIO #3 (boolean and int ==> comparison operator)
        boolean bb = false;
        int xb = 10;
        if(bb == false){
            System.out.println("No Error");
        }
        if(xb == 10){
            System.out.println("No Error");
        }

        //SCENARIO #4 (no curly brackets)
        if(true)
            System.out.println("No Brackets");

        //SCENARIO #5 (Valid Statement -- No output)
        if(true);

        //SCENARIO #6 (Compile Time Error - No brackets)
        //Error java: variable declaration not allowed here
        /*
        if(true)
            int x = 10;
         */

        //SCENARIO #7 (Dangling Else - JAVA has no dangling else problem)
        //else is related to nearest if
        if(true)
            if(true)
                System.out.println("No Error");
            else
                System.out.println("Related to Internal/Nearest Else");


        //************************* switch() ****************************
        //********** switch is basically handles nested if else *********
        //************** 7 SCENARIOS  ***********************************
        /*
        * switch(variable <--type)
        *   case 1:
        *       Action 1
        *       break;
        *   case 2:
        *       Action 2
        *       break;
        *   .
        *   .
        *   .
        *   .
        *   default:
        *       default Action
        *
        * Variable in switch statement
        *   Allowed Types: (by Java Version)
        *       1.4V    |   1.5 V           |   1.7 V
        *    Primitive  | Wrapper Classes   |   Additional Class
        *       byte    | Byte              |   String
        *       short   | Short             |
        *       char    | Character         |
        *       int     | Integer           |
        *               | enum              |
        *
        *  Note :   Apart from primitive types and their wrapper classes
        *           String type and enum types are also allowed
        *
        *   All other not allowed:
        *       boolean, long, float, double <-- compile time error
        *
        * Conclusions :
        *       1. curly braces are always required in switch, in cases it is optional
        *
        * `*/
        int sx = 5;
        switch (sx){
            case 1: {
                System.out.println("Mon");
                break;
            }
            case 2:
                System.out.println("Tue");
                break;
            case 3:
                System.out.println("Wed");
                break;
            case 4:
                System.out.println("Thu");
                break;
            case 5:
                System.out.println("Fri");
                break;
            default:
                System.out.println("Sun");
        }

        //SCENARIO #1
        switch (sx){
            //Valid Syntax without any case or default
        }
        switch (sx){
            /*
            System.out.println("Compile Time Error");
            */
            //Error: java: case, default, or '}' expected (Nine Times)
            //Independent statements are not allowed
        }
        switch (sx){

        }
        //SCENARIO #2
        switch (sx){
            default:
                System.out.println("Only default is allowed");
        }
        //SCENARIO #3
        switch (sx){
            case 1:
                System.out.println("Only one case also work without default");
        }

        //SCENARIO #4
        int sy = 10;
        int sz = 20;
        final int sf= 30;
        switch (x){
            case 10:
                System.out.println("Valid");
                break;
                /*
            case sz:
                System.out.println("Invalid");
                //Error: java: constant expression required
                 */
            case sf:
                System.out.println("Valid as sf is constant");
                break;
        }

        //SCENARIO #5
        switch (sx + 1){
            //Valid
        }
        //SCENARIO #6
        int ci = 10;
        switch (ci){
            //case 97:
            case 99:
                System.out.println("Check1");
            case 'a':
                System.out.println("Duplicate case label with 97 already a case");
        }
        //SCENARIO #7
        //Fall through inside switch
        //if sx matches 1, it will keep executing all other down 1 until
        //break happen
        switch (sx){
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
                break;
        }

        //SCENARIO #8
        //Default should at the end of all cases (Recommended)
        //For Example - below, if sx is not 1, it will execute
        //default and then Case 1 too because of switch fall through
        
        switch (sx){
            default:
                System.out.println("def");
            case 1:
                System.out.println(1);

        }
    }
    /*
    * Iterative Statements
    *   1. while()
    *   2. do while()
    *   3. for()
    *   4. for each loop (1.5version)
    *
    * */
    private void iterativeStatements(){

    }
    /*
    * Transfer Statements
    *   1. break
    *   2. continue
    *   3. return
    *   4. try catch finally
    *   5. assert
    *
    * */
    private void transferStatements(){

    }
    public static void main(String[] args) {

    }
}
