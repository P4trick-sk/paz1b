package sk.upjs.sk;

import java.io.*;
import java.util.*;

public class Kontrapriklady {
    /*
    * Metoda prevedie cifry na array, ktorý utriedi a vráti ako string.
    * */
    private static String utriedCifry(String cislo) {
        char[] cifry = cislo.toCharArray();
        Arrays.sort(cifry);
        return new String(cifry);
    }
    
    private static boolean lisiaSaVJednejCifre(String cifry1, String cifry2) {
        if (cifry1.length() != cifry2.length()) {
            return false;
        }

        int pocet = 0;
        int i = 0;
        
        while (i < cifry1.length()) {
            if (cifry1.charAt(i) != cifry2.charAt(i)) {
                pocet++;
                if (pocet > 1) {
                    return false;
                }
            }
            
            i++;
        }
        
        return pocet == 1;
    }

    public static void main(String[] args) {
        File subor = new File("kombinacie.txt");

        try (PrintWriter pw = new PrintWriter(subor)) {

            // Začínam od X = 32, to je najmenšie číslo, ktoré dá na druhú mocninu štvorciferné číslo
            for (int x = 32; x < 100; x++) {
                int y = x * x;

                // Skúšam všetky kombinácie čísel a vyhodnocujem. Dalo by sa to prehodiť aj na backtracking
                for (int M1 = 100; M1 < 1000; M1++) {
                    for (int M2 = M1 + 1; M2 < 1000; M2++) {
                        int vysledok1 = M1 * y;
                        int vysledok2 = M2 * y;

                        String cifry1 = utriedCifry(String.valueOf(vysledok1));
                        String cifry2 = utriedCifry(String.valueOf(vysledok2));

                        if (lisiaSaVJednejCifre(cifry1, cifry2)) {
                            pw.println(x + " " + M1 + " " + M2);
                        }
                    }
                }
            }
            System.out.println("Výsledky boli uložené");
        } catch (FileNotFoundException e) {
            System.err.println("Subor neexistuje!");
        }
    }
}
