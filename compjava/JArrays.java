package com.compjava;
/*
@author : Parveen Kumar
*/
import java.util.Arrays;
import java.util.Comparator;

public class JArrays {
    private void prepareMaxArray(int size){
        int[][] arr = new int[size][size];
        for(int[] a : arr)
            Arrays.fill(a, Integer.MAX_VALUE);

        for(int[] a : arr){
            for (int value : a) {
                System.out.print(value + "<->");
            }
            System.out.println();
        }
    }
    private void prepareMinArray(int size){
        int[][] arr = new int[size][size];
        for(int[] a : arr)
            Arrays.fill(a, Integer.MIN_VALUE);

        for(int[] a : arr){
            for (int value : a) {
                System.out.print(value + "<->");
            }
            System.out.println();
        }
    }
    private void sortArrayRowsASC(int[][] output){
        Arrays.sort(output, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for(int[] arr : output){
            System.out.println("{" + arr[0] + " ," + arr[1] + "}");
        }

    }
    private void sortArrayRowsASCLB(int[][] output){
        //Using Lambda Function
        Arrays.sort(output, (a, b) -> a[1] - b[1]);
        for(int[] arr : output){
            System.out.println("{" + arr[0] + " ," + arr[1] + "}");
        }
    }
    private void sortArrayRowsDSC(int[][] output){
        Arrays.sort(output, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        for(int[] arr : output){
            System.out.println("{" + arr[0] + " ," + arr[1] + "}");
        }
    }
    private void sortArrayRowsDESCLB(int[][] output){
        Arrays.sort(output, (a, b) -> b[1] - a[1]);
        for(int[] arr : output){
            System.out.println("{" + arr[0] + " ," + arr[1] + "}");
        }
    }
    private void findIndexByValues(int[][] matrix, int val){
        int m = matrix.length, n = matrix[0].length;
        int row = 0;
        int col = 0;
        int left = 0;
        int right = m * n - 1;
        int pivot;
        System.out.println("Right " + right);
        while (left <= right){
            pivot = (left + right) / 2;
            row = pivot / n;
            col = pivot % n;
            if(matrix[row][col] == val){
                System.out.println("Value to Find - " + val);
                System.out.print("Row - " + row + " Col - " + col);
                break;
            }else {
                if(val < matrix[row][col]){
                    right = pivot - 1;
                }else {
                    left = pivot + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        JArrays obj = new JArrays();
        //MAX VAL Matrix
        obj.prepareMaxArray(5);
        obj.prepareMinArray(5);
        //Sort Array by 0th Column Values
        int[][] inputArr = {
                {1, 3},
                {2, 6},
                {8, 11},
                {5, 12},
                {15, 18}
        };
        System.out.println("{1, 3},\n" +
                "{2, 6},\n" +
                "{8, 11},\n" +
                "{5, 12},\n" +
                "{15, 18}");
        System.out.println("Sorted Array ASC by first Column");
        obj.sortArrayRowsASC(inputArr);
        obj.sortArrayRowsASCLB(inputArr);
        int[][] inputArrDESC = {
                {1, 3},
                {2, 6},
                {8, 11},
                {5, 12},
                {15, 18}
        };
        System.out.println("-----------------------");
        System.out.println("{1, 3},\n" +
                "{2, 6},\n" +
                "{8, 11},\n" +
                "{5, 12 },\n" +
                "{15, 18}");
        System.out.println("Sorted Array DESC by first Column");
        obj.sortArrayRowsDSC(inputArrDESC);
        obj.sortArrayRowsDESCLB(inputArrDESC);

        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int val = 30;
        obj.findIndexByValues(matrix, val);

    }
}
