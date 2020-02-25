/**
 * Author: David Zhou
 * ClassID: 345
 * Assignment 1
 * Description: The SimpleList file contains the implementation
 * 				of the add, remove, count, toString, and search
 * 				methods as well as the constructor.
 */
package cse360assign2;
public class SimpleList 
{
	/** 
	 * The SimpleList class contains the default constructor and
	 * five methods to add, remove, count, return as string, and
	 * search elements in an integer array.
	 * @param list The integer array contains the numbers.
	 * @param count A variable storing how many numbers are in the array.
	 */
	private int[] list;
	private int count;
	
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
	 * @param num Number to be added to array
	 */
	public void add(int num){
		
		// first shifts the array to the right by one before adding to array
		for (int iterator = list.length - 1; iterator > 0; iterator--) {
			list[iterator] = list[iterator - 1];
		}
		list[0] = num;
		if (count < 10)	{
			count++;
		}
	}
	
	/**
	 * Method remove(int) removes all instances of the integer from the array.
	 * @param num Number to be removed from array
	 */
	public void remove(int num) {
		
		// creates a new list for storing numbers
		int[] tempList = new int[10]; 
		
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
}
