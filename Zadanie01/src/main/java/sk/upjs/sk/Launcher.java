package sk.upjs.sk;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		/*AnimatedWinPane sandbox = new AnimatedWinPane();
		sandbox.setAnimationSpeed(AnimatedWinPane.AnimationSpeed.SLOW);
		Ammann franklin = new Ammann();
		sandbox.add(franklin);

		franklin.hexagonAmmann(1, 50);*/

		//int p[] = {2, 9};
		//int p[] = {12, 12, 13, 14, 17, 12, 12, 13, 14, 17, 12, 12, 13, 14, 17};
		//System.out.println(PoloveAlgoritmy.maMaleRozdiely(p, 0, p.length-1, 6));
		System.out.println(komb(3, 1));
	}

	public static int komb(int n, int k){
		if (n == k || k == 0)
			return 1;

		return komb(n-1, k) + komb(n-1, k-1);
	}
}