package com.compjava;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PQueues {
    private void maxHeapOneD(int[] arr){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            //Default is min heap (Number 1 - Number 2) <-- Increasing Order
            //If We reverse Order (Number 2 - Number 1) <-- Decreasing Order
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

    private void minHeapByFrequency(int[] arr){
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int n : arr)
            count.put(n, count.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer number1, Integer number2) {
                return count.get(number1) - count.get(number2);
            }
        });

        priorityQueue.addAll(count.keySet());

        while (!priorityQueue.isEmpty()){
            int  i = priorityQueue.poll();
            System.out.print(i +" Freq --> ");
            System.out.print(count.get(i) + " || ");
        }
        System.out.println();
    }

    private void maxHeapByFrequency(int[] arr){
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int n : arr)
            count.put(n, count.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer number1, Integer number2) {
                return count.get(number2) - count.get(number1);
            }
        });

        priorityQueue.addAll(count.keySet());

        while (!priorityQueue.isEmpty()){
            int  i = priorityQueue.poll();
            System.out.print(i +" Freq --> ");
            System.out.print(count.get(i) + " || ");
        }
        System.out.println();
    }

    private void minHeap2DZeroCol(int[][] input){
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        priorityQueue.addAll(Arrays.asList(input));
        while (!priorityQueue.isEmpty()){
            int[] out = priorityQueue.poll();
            System.out.println("0th Val -> " + out[0] + " 1st Val -> " + out[1]);
        }
    }

    private void maxHeap2DFirstCol(int[][] input){
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        priorityQueue.addAll(Arrays.asList(input));
        while (!priorityQueue.isEmpty()){
            int[] out = priorityQueue.poll();
            System.out.println("0th Val -> " + out[0] + " 1st Val -> " + out[1]);
        }
    }

    public static void main(String[] args) {
        PQueues obj = new PQueues();
        int[] inMinHeap = {3, 2, 1, 5, 6, 4};
        System.out.println("Input --> 3, 2, 1, 5, 6, 4");
        obj.minHeapOneD(inMinHeap);

        int[] inMaxHeap = {3, 2, 1, 5, 6, 4};
        System.out.println("Input --> 3, 2, 1, 5, 6, 4");
        obj.maxHeapOneD(inMaxHeap);

        int[] inMinHeapFreq = {1, 1, 1, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 8, 8, 9};
        System.out.println("Input --> 1, 1, 1, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 8, 8, 9");
        obj.minHeapByFrequency(inMinHeapFreq);

        int[] inMaxHeapFreq = {1, 1, 1, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 8, 8, 9};
        System.out.println("Input --> 1, 1, 1, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 8, 8, 9");
        obj.maxHeapByFrequency(inMinHeapFreq);

        int[][] intervalsZeroCol = {
                {5, 10},
                {4, 11},
                {2, 9},
                {3, 12},
                {6, 14}
        };
        System.out.println("{5, 10}, {4, 11}, {2, 9}, {3, 12}, {6, 14}" );
        obj.minHeap2DZeroCol(intervalsZeroCol);

        int[][] intervalsFirstCol = {
                {5, 10},
                {4, 11},
                {2, 9},
                {3, 12},
                {6, 14}
        };
        System.out.println("{5, 10}, {4, 11}, {2, 9}, {3, 12}, {6, 14}" );
        obj.maxHeap2DFirstCol(intervalsFirstCol);
    }
}
