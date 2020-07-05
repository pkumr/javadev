package com.compjava;
/**
 * @author parveenkumar
 *
 *    1.  Introduction
 *    2.  The ways to define a Thread
 *        a)  By Extending Thread Class
 *        b)  By Implementing Runnable Interface
 *    3.  Getting and Setting Name of Thread
 *    4.  Thread Priorities
 *    5.  The methods to prevent Thread Exection
 *            a)  yield()
 *            b)  join()
 *            c)  sleep()
 *    6.  Synchronization
 *    7.  InterThread Communication
 *    8.  Deadlocks
 *    9.  Daemon Threads
 *    10. Multithreading concepts
* */

/**
 * ****************** Thread Life Cycle *********************
 *  1.  Thread t = new Thread()  -->                    New/Born
 *  2.  t.start() -->                                   Ready/Runnable
 *  3.  If Thread Scheduler allocates processor(run)    Running
 *  4.  Once run() method completes                     Dead
 *
* */

/*
**************************   Multitasking ****************************************
*   Executing several tasks simultaneously is multitasking
*   1.  Process Based - Executing several tasks simultaneously where each task
*                       is separate independent process
*           Example : while typing in editor, we can listen audio files from the
*                     same system. we can download a file from net at same time.
*                     All these tasks can be done independently.
*   2.  Thread Based - Executing several tasks simultaneously where each task
*                      is separate independent part/path of the same program.
*                      Each independent task is called thread
*
*
* */
public class JMultiThreading {
    public static void main(String[] args) {
        MyThread t = new MyThread(); //Thread Initialization
        t.start(); //start the thread

        //t.start(); //java.lang.IllegalThreadStateException, if we try to start the same
                   // thread again

        /*
        * Difference between start() and run()
        * thread.run() --> run() method is executed like normal method.
        * thread.start() --> start() method will create a new thread that
        *                    will execute run() method!
        * Steps in start() method -->
        *   a)  Register the thread with Thread Scheduler
        *   b)  Perform all other mandatory activities
        *   c)  Invoke run() method!
        *
        * Overloading of run() method is always possible but
        * start() --> will call run() (no-arg) method!
        *
        *
        * */
        MyThreadTwo threadTwo = new MyThreadTwo();
        threadTwo.start();
    }
}
//Defining a Thread
class MyThread extends Thread{
    /**
     * It is highly recommended to override run() method! else
     * we don't have to use multithreading!
     */
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("Child Thread " + i);
        }
    }
    //int arg method
    public void run(int i){

    }
}
class MyThreadTwo extends Thread{
    @Override
    public void run() {
        System.out.println("Run Method");
    }
    /**
     * If we override start method, it will act as regular method
     * (new thread won't be created). Therefore, it will not initiate
     * a thread and run() will not be executed!
     *
     * It is NOT recommended to override start method! it contradicts
     * multithreading flow!
     */
    @Override
    public void start(){
        //if we call super.start() here, then run will be executed
        super.start();
        System.out.println("Start Method");
    }
}
