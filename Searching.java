import java.util.*;

class Searching {

	public static int linearSearch(ArrayList<Integer> a, int x) {
		for (int i = 0; i < a.size(); i++) {
			if (x == a.get(i)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		ArrayList<Integer> c = new ArrayList<Integer>();
		for (int i = 0; i < 10000; i++) {
			c.add(i+1);
		}
		int y = 369;
		
		// Create an arraylist of n integers
		// with random integers from 1 - n
		ArrayList<Integer> a = new ArrayList<Integer>();
		int n = 1000;
		for (int i = 0; i < n; i++) {
			int newNum = 1 + (int)(Math.random()*n);
			a.add(newNum);
		}
		System.out.println(a);

		// search for x
		int x = 777;

		// keep track of the time in nanoseconds
		long start = System.nanoTime();
		int b = linearSearch(a, x);
		long end = System.nanoTime();
		long total = end - start;

		if (b >= 0) {
			System.out.println("Found " + x + "! at position " + b);
		}
		else {
			System.out.println("Did not find " + x + " :(");
		}
		System.out.println("Took " + total + " nanoseconds!");
	}
}