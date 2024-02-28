package datastr;

public class MyArrayList {

	private int[] list;
	private final int LIST_SIZE = 10;
	private int size = LIST_SIZE;
	private int counter = 0;
	
	//TODO
	//constructors
	public MyArrayList() {
		list = new int[size];
	}
	
	public MyarrayList(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		
		list = new int[size];
	}
	
	//isEmpty
	public boolean isEmpty() {
		return counter==0;
	}
	
	//isFull
	public boolean isFull() {
		return counter==size;
	}
	//howManyElements
	public int howManyElements() {
		return counter;
	}
	
}
