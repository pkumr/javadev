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

import sun.awt.windows.ThemeReader;

/**
 * ****************** Thread Class Constructors *************
 * 1.   Thread t = new Thread();
 * 2.   Thread t = new Thread(Runnable r);
 * 3.   Thread t = new Thread(String name);
 * 4.   Thread t = new Thread(Runnable r, String name);
 * 5.   Thread t = new Thread(ThreadGroup g, String name);
 * 6.   Thread t = new Thread(ThreadGroup g, Runnable r);
 * 7.   Thread t = new Thread(ThreadGroup g, Runnable r, String name);
 * 8.   Thread t = new Thread(ThreadGroup g, Runnable r, String name, long stackSize);
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

        /**
         * Every Thread has name in Java, we can set and get names of thread in Java
         * thread.getName()
         * thread.setName()
         *
         * */
        System.out.println("Current Thread Name : - " + Thread.currentThread().getName()); //Print main
        Thread.currentThread().setName("My Thread"); //set name of thread to My Thread
        System.out.println("Current Thread Name : - " + Thread.currentThread().getName()); //Print My Thread
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

        //***************** Using Runnable Interface *****************
        //It is recommended to use Runnable Interface to create threads
        //rather than extending Thread Class
        //One reason would be with Runnable Interface, we can extend
        //another class, but if we already extended Thread, then there
        //no chance of extending any other class!

        MyRunnable myRunnable = new MyRunnable();
        //Create Thread and Pass Target Runnable to the Thread
        Thread threadRunnable = new Thread(myRunnable);
        threadRunnable.start();

        /*
        * ******************** Thread Priority ***********************
        * Default Priority of main thread is 5
        *
        * Priority of Thread can be set between 1 and 10. if we try to set
        * less than 1 or greater than 10, we will get IllegalArgumentException
        *
        * */
        System.out.println("Thread Priority - " + Thread.currentThread().getPriority()); //prints --> 5
        MyThreadPriority threadPriority = new MyThreadPriority();
        threadPriority.setPriority(10);
        threadPriority.start();
        //Since Priority of Main is 5 and we set the priority of Child to
        //10, first we get output from below for loop and then output
        //from the run method of child thread!
        for(int i = 0; i < 5; i++){
            System.out.println("Main Thread (Thread Priority )");
        }

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
/**
 * ****************** Using Runnable Interface ***********************
 * Runnable Interface contains only run() method
* */
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 5; i++)
            System.out.println("Thread Run Method ~ Runnable Interface");
    }
}
/**
 * **************************** Thread Priority *****************************
 *
 */
class MyThreadPriority extends Thread{
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Child Thread (Thread Priority Case)");
        }
    }
}

/**
 * *********************** yield() | join() | sleep() **********************
 * -------------------------- yield() --------------------------------------
 * yield method causes to pause current executing thread to give
 * the chance for waiting threads of same priority. if there is no waiting
 * thread, or all waiting threads have low priority then same thread can
 * continue its execution.
 * if all waiting threads have same priority, then which thread can get chance
 * cannot be determined, it depends on Thread Scheduler.
 *
 * Some platform (OS) won't provide support for (Preemptive Scheduling), then
 * yield() method will not work as expected!
 *
 * 1. Preemptive Scheduling:
 * Preemptive scheduling is used when a process switches from running state
 * to ready state or from waiting state to ready state. The resources
 * (mainly CPU cycles) are allocated to the process for the limited amount
 * of time and then is taken away, and the process is again placed back
 * in the ready queue if that process still has CPU burst time remaining.
 * That process stays in ready queue till it gets next chance to execute.
 *
 * 2. Non-Preemptive Scheduling:
 * Non-preemptive Scheduling is used when a process terminates, or a process
 * switches from running to waiting state. In this scheduling, once the resources
 * (CPU cycles) is allocated to a process, the process holds the CPU till it
 * gets terminated or it reaches a waiting state. In case of non-preemptive
 * scheduling does not interrupt a process running CPU in middle of the execution.
 * Instead, it waits till the process complete its CPU burst time and then it
 * can allocate the CPU to another process.
 *
 * --------------------------  join()  --------------------------------------
 * If a thread needs to wait until other thread completes, then we can go for
 * join() method. If a thread t1 should wait until thread t2 completes, then
 * t2.join() will perform the operation.
 *
 * public final void join()
 * public final void join(long milliseconds)
 * public final void join(long milliseconds, int nanoseconds)
 *
 *
 * */
class MyThreadYield extends Thread{
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Yield Child Thread");
            Thread.yield();
        }
    }
}