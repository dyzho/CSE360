/**
 * Author: David Zhou
 * ClassID: 345
 * Assignment 2
 * Description: The SimpleList file contains the implementation
 * 				of the add, remove, count, toString, search, append,
 * 				first, last, and size methods as well as the 
 * 				constructor.
 */
package cse360assign2;

import java.util.Arrays;

public class SimpleList 
{
	/** 
	 * The SimpleList class contains the default constructor and
	 * five methods to add, remove, count, return as string, and
	 * search elements in an integer array.
	 * @param list The integer array contains the numbers.
	 * @param count A variable storing how many numbers are in array.
	 * @param maxLength A variable storing the max size of array.
	 */
	private int[] list;
	private int count;
	private int maxLength = 10;
	
	/**
	 * SimpleList constructor initializes list as a blank array and
	 * the variable "count" to 0.
	 */
	public SimpleList() {

		list = new int[10];
		count = 0;
	}

	/**
	 * Method add(int) adds the integer to the beginning of the array.
	 * The array size increases by 50% if it is too small.
	 * @param num Number to be added to array
	 */
	public void add(int num){
		
		if (count == maxLength) {
			if (maxLength == 1) {
				list = Arrays.copyOf(list, 2);
				maxLength = 2;
			}
			else {
				list = Arrays.copyOf(list, (int) (maxLength * 1.5));
				maxLength = (int) (maxLength * 1.5);
			}
		}
		
		// first shifts the array to the right by one before adding to array
		for (int iterator = list.length - 1; iterator > 0; iterator--) {
			list[iterator] = list[iterator - 1];
		}
		list[0] = num;
		count++;
	}
	
	/**
	 * Method remove(int) removes the first instance of the integer.
	 * The array is resized if more than 25% is unfilled.
	 * @param num Number to be removed from array
	 */
	public void remove(int num) {
		
		// creates a new list for storing numbers
		int[] tempList = new int[maxLength]; 
		
		int iteratorTempList = 0;
		boolean found = false;
		for (int iterator = 0; iterator < list.length; iterator++) {
			
			// copies number if it does not match the parameter
			// or if a number was already deleted
			if (num != list[iterator] || found) { 
				tempList[iteratorTempList] = list[iterator];
				iteratorTempList++;
			}
			else {
				found = true;
				count--;
			}
		}
		list = tempList;
		if (count < (int) (0.75 * maxLength) && maxLength != 1){

			list = Arrays.copyOf(list, (int) (maxLength * 0.75));
			maxLength = (int) (0.75 * maxLength);
		}
		
	}
	
	/**
	 * Method count() returns the number of elements currently in the array.
	 * @return The number of elements currently in the array.
	 */
	public int count() {
		return count;
	}
	
	/**
	 * Method toString() returns the numbers in the array as a string.
	 * @return listNum The string containing the numbers in the array.
	 */
	public String toString() {
		String listString = "";

		if (count > 0) {
			for(int iterator = 0; iterator < count - 1; iterator++){
				listString = listString + list[iterator] + " ";
			}
			listString = listString + list[count - 1]; // adds the last number
												   // without a space after it
		}
		
		return listString;
	}
	
	/**
	 * Method search(int) searches the array to see if the number exists
	 * and returns its index if it is found.
	 * @param num The number to be searched for within the array
	 * @return The index of the number that was found (or -1) if not found
	 */
	public int search(int num) {
		int index = -1;
		for (int iterator = 0; iterator < count; iterator++) {
			if (index == -1) {
				if (num == list[iterator]) {     // if found
					index = iterator;
				}
			}
		}
		return index;
	}
	
	/**
	 * Method append(int) adds a number to the end of the array,
	 * increasing the size of the array by 50% if necessary.
	 * @param num The number to be added at the end of the array
	 */
	public void append(int num) {
		
		if (count == maxLength) {
			if (maxLength == 1) {
				list = Arrays.copyOf(list, 2);
				maxLength = 2;
			}
			else {
				list = Arrays.copyOf(list, (int) (maxLength * 1.5));
				maxLength = (int) (maxLength * 1.5);
			}
		}
		list[count] = num;
		count++;
	}
	
	/**
	 * Method first() returns the number at the first index
	 * of the array.
	 * @return The number at the first index
	 */
	public int first() {
		if (count > 0) {
			return list[0];
		}
		else {
			return -1;
		}
	}
	
	/**
	 * Method last() returns the number at the last filled
	 * index of the array.
	 * @return The number at the last filled index
	 */
	public int last() {
		if (count > 0) {
			return list[count - 1];
		}
		else {
			return -1;
		}
	}
	
	/**
	 * Method size() returns the maximum number of numbers able
	 * to be stored in the array at its current size.
	 * @return the current length of the array
	 */
	public int size() {
		return maxLength;
	}
}
