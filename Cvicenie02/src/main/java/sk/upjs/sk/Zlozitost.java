package sk.upjs.sk;

public class Zlozitost {

    // Celkovy pocet zrealizovanych operacii
    public static int pocet = 0;

    // Elementarna operacia
    public static void operacia() {
        pocet++;
    }

    // Linearny pocet operacii v zavislosti od n
    public static void linearna(int n) {
        for (int i = 0; i < n; i++)
            operacia();
    }

    // n.log(n) pocet operacii v zavislosti od n
    public static void nlogn(int n) {
        for (int i = 0; i < n; i++)
            for (int j = 1; j < n; j = j * 2)
                operacia();
    }

    // log(n) pocet operacii v zavislosti od n
    public static void logn(int n) {
        //Odstranime vonkajší cyklus, ktorý beží n-krát
        for (int j = 1; j < n; j = j * 2)
            operacia();;
    }

    // Kvadraticky pocet operacii v zavislosti od n
    public static void kvadraticka(int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                operacia();
    }

    // Exponencialny pocet operacii v zavislosti od n
    public static void exponencialna(int n) {
        if (n <= 1) {
            operacia();
            return;
        }

        // 2^n = 2*2^(n-1)
        exponencialna(n - 1);
        exponencialna(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Zaciatok...");
        long zaciatok = System.nanoTime();

        //linearna(2_099_999_999); //198 mili
        //nlogn(189_999_999); //4843 mili
        //kvadraticka(299_999); /4803 mili
        exponencialna(31); //3601 mili

        long koniec = System.nanoTime();
        System.out.println("Cas behu: " + ((koniec - zaciatok) / 1000000)
                + " milisekund");
    }
}