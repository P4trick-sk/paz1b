package sk.upjs.sk;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		WinPane sandbox = new WinPane();

		FraktalTurtle franklin = new FraktalTurtle();
		sandbox.add(franklin);

		ObjectInspector oi = new ObjectInspector();
		oi.inspect(franklin);
		oi.inspect(sandbox);

		franklin.kruhVKruhu(4, 50);
	}
}
