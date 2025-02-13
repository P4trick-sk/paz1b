package sk.upjs.sk;

import sk.upjs.calltree.CallTree;

public class Sucty {
    public static int sucet(int[] p, int odIdx, int poIdx) {
        if (odIdx > poIdx)
            return 0;

        if (odIdx == poIdx)
            return p[odIdx];

        return p[odIdx] + sucet(p, odIdx + 1, poIdx);

    }

    public static int sucet2(int[] p, int odIdx, int poIdx) {
        CallTree.markCall();
        if (odIdx > poIdx) {
            CallTree.markReturn(0);
            return 0;
        }

        if (odIdx == poIdx) {
            CallTree.markReturn(p[odIdx]);
            return p[odIdx];
        }

        int stred = (odIdx + poIdx) / 2;
        return sucet2(p, odIdx, stred) + sucet2(p, stred + 1, poIdx);

    }

    public static void main(String[] args) {
        int[] p = {4, 7, 2, 4, 2, 4, 6, 8, 2};
        System.out.println(sucet2(p, 0, 8));
    }
}
