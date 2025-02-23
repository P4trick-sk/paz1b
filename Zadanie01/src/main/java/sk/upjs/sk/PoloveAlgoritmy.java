package sk.upjs.sk;

import sk.upjs.calltree.CallTree;

public class PoloveAlgoritmy {
    public static boolean maMaleRozdiely(int[] p, int odIdx, int poIdx, int rozdiel) {
        int stred = (odIdx + poIdx) / 2;

        //Ak porovnávame prvok sám so sebou, vrátime true
        if (poIdx == odIdx) {
            return true;
        }

        //V prípade, že porovnávame len 2 čísla, tak porovnáme stred s nasledujúcim číslom, keďže pri celočíselnom delení vieme, že existuje stred + 1
        if (poIdx - odIdx == 1) {
            return Math.abs(p[stred + 1] - p[stred]) <= rozdiel;
        }

        //Zistíme, či má stredný prvok menší alebo rovný rozdiel s prvkami o 1 vedľa neho
        boolean stredOk;
        stredOk = Math.abs(p[stred] - p[stred - 1]) <= rozdiel && Math.abs(p[stred + 1] - p[stred]) <= rozdiel;

        //Výsledkom funkcie je zistenie, či je rozdiely platia pre stred a každú trojicu (prípadne dvojicu) naľavo a napravo od stredu
        return stredOk && maMaleRozdiely(p, odIdx, stred, rozdiel) && maMaleRozdiely(p, stred + 1, poIdx, rozdiel);
    }
}
