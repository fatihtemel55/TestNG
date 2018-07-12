package arraylist;

import java.util.NoSuchElementException;

public class Bag<E> {
	private int N;//number of items
	private int capacity = 10;
	private E[] items;
	
	public Bag() {
		items = (E[]) new Object[capacity];
	}
	
	private void resize() {
		//bag is full of money
		//make it bigger
		System.out.println(capacity);
		capacity *= 2;
		
		E[] temp = (E[]) new Object[capacity];
		for(int i = 0; i < N; i++) {
			temp[i] = items[i];
		}
		items = temp;
		
	}
	
	public boolean isEmpty() {return N==0;}
	
	public int size() { return N;}
	
	
	public void add(E item) {
		if(N == capacity) {
			resize();
			
		}
		items[N++] = item;
	}
	
	public E get(int index) {
		if(index < 0 || index >= N ) {
			throw new NoSuchElementException();
		}
		
		return items[index];
	}
	
	
	
	
}
