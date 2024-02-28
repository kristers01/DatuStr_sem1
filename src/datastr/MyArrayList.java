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
	
	public MyArrayList(int inputSize) {
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
	
	//TODO
	//3. aprekinat newSize
	//4. jaizveido listNew ar newSize
	//5. javeic kopesana no veca masiva uz jauno
	//6. nomaina list referenci uz listNew
	//7. izsaukt garbagecollector
	//8. nomaina size uz newSize
	
	private void resize() {
		int newSize = (counter <= 100)? size * 2 : (int)(size * 1.5);
		int[] listNew = new int[newSize];
		for (int i = 0; i < size; i++) {
			listNew[i] = list[i];
		}
		list = listNew;	
		System.gc();
		size = newSize;
	}
}
