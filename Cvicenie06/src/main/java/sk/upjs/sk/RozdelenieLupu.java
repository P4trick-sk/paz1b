package sk.upjs.sk;

import java.util.Arrays;

public class RozdelenieLupu {

    private int[] predmety;
    private int[] p;

    private int najmensiRozdiel;
    private int[] najlepsieRozdelenie;

    public RozdelenieLupu(int[] predmety) {
        this.predmety = predmety;
        this.p = new int[predmety.length];
        this.najmensiRozdiel = Integer.MAX_VALUE;
    }

    private void spracuj() {
        int zlodej0 = 0, zlodej1 = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == 0) {
                zlodej0 += predmety[i];
            } else {
                zlodej1 += predmety[i];
            }
        }
        System.out.println(Arrays.toString(p) + " " + zlodej0 + ":" + zlodej1);

        if (Math.abs(zlodej0 - zlodej1) < najmensiRozdiel) {
            najlepsieRozdelenie = p.clone();
            najmensiRozdiel = Math.abs(zlodej0 - zlodej1);
        }
    }

    private void generuj(int odIdx) {
        if (odIdx == p.length) {
            spracuj();
            return;
        }

        for (int i = 0; i <= 1; i++) {
            p[odIdx] = i;
            generuj(odIdx + 1);
        }
    }

    public void generuj() {
        generuj(0);
        System.out.println("Najlepsie rozdelenie: " + Arrays.toString(najlepsieRozdelenie) + " -> " + najmensiRozdiel);
    }

    public static void main(String[] args) {
        int[] predmety = new int[4];
        for (int i = 0; i < predmety.length; i++) {
            predmety[i] = (int) (Math.random() * 8) + 2;
        }
        System.out.println(Arrays.toString(predmety));
        RozdelenieLupu lupici = new RozdelenieLupu(predmety);
        lupici.generuj();
    }
}
