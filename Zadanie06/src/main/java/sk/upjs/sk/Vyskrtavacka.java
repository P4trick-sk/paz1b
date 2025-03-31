package sk.upjs.sk;

import java.util.HashSet;
import java.util.Set;

public class Vyskrtavacka {
    private Set<Integer> mnozina;
    private String cifryCisla;

    public Vyskrtavacka(int cislo) {
        mnozina = new HashSet<>();
        cifryCisla = String.valueOf(cislo);
    }

    /*
    * Metóda generuje kombinácie cifier pridaním alebo nepridaním cifry z nejakého indexu.
    * */
    private void vyskrtaj(int idx, String cifry) {
        if (idx == cifryCisla.length()) {
            // Pridávame iba neprázdne čísla
            if (!cifry.isEmpty() && !cifry.equals(cifryCisla))
                mnozina.add(Integer.parseInt(cifry));
            return;
        }

        // Pridá cifru z i-teho miesta
        vyskrtaj(idx + 1, cifry + cifryCisla.charAt(idx));
        // Nepridá cifru z i-teho miesta
        vyskrtaj(idx + 1, cifry);
    }

    public Set<Integer> generuj() {
        vyskrtaj(0, "");

        return mnozina;
    }

    public static void main(String[] args) {
        Vyskrtavacka vyskrtavacka = new Vyskrtavacka(3);
        System.out.println(vyskrtavacka.generuj());
    }
}