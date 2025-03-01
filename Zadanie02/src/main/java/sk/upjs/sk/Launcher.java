package sk.upjs.sk;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		int p[] = {75, 77, 78, 79, 80, 82, 83, 83, 85, 86, 88, 89, 89, 91, 91, 93, 93, 93, 93, 94, 94, 95, 97};
		/*YouTubeSort sorter = new YouTubeSort();
		sorter.utried(p);*/
		//AdamSort.utried();
		System.out.println(SpravneZavazia.obsahujeVyberSHmotnostou(p, 165));
	}
}