package sk.upjs.sk;

import sk.upjs.jpaz2.*;

import java.util.Arrays;

public class Launcher {

	public static void main(String[] args) {
		// create new "sandbox" - a place where turtles can live
		//WinPane sandbox = new WinPane();

		int p[] = {1, 5, 8, 9, 10, 11, 4, 7, 0, 6};
		//BubbleSort sort = new BubbleSort();
		SelectionSort sort = new SelectionSort();
		sort.utried(p);
		//System.out.println(Cvicenie.binarneHladajIndex(p, 10));
		System.out.println(Arrays.toString(p));
	}
}