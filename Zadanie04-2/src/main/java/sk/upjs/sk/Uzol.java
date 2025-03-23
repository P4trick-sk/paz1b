package sk.upjs.sk;

import java.util.*;

public class Uzol {
    private int hodnota;
    private Uzol lavy;
    private Uzol pravy;

    public Uzol(int hodnota, Uzol lavy, Uzol pravy) {
        this.hodnota = hodnota;
        this.lavy = lavy;
        this.pravy = pravy;
    }

    public int getHodnota() {
        return hodnota;
    }

    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }

    // Na efektívne vyriešenie problému potrebujeme rekurzívne volania, preto použijeme pomocnú metódu
    public boolean jeVyvazeny() {
        return jeVyvazeny(this) != -1;
    }

    /*
    * Rekurzívna funkcia, ktorá kontroluje počet prvkov na ľavej a pravej strane. V prípade, že je rozdiel väčší ako 1, vráti (-1), v opačno,
    * prípade vráti počet prvkov na zadanej strane.
    *
    * Analýza časovej zložitosti:
    * Na každom prvku zavoláme metódu pre jeho ľavého a pravého syna, čo vo výsledku znamená, že sa na každý uzol pozrieme iba raz a v ňom vykonáme
    * konštantný počet operácií, čo je zložitosť O(n).
    */
    private int jeVyvazeny(Uzol uzol) {
        if (uzol == null) { // báza rekurzie
            return 0;
        }

        int lavyCount = jeVyvazeny(uzol.lavy);
        int pravyCount = jeVyvazeny(uzol.pravy);

        if (lavyCount == -1 || pravyCount == -1 || Math.abs(lavyCount - pravyCount) > 1) {
            return -1; // Nevyvážený strom
        }

        return lavyCount + pravyCount + 1;
    }

    /*
    * Na to, aby sme mali optimálnu výšku binárneho stromu je potrebné, aby bol koreň medianom zoznamu čísel.
    * Ak si hodnoty roztriedime (prehodením na list a použitia Dual-Pivot Quicksort-u, ktorý je pod Arrays.sort),
    * vieme, že sa median nachádza v strede zoznamu a vieme tak rekurzívne vytvárať podstromy.
    * */
    public static Uzol vytvorBVS(Set<Integer> hodnoty) {
        List<Integer> zoradeneHodnoty = new ArrayList<>(hodnoty);
        Collections.sort(zoradeneHodnoty);

        return vytvorBVS(zoradeneHodnoty, 0, zoradeneHodnoty.size() - 1);
    }

    private static Uzol vytvorBVS(List<Integer> hodnoty, int zaciatok, int koniec) {
        if (zaciatok > koniec) { // báza rekurzie
            return null;
        }

        int stred = zaciatok + (koniec - zaciatok) / 2;
        Uzol uzol = new Uzol(hodnoty.get(stred), null, null);

        uzol.lavy = vytvorBVS(hodnoty, zaciatok, stred - 1);
        uzol.pravy = vytvorBVS(hodnoty, stred + 1, koniec);

        return uzol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (lavy != null)
            sb.append("(" + lavy.toString() + ") ");

        sb.append(hodnota);

        if (pravy != null)
            sb.append(" (" + pravy.toString() + ")");

        return sb.toString();
    }

    /*public static void main(String[] args) {
        Uzol u4 = new Uzol(4, null, null);
        Uzol u2 = new Uzol(2, null, null);
        Uzol u5 = new Uzol(5, null, null);
        Uzol u3 = new Uzol(3, u5, u4);
        Uzol u1 = new Uzol(1, u2, u3);

        Set<Integer> hodnoty = new HashSet<>(Arrays.asList(5, 3, 8, 1, 4, 7, 10));
        Uzol koren = Uzol.vytvorBVS(hodnoty);

        System.out.println(koren);

        System.out.println(u1.jeVyvazeny());
    }*/
}