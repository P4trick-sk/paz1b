package sk.upjs.sk;

public class SpravneZavazia {

    /*
    * Začíname s 2 indexami, jeden ukazujúcim na začiadok a druhy na koniec poľa.
    * Keďže vieme, že pole je usporiadané od najmenšieho po najväčšie, môžeme zistiť, kam sa s indexami hýbať.
    * Ak spočítame prvok od konca a od začiatku a ich súčet sa rovná hľadanému h, vrátime true, ak nie
    * pozeráme sa, či je súčet väčší alebo menší. V prípade, že je veľký, vieme, že musíme zmenšiť čísla v súčte,
    * to urobíme tak, že posunieme index od konca bližšie k stredu, keďže týmto smerom sú nižšie hodnoty.
    * Podobne postupujeme ak máme súčet menší a teda potrebujeme väčšie čísla do súčtu.
    *
    * Časová náročnosť O(n), pretože každým prvkom poľa prechádzame iba raz.
    * */
    public static boolean obsahujeVyberSHmotnostou(int[] zavazia, int h) {
        int zlava = 0;
        int zprava = zavazia.length - 1;

        // Nemá zmysel kontrolovať pre polia, kde nie sú aspoň 2 prvky.
        if (zavazia.length < 2)
            return false;

        for (int i = 0; i < zavazia.length; i++) {
            if (zlava == zprava)
                break;

            int sucet = zavazia[zlava] + zavazia[zprava];
            if (sucet == h) {
                return true;
            } else if (sucet < h) {
                zlava++;
            } else {
                zprava--;
            }
        }

        return false;
    }
}