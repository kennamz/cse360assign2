//Name: Kenna Zimmerman
//Class ID: 377
//Assignment 2

//This file is an implementation of a simple list built with an array.
//Methods:
//	SimpleList() - constructor
//	add(parameter) - adds parameter to the beginning of list
//	remove(parameter) - removes parameter if it exists
//	count() - returns the number of elements in the list
//	toString() - returns a string of all the elements in list
//	search(parameter) - returns the index of parameter, or -1 if not found 
//	append(parameter) - adds parameter to the end of list
//	first() - returns the first element of the list
//	size() - returns the current capacity of the list


package cse360assign2;
import java.util.Arrays; 

public class SimpleList {

	private int[] list;
	private int count;
	private int size;
	
	public SimpleList() {
	//Create an array to hold 10 integers and set count to 0
		list = new int[10];
		count = 0;
		size = 10;
	}
	
	public void add(int parameter) {
	//Add the parameter to the list at the beginning. Move all the other 
	//integers in the list over so there is room. If the list was full,
	//then increase the size by 50% so there will be room. Increment the count.
		if (count == size) {
			size = (int)(size * 1.5);
			list = Arrays.copyOf(list, size);
		}
		for (int iterator = count - 1; iterator >= 0; iterator--) {
			list[iterator + 1] = list[iterator];
		}
		list[0] = parameter;
		count++;
		return;
	}
	
	public void remove(int parameter) {
	//If the parameter is in the list, then remove it. The other values in the
	//list may need to be moved down. Adjust the count as needed.  If the
	//list has more than 25% empty places, the decrease the size of the list.
		int index = this.search(parameter);
		if (index != -1) {
			for (int iterator = index; iterator < count - 1; iterator++) {
				list[iterator] = list[iterator + 1];
			}
			count--;
		}
		if (count <= 0.75 * size) {
			size = (int)(size * 0.75);
			list = Arrays.copyOf(list, size);
		}
		return;
	}
	
	public int count() {
	//Return the number of elements stored in the list.
		return count;
	}
	
	public String toString() {
	//Return the list as a String. The elements must be separated by a
	//space. This means there is not space after the last integer.
		String str = "";
		for (int iterator = 0; iterator < count; iterator++) {
		//iterate through list and add each element to str
			
			str += list[iterator];
			
			if (iterator + 1 != count) {
			//if list[iterator] is not the last element, append a space to str
				str += " ";
			}
		}
		return str;
	}
	
	public int search(int parameter) {
	//Return the location of the parameter in the list. If the parameter is not
	//in the list, then return -1.
		int index = -1;
		int iterator = 0;
		while (iterator < count && index == -1) { 
		//iterate through list until end of list is reached or element is found
			
			if (list[iterator] == parameter) {
				index = iterator;
			}
			
			iterator++;
		}
		return index;
	}
	
	public void append(int parameter) {
	//append the parameter to the end of the list. If the list was full, 
	//then increase the size by 50% so there will be room. Increment the count.
		if (count == size) {
			size = (int)(size * 1.5);
			list = Arrays.copyOf(list, size);
		}
		list[count] = parameter;
		count++;
		return;
	}
	
	public int first() {
	//Return the first element in the list
		return list[0];
	}
	
	public int size() {
	//Return the current number of possible locations in the list
		return size;
	}

}
