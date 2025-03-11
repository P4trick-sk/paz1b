package sk.upjs.sk;

import sk.upjs.calltree.CallTree;

import java.util.Arrays;

public class QuickSort extends TriediaciAlgoritmus {

    @Override
    protected void utried(int dlzkaPola) {
        quicksort(0, dlzkaPola - 1);
    }

    protected void quicksort(int odIdx, int poIdx) {
        CallTree.markCall();
        if (poIdx < odIdx || poIdx == odIdx){
            CallTree.markReturn();
            return;
        }

        int pivotIdx = poIdx;
        int idx = odIdx;

        for (int i = odIdx; i < poIdx; i++) {
            if (porovnaj(i, pivotIdx) < 0) {
                vymen(idx, i);
                idx++;
            }
        }

        vymen(pivotIdx, idx);

        quicksort(odIdx, idx - 1);
        quicksort(idx + 1, poIdx);
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int p[] = {6,8,2,7,3,5};
        qs.utried(p);
        System.out.println(Arrays.toString(p));
    }
}
