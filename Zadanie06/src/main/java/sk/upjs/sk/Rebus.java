package sk.upjs.sk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Rebus {
    private int pocetRieseni;

    public void riesenie() {
        File citanie = new File("rebusy.txt");
        File zapis = new File("PoctyRieseni.txt");

        try (Scanner sc = new Scanner(citanie)) {
            try (PrintWriter pw = new PrintWriter(zapis)) {
                // Pre každý riadok spustíme hľadanie riešení
                while (sc.hasNextLine()) {
                    // Rozdelím si každý riadok na cifry a sumu
                    String[] argumenty = sc.nextLine().split(" ");
                    String cislo = argumenty[0];

                    // Keďže máme veľké čísla, používam long
                    long hladanaSuma = Long.parseLong(argumenty[1]);

                    // Generovanie riešení
                    pocetRieseni = 0;
                    generuj(1, cislo, Long.parseLong(cislo.substring(0, 1)), Long.parseLong(cislo.substring(0, 1)), true, hladanaSuma);
                    pw.println(pocetRieseni);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    * Metóda generuje všetky možné algebraické kombinácie medzi číslicami a to +, - alebo nič, teda zobratie ďalšej číslice do čísla
    * */
    private void generuj(int idx, String cislo, long aktualnaSuma, long poslednaHodnota, boolean poslednaOperaciaBolaPlus, long hladanaSuma) {
        if (idx == cislo.length()) {
            if (aktualnaSuma == hladanaSuma) {
                pocetRieseni++;
            }
            return;
        }

        long hodnota = Character.getNumericValue(cislo.charAt(idx));

        // Pridanie +
        generuj(idx + 1, cislo, aktualnaSuma + hodnota, hodnota, true, hladanaSuma);

        // Pridanie -
        generuj(idx + 1, cislo, aktualnaSuma - hodnota, hodnota, false, hladanaSuma);

        // Spojenie číslic do jedného čísla
        long novaHodnota = poslednaHodnota * 10 + hodnota;

        if (poslednaOperaciaBolaPlus) {
            generuj(idx + 1, cislo, aktualnaSuma - poslednaHodnota + novaHodnota, novaHodnota, true, hladanaSuma);
        } else {
            generuj(idx + 1, cislo, aktualnaSuma + poslednaHodnota - novaHodnota, novaHodnota, false, hladanaSuma);
        }
    }

    public static void main(String[] args) {
        Rebus rebus = new Rebus();
        rebus.riesenie();
    }
}
