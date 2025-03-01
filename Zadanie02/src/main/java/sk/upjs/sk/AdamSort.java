package sk.upjs.sk;

import java.util.Arrays;

public class AdamSort {

    /**
     * Vrati index v poli p, kde by sa mal nachadzat prvok so zadanou hodnotou v
     * zadanom usporiadanom podpoli pola p.
     *
     * @param p
     *            pole
     * @param odIdx
     *            index prveho prvku usporiadaneho podpola
     * @param poIdx
     *            index posledneho prvku usporiadaneho podpola
     * @param hodnota
     *            hodnota, ktoru mame v plane vlozit
     * @return index pola, kde by sa mala nachadzat zadana hodnota
     */
    public static int binarneHladajIndex(int[] p, int odIdx, int poIdx, int hodnota) {

        // Skontrolujeme korektnost indexov
        if (odIdx > poIdx)
            throw new RuntimeException("Parameter odIdx musi byt mensi alebo rovny ako poIdx.");

        // Ak je hodnota vacsia, ako cislo na poslednom indexe uvazovaneho
        // podpola, tak vratime nasledujuci index (spravne miesto pre hodnotu je
        // az za poslednym prvkom podpola)
        if (p[poIdx] < hodnota)
            return poIdx + 1;

        // Vieme, ze spravny index je medzi odIdx..poIdx - aplikujeme binarne
        // vyhladavanie
        while (odIdx < poIdx) {
            // Vypocitame stredovy index
            int stred = (odIdx + poIdx) / 2;

            if (hodnota <= p[stred]) {
                // Ak je hodnota mensia alebo rovna ako hodnota v strede, tak
                // spravne miesto je niekde medzi odIdx..stred
                poIdx = stred;
            } else {
                // Ak je hodnota vacsia ako hodnota v strede, tak spravne miesto
                // bude az za stredovym indexom, t.j. niekde medzi stred+1 a
                // poIdx
                odIdx = stred + 1;
            }
        }

        return odIdx;
    }

    /**
     * Specialna verzia pre Adamov algoritmus, kedze on predpoklada, ze v poli
     * ma prvky na indexoch 0..poIdx uz usporiadane.
     */
    public static int binarneHladajIndex(int[] p, int poIdx, int hodnota) {
        return binarneHladajIndex(p, 0, poIdx, hodnota);
    }

    /**
     * Usporiada cisla v poli od najmensieho po najvacsie
     *
     * @param p
     *            pole, ktoreho prvky treba usporiadat
     */
    public static void utried(int[] p) {
        /*
        * Analýza:
        *   - Čašová náročnosť bude pri optimálnom scenári O(n), kedže pobeží n-krát, pri čom budú
        *   všetky prvky už zoradené a nie je potrebné žiadne prvky meniť.
        *   - Čašová náročnosť bude pri najhoršom scenári O(n^2), pretože algoritmus pobeží n-krát a pre každý i-ty
        *   prvok pobeží binárne vyhľadávanie, ktoré pobeží log i krát a i-1 výmen. To je postupnosť čísel, ktorá
        *   nastane (n*(n+1) / 2) krát, čo je zložitosť O(n^2).
        *   Výsledkom je teda O(n* log n + n^2), čo je O(n^2).
        *
        * Záver:
        *   - Kedže má Adamov algoritmus časovú zložitosť O(n^2), tak má tento algoritmus
        *   rovnakú asymptotickú zložitosť ako triedenia z prednášky.
        * */
        for (int i = 1; i < p.length; i++) {
            if (i == 1 && p[i] < p[i-1]) {
                vymen(p, i, i-1);
            } else {
                int index = binarneHladajIndex(p, 0, i, p[i]);

                for (int j = i; j > index; j--) {
                    vymen(p, j, j-1);
                }
            }
        }
    }

    /**
     * Vymeni prvky v usporiadavanom poli na zadanych indexoch
     */
    public static void vymen(int[] p, int idx1, int idx2) {
        int pom = p[idx1];
        p[idx1] = p[idx2];
        p[idx2] = pom;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] p = new int[30];
        for (int i = 0; i < p.length; i++)
            p[i] = (int) (Math.random() * 1000);

        System.out.println(Arrays.toString(p));
        utried(p); // AdamSort.utried(p);
        System.out.println(Arrays.toString(p));
    }

}