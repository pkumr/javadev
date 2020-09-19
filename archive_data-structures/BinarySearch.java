package com.datastructures;

public class BinarySearch {
	public static void main(String[] args){
		int arr[] = {2, 5, 6, 8, 10, 15, 22, 29, 33, 49, 50};
		int key = 15;
		int result = new BinarySearch().binarySearch(arr, key);
		System.out.println(result); // this will print index of 15 i.e. --> 5
		//if 15 was not found in arr, -1 is returned.
	}
	/*
	* Binary Search in one dimensional array
	* Binary Search can be done when input array is sorted.
	* In this particular program, it is assumed that input array is sorted in ascending order.
	* Time Complexity of Binary Search - O(logN)
	*/

	//arr --> input sorted array,
	//key --> value to be searched in arr
	//return --> (int) index of key in arr. if not found return -1
	public int binarySearch(int[] arr, int key){
		//Starting index of array -->left
		int left = 0;
		//Last index in input array arr --> right
		int right = arr.length - 1;

		while (left <= right) {
			//index of middle element in array --> mid
			int mid = (left + right) / 2;

			if(arr[mid] == key)
				return mid;

			//Check if key (value to search) is greater than value at mid
			//if key > arr[mid] --> this implies key can be found to the right of middle element
			//(it is assumed here array is sorted in ascending order)
			if(key > arr[mid]){
				//shift starting index to one right of middle element, left = mid + 1
				left = mid + 1;
			}else{
				//key < arr[mid] (here key <= arr[mid],because that would have returned in arr[mid] = key)
				//this implies (key < arr[mid] --> that key can be found to left of middle element)
				//Shift end index (right) to one left of middle element
				right = mid - 1;
			}
		}
		//return - 1 is key not found in arr.
		return -1;
	}
}