package sk.upjs.sk;

public class Cvicenie {

    public static boolean jeUsporiadane(int[] p) {
        for (int i = 0; i < p.length - 1; i++) {
            if (p[i] > p[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static int binarneHladajIndex(int[] p, int hodnota) {
        int naPrejdenie = p.length / 2;
        int index = (p.length-1) / 2;

        while (index <= p.length-1 && index >= 0) {
            if (p[index] == hodnota) {
                return index;
            }
            else if (p[index] > hodnota) {
                index -= Math.max(index/2, 1);
            }
            else if (p[index] < hodnota) {
                index += Math.max(naPrejdenie/2, 1);
            }
            naPrejdenie /= 2;
        }

        return -1;
    }
}
