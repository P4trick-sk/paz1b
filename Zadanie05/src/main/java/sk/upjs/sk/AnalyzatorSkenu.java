package sk.upjs.sk;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;

public class AnalyzatorSkenu {

    // Pomocná trieda na uloženie pixelu
    private static class Pixel {
        int x;
        int y;

        Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private BufferedImage obrazok;
    private int sirka;
    private int vyska;
    private double hustotaBuniek;
    // Inštančná premenná, ktorá zachytáva, či bola bunka vrámci algoritmu prejdená, aby sme predišli opakovanému prechádzaniu
    private boolean[][] navstivene;
    private int pocetBuniek;

    public AnalyzatorSkenu(String nazovSuboru) {
        try {
            obrazok = ImageIO.read(new File(nazovSuboru));
            sirka = obrazok.getWidth();
            vyska = obrazok.getHeight();
            navstivene = new boolean[sirka][vyska];
        } catch (IOException e) {
            System.err.println("Subor " + nazovSuboru + " sa nepodarilo nacitat.");
        }
        analyzuj();
    }

    private boolean jePixelBunky(int x, int y) {
        Color pixel = new Color(obrazok.getRGB(x, y));
        return !pixel.equals(Color.black);
    }

    private void vypocitajHustotuBuniek() {
        int pocetBunkovychPixelov = 0;
        for (int y = 0; y < vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                if (jePixelBunky(x, y)) {
                    pocetBunkovychPixelov++;
                }
            }
        }
        hustotaBuniek = pocetBunkovychPixelov / ((double) (sirka * vyska));
    }

    /*
    * Prejdeme každý pixel obrázku pomocou vnorených cyklov a ak nájdeme pixel bunky, ktorý sme nenavšívili, začneme prehľadávať
    * ostatné pixely bunky, keď s tým skončíme, zarátame bunku do celkového počtu.
    * */
    private void analyzuj() {
        vypocitajHustotuBuniek();
        pocetBuniek = 0;

        for (int y = 0; y < vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                if (jePixelBunky(x, y) && !navstivene[x][y]) {
                    prehladaj(x, y);
                    pocetBuniek++;
                }
            }
        }
    }

    /*
    * Algoritmus na prehľadanie funguje tak, že začneme od pixelu, ktorý sme našli a vieme, že patrí bunke
    * a každý ďalší pixel bunky, ktorý sa nachádza v okolí 1 pixelu označíme za prehľadaný a ak nájdeme ďalší
    * pixel bunky, pridáme ho do stacku, aby sme mohli prehľadať aj jeho okolie. Ak už nenájdeme žiadny pixel bunky,
    * stack sa vyprázdni a algoritmus skončí.
    *
    * Časová zložitosť:
    * Každým pixelom prechádzame (v metóde analyzuj) iba raz, aby sme zamedzili opakovanému prechádzaniu pixelov,
    * používame pomocnú inštančnú premennú, aby sme spracované pixely už 2x neprechádzali.
    * Preto sa časová zložitosť rovná počtu pixelov na obrázku, čo je O(n).
    * */
    private void prehladaj(int startX, int startY) {
        Stack<Pixel> stack = new Stack<>();
        stack.push(new Pixel(startX, startY));

        // Všetky možné kombinácie prechodov (vľavo, vpravo, hore, dole, diagonály)
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        while (!stack.isEmpty()) {
            Pixel p = stack.pop();
            int x = p.x;
            int y = p.y;

            // Neprechádzame bunkami, ktoré sú mimo rozsah, sú navštívené alebo nie sú pixelom bunky
            if (x < 0 || x >= sirka || y < 0 || y >= vyska || navstivene[x][y] || !jePixelBunky(x, y)) {
                continue;
            }

            navstivene[x][y] = true;
            for (int i = 0; i < 8; i++) {
                stack.push(new Pixel(x + dx[i], y + dy[i]));
            }
        }
    }

    public int getPocetBuniek() {
        return pocetBuniek;
    }

    public double getHustotaBuniek() {
        return hustotaBuniek;
    }

    public static void main(String[] args) {
        AnalyzatorSkenu analyzator = new AnalyzatorSkenu("skeny/SkenBuniek08.png");
        System.out.println("Hustota buniek: " + (analyzator.getHustotaBuniek() * 100) + " %");
        System.out.println("Pocet buniek: " + analyzator.getPocetBuniek());
    }
}
