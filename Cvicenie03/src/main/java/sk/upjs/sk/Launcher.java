package sk.upjs.sk;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		SpajanyZoznam zoznam = new SpajanyZoznam();
		/*zoznam.pridajNaZaciatok(10);
		zoznam.pridajNaZaciatok(20);
		zoznam.pridajNaZaciatok(70);
		zoznam.add(1,50);
		//zoznam.set(1, 69);*/
		zoznam.add(0, 10);
		System.out.println(zoznam);
		System.out.println(zoznam.size());
	}
}