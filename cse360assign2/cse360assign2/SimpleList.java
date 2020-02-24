package cse360assign2;

public class SimpleList {

	private int[] list;
	private int count;
	
	public SimpleList() {
	//Create an array to hold 10 integers and set count to 0
		list = new int[10];
		count = 0;
	}
	
	public void add(int parameter) {
	//Add the parameter to the list at the beginning. Move all the other 
	//integers in the list over so there is room. If the list was full, 
	//then the last element	“falls off” the list. Increment the count as needed.
		if (count == 10) {
		//allows the following for loop to write over the last element if the list is 
		//full, making it "fall off". 
			count--;
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
	//list may need to be moved down. Adjust the count as needed.
		int index = this.search(parameter);
		if (index != -1) {
			for (int iterator = index; iterator < count - 1; iterator++) {
				list[iterator] = list[iterator + 1];
			}
			count--;
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
	//– Return the location of the parameter in the list. If the parameter is not
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

}
