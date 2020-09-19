package com.compjava;
/**
 * @author parveenkumar
 * Flow Control
 *  1. Selection Statements
 *      a) if-else
 *      b) while
 *      c) for
 *      d) foreach
 *  2. Transfer Statements
 *      a) break
 *      b) continue
 *      c) return
 *      d) try catch finally
 *      e)  assert
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
    private void iterativeStatements() {
        boolean b = false;
        //************************ while() **********************
        //While Argument should be boolean type
        //Any other type throws compile time error
        while (b) {
            break;
        }
        //Following works in c++ (1 is true in c++) but in java it will fail
        //with Error:incompatible types: int cannot be converted to boolean
        /*
        while (1){

        }
        */
        /*
        while (true)
            System.out.println("Valid");
        */
        /*
        while (true) //In valid No Declarative statement
            int x = 10;
        */
        //while (true); //it is valid statement but Error:java: unreachable statement
        //
        while (true) {
            System.out.println("Print");
            break; //If we will not put break, the loop will print infinitely
        }
        /* This loop will never enter to body, so while(false) is invalid
                (unreachable statement)
        while (false){
            System.out.println("Print");
        }
        */

        int ia = 10, ib = 20;
        while (ia < ib) {
            //JVM considers variable and not values
            System.out.println("Infinite Loop - No compile time error ");
        }
        final int cia = 10, cib = 20;
        /*
        while (cia < cib){
            System.out.println("Loop has no issue but other statement get unreachable");
        }
         */
        /*
        while (cia > cib){
        //LOOP is INVALID
        }
        */

        //******************************** do while() ****************************************
        //to execute while loop at least once, use do while
        //semi-colon after while is must in JAVA, c++ it is not
        boolean db = false;
        do {

        } while (db);

        //SCENARIO #1
        do
            System.out.println("Without braces do while");
        while (db);

        //SCENARIO #2
        /*
        do
          int x = 10;  invalid statement
        while (db);
        */

        //SCENARIO #3
        //do while(true); <--invalid (as no body is mentioned)

        //SCENARIO #4
        /*
        do while (true)
            System.out.println("Valid Statement");
        while (false);
        */
        /********************************* for loop ************************************/
        /*
        * for(initialize (1) , condition (2) (5), increment/decrement (4) (7)){
        *       loop body (3) (6)
        * }
        *  Sequence of for loop is
        *   1. Initialization of variable (s) of same type
        *   2. condition check
        *   3. loop body
        *   4. increment / decrement
        *       (((loop body > condition > increment/decrement)))
        *
        * */
        for(int fi = 0; fi < 10; fi++){
            System.out.println();
        }
        for(int fi = 0, fj = 0; fi < 10 && fj < 10; fi++, fj++)
        {
            System.out.println("Valid ");
        }
        /*
        *
        * *********** Parts of For Loops and their properties *******************
        * for(1(any java expression); 2(boolean value); 3(any java expression)){
        * }
        *
        * */
        int i = 0;
        for(System.out.println("Hello"); i < 3; System.out.println("Hi")){
            i++;
        }
        // Above example will print -->
        // Hello
        // Hi
        // Hi
        // Hi

        /*
        * for loop <-- infinite loops if
        * we don't pass anything
        * */
        /*
        for(;;){
            System.out.println("Hello Infinite Loop");
        }
        for(;;);
        NOTE :- Infinite Loops are commented because next line of code
                become unreachable after infinite loop!
        */

        //Reverse For Loop
        for(int j = 10; j >= 0;  j--){
            System.out.println("From 10 to 0");
        }
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
    private void transferStatements() {
        /************************ break ************************/
        // break will make exit from loop, switch and labeled block
        // breaks loop execution based on condition
        // if we use break in other than loop, switch or labeled block
        // this error occur -> Error: java: break outside switch or loop
        for (int i = 0; i < 10; i++) {
            if (i == 5)
                break;
            System.out.println("for loop " + i);
        }
        System.out.println("Outside For for loop");
        int a = 10;
        while (a >= 0) {
            a--;
            System.out.println("While Loop " + a);
            if (a == 5)
                break;
        }
        System.out.println("While Loop Ends !");
        //labeled block <-- we need to mention break {name of labeled block}
        lb:
        {
            int x = 2;
            System.out.println("Begin Labeled Block");
            if (x == 2)
                break lb;
            System.out.println("Labeled Block after break");
        }
        System.out.println("Outside Labeled Block");


        /****************************** continue *****************************/
        // continue can be used inside loops to skip current iteration and continue
        // the next iteration

        //if we use continue in any place other than loop we get
        // Error java: continue outside of loop
        for (int i = 0; i < 10; i++){
            //if i is even then go to skip iteration and go to next
            //iteration, it will not print even i values
            if(i % 2 == 0)
                continue;
            System.out.println("for continue " + i);
        }
        int j = 40;
        while (j > 0){
            //keep dividing j with 2 in while loop
            j = j / 2;
            //if j is greater than 5, skip the iteration
            //it will not print any value until j becomes
            //less than equals to 5
            if(j > 5)
                continue;
            System.out.println("while continue " + j);
        }
        /*
        int c_ch = 10;
        if(c_ch == 10){
            //continue; //Error: java: continue outside of loop
        }
        */
        //********************** labeled break & continue *****************
        labelI:
        for(int I = 0; I < 10; I++){
            labelJ:
            for(int J = 0; J < 10; J++){
                //labelK:
                for(int K = 0; K < 10; K++){
                    System.out.println("I " + I + " J " + J + " K " + K);
                    //break; <-- this will break the inner loop
                    //and control goes to J
                    //break;
                    //Now if we want to break outer loop say Jth loop
                    //we use break labelJ
                    break labelJ;
                    //Same if we want to break ith loop, use Ith label
                }
            }
        }
        int aw = 10, bw = 5;
        lwa:
        while (aw > 0){
            aw--;
            lwb:
            while (bw > 0){
                bw--;
                int inner = 5;
                while (inner > 0){
                    inner--;
                    System.out.println("aw " + aw + " bw " + bw + " inner " + inner );
                    //same like break, simple continue will continue inner while
                    //loop, but if we want to continue outer loop, then we have to
                    //use label whatever outer loop we want to continue!
                    if(inner > 2)
                        continue lwb;
                }
            }
        }
        /*********************** do while() & continue ******************/
        int x = 0;
        do {
            x++;
            System.out.println("x " + x);
            //continue will go to while and not to start of the code
            //if condition in while is true, next iteration start from
            //first line after do. Following is the output of program:
            //  x 1
            //  x 4
            //  x 6
            //  x 8
            //  x 10
            if(++x < 5)
                continue;
            x++;
            System.out.println("x " +x);
        }while (++x < 10);
    }
    public static void main(String[] args) {
        FlowControl fo = new FlowControl();
        fo.transferStatements();
    }
}
