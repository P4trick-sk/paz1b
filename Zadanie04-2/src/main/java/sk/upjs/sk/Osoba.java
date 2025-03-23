package sk.upjs.sk;

import java.util.*;

public class Osoba {
    private String meno;
    private List<Osoba> deti = new ArrayList<Osoba>();

    public Osoba(String meno) {
        this.meno = meno;
    }

    public void pridajDieta(Osoba dieta) {
        deti.add(dieta);
    }

    /*
    * Táto funkcia prehľadáva strom po jednotlivých úrovniach a to s cieľom zastaviť sa nad predposlednej úrovni, pre ktorú zisťujeme počet
    * jedináčikov a následne sa pozrieť na to, koľko detí ma každá osoba na danej úrovni. Ak má len 1, vieme, že o úroveň nižšie bude +1 jedináčik.
    *
    * Na zvolenie si zadanej úrovne používame Queue, kde z aktuálnej úrovne pridáme všetkých priamych potomkov a potom iterujeme cez ne, až dokým nie
    * sme na požadovanej úrovni.
    * */
    public int pocetJedinacikovVGeneracii(int generacia) {
        if (generacia <= 0)
            return 0;

        Queue<Osoba> queue = new LinkedList<>();
        int uroven = 0;
        int pocet = 0;

        queue.add(this);

        while (generacia-1 != uroven) {
            int velkost = queue.size();

            for (int i = 0; i < velkost; i++) {
                Osoba osoba = queue.poll();
                queue.addAll(osoba.deti);
            }

            uroven++;
        }

        while (!queue.isEmpty()) {
            Osoba osoba = queue.poll();
            if (osoba.maIbaJednehoSyna())
                pocet++;
        }

        return pocet;
    }

    // Pomocná metóda na zistenie, či má len jedného syna
    public boolean maIbaJednehoSyna() {
        return deti.size() == 1;
    }

    /*public static void main(String[] args) {
        Osoba o1 = new Osoba("A");
        Osoba o2 = new Osoba("B");
        Osoba o3 = new Osoba("C");
        Osoba o4 = new Osoba("D");
        Osoba o5 = new Osoba("D");
        Osoba o6 = new Osoba("D");

        o1.pridajDieta(o2);
        o1.pridajDieta(o3);
        o3.pridajDieta(o4);
        o2.pridajDieta(o5);

        System.out.println(o1.pocetJedinacikovVGeneracii(2));
    }*/
}