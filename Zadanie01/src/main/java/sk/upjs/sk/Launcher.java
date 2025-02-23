package sk.upjs.sk;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		/*AnimatedWinPane sandbox = new AnimatedWinPane();
		sandbox.setAnimationSpeed(AnimatedWinPane.AnimationSpeed.SLOW);
		Ammann franklin = new Ammann();
		sandbox.add(franklin);

		franklin.hexagonAmmann(1, 50);*/

		int p[] = {2, 9};
		//int p[] = {12, 12, 13, 14, 17, 12, 12, 13, 14, 17, 12, 12, 13, 14, 17};
		System.out.println(PoloveAlgoritmy.maMaleRozdiely(p, 0, p.length-1, 6));

	}
}