package sk.upjs.sk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Tyber {

    // Pomocná trieda pre ulozenie údajov zo súboru
    static class Pasazier {
        int nastup, vystup, cena;

        Pasazier(int nastup, int vystup, int cena) {
            this.nastup = nastup;
            this.vystup = vystup;
            this.cena = cena;
        }
    }

    public int solve(File file) {
        List<Pasazier> pasazieri = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            int c = scanner.nextInt();

            for (int i = 0; i < c; i++) {
                int nastup = scanner.nextInt();
                int vystup = scanner.nextInt();
                int cena = scanner.nextInt();

                pasazieri.add(new Pasazier(nastup, vystup, cena));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Zotriedenie pasažierov podľa vystupnej stanice
        pasazieri.sort(Comparator.comparingInt(p -> p.vystup));

        int[] stanice = new int[1001];
        int index = 0;

        for (int j = 1; j <= 1000; j++) {
            // Predpokladáme, že nemáme nového pasažiera
            stanice[j] = stanice[j - 1];

            // Prechádzame každým pasažierom, ktorý vystupuje na tejto zastávke
            while (index < pasazieri.size() && pasazieri.get(index).vystup == j) {
                Pasazier pasazier = pasazieri.get(index);
                // Hladáme maximum z toho, že pasažiera neberieme alebo ho zoberieme
                stanice[j] = Math.max(stanice[j], stanice[pasazier.nastup] + pasazier.cena);
                index++;
            }
        }

        // Maximálny príjem je na poslednej stanici
        return stanice[1000];
    }

    public static void main(String[] args) {
        Tyber tyber = new Tyber();
        File file = new File("cestujuci.txt");
        System.out.println(tyber.solve(file));
    }
} 