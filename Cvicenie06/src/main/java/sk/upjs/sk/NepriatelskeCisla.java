package sk.upjs.sk;

import java.util.Arrays;

public class NepriatelskeCisla {
    private int[] vstup;
    private int[] vystup;
    private boolean[] pouzite;
    int pocet = 0;

    public NepriatelskeCisla(int[] vstup) {
        this.vstup = vstup;
        vystup = new int[vstup.length];
        pouzite = new boolean[vstup.length];

        generuj(0);
    }

    private void generuj(int odIdx) {
        if (odIdx == vstup.length) {
            spracuj();
            return;
        }

        for (int i = 0; i < vstup.length; i++) {
            if (!pouzite[i]) {
                if (odIdx == 0 || suPriatelske(vstup[i], vystup[odIdx - 1])){
                    vystup[odIdx] = vstup[i];
                    pouzite[i] = true;
                    generuj(odIdx + 1);
                    pouzite[i] = false;
                }
            }
        }
    }

    private boolean suPriatelske(int a, int b){
        return !(a % b == 0 || b % a == 0);
    }

    private void spracuj() {
       /* for (int i = 1; i < vystup.length; i++) {
            if (vystup[i] % vystup[i-1] == 0 || vystup[i - 1] % vstup[i] == 0) {
                return;
            }
        }*/

        pocet++;
        System.out.println(Arrays.toString(vystup));
    }

    public static void main(String[] args) {
        int[] vstup = {3,5,4,8};

        NepriatelskeCisla nc = new NepriatelskeCisla(vstup);
    }
}
