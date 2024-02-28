package datastr;

import java.util.ArrayList;

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
	
	//TODO
	//1.funkcijas dekleracija
	public void add(int element) {
	//2.parbaude isFull - tad izsauc resize
		if (isFull()) resize();
	//3. ieliek jauno elementu ka pedejo saraksta
		list[counter] = element;
	//4.palielina counter par 1
		counter += 1;
	}
	
	public void add(int element, int index) throws Exception {
		if (index < 0 || index > counter) {
			throw new Exception("Incorrect index");
		}
		if(isFull()) resize();
		if(index == counter) add(element);
		else {
			for(int i = counter; i > index; i--) {
				list[i] = list[i-1];
			}
			list[index] = element;
			counter += 1;
			
		}
	}
	//TODO
	//0. definet prikolu
	public void delete(int index) throws Exception {	
	//1. parbaudes
		if (index < 0 || index >= counter) {
			throw new Exception("Incorrect index");
		}
		if(isEmpty()) throw new Exception("List empty");
	//3. veikt kopesanu uz kreiso pusi lidz indeksa elementam
		for (int i = index; i < counter -1; i++) {
			list[i] = list[i+1];
		}
	//4. coubnter jasamazina par 1
		counter--;
	}
	
	public int getElement(int index) throws Exception {
		if (isEmpty()) throw new Exception("List empty");
		if (index < 0 || index >= counter) {
			throw new Exception("Incorrect index");
		} else {
			return list[index];
		}
	}
	
	public ArrayList search (int element) throws Exception {
		if (isEmpty()) throw new Exception("List empty");
		ArrayList indexes = new ArrayList();
		for (int i = 0; i < counter ; i++) {
			if (list[i] == element) {
				indexes.add(i);
			}
		}
		if(indexes.size() == 0) throw new Exception("Element not found");
		return indexes;
	}
	public int[] getNeighbour(int element) throws Exception {
		ArrayList indexes = search(element);
		
		int neighboursSize = indexes.size();
		
		if ((Integer)indexes.get(indexes.size()-1) == (counter-1))
			neighboursSize--;
		
		int[] neighbours = new int[neighboursSize];
		for(int i = 0; i < neighboursSize; i++) {
			int indexFromSearchTemp = (int)indexes.get(i);
			int indexNeighbourTemp = indexFromSearchTemp+1;
			neighbours[i] = list[indexNeighbourTemp];
		}
		return neighbours;
	}
	
	public void print() {
		for (int i = 0; i < counter; i++) {
			System.out.println(list[i] + " ");
		}
		System.out.println();
	}
	
	public void makeEmpty() {
		counter = 0;
		size = LIST_SIZE;
		list = new int[size];
		System.gc();
	}
}