package com.compjava;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PQueues {
    private void maxHeapOneD(int[] arr){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer number1, Integer number2) {
                return number2 - number1;
            }
        });
        for(int i : arr)
            priorityQueue.add(i);
        while (!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.poll() + ", ");
        }
        System.out.println();
    }
    private void minHeapOneD(int[] arr){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer number1, Integer number2) {
                return number1 - number2;
            }
        });

        for(int i : arr)
            priorityQueue.add(i);

        while (!priorityQueue.isEmpty()){
                System.out.print(priorityQueue.poll() +", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PQueues obj = new PQueues();
        int[] inMinHeap = {3, 2, 1, 5, 6, 4};
        System.out.println("Input --> 3, 2, 1, 5, 6, 4");
        obj.minHeapOneD(inMinHeap);

        int[] inMaxHeap = {3, 2, 1, 5, 6, 4};
        System.out.println("Input --> 3, 2, 1, 5, 6, 4");
        obj.maxHeapOneD(inMaxHeap);
    }
}
