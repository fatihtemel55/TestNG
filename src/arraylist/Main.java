package arraylist;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Bag<Integer> bag =  new Bag<>();
		ArrayList<Integer> a = new ArrayList<>();
		for(int i = 1; i <= 1000000; i++) {
			bag.add(i*10);
			a.add(i);
		}
		System.out.println("Bag size:" + bag.size());


	}

}
