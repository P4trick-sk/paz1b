package sk.upjs.sk;

public class Cards2 {
    public boolean solve(int[][] cards, int number) {
        // Vytvoríme si pomocné pole, ktoré bude ukladať informáciu o tom, či sa dá v pre istý počet kartičiek dosianuť dané číslo
        boolean[] daSa = new boolean[number + 1];
        daSa[0] = true;

        for (int[] card : cards) {
            // Pole s novo dosiahnutelnými hodnotami
            boolean[] pomocne = new boolean[number + 1];

            //Pre každú kartičku si prejdeme doteraz dosiahnutelne sumy a označíme si, ktoré sumy vieme pomocou nej získať
            for (int suma = 0; suma <= number; suma++) {
                if (daSa[suma]) {
                    if (suma + card[0] <= number) {
                        pomocne[suma + card[0]] = true;
                    }
                    if (suma + card[1] <= number) {
                        pomocne[suma + card[1]] = true;
                    }
                }
            }

            daSa = pomocne;
        }

        // Vrátime, či sa dá daná suma získať
        return daSa[number];
    }

    public static void main(String[] args) {
        Cards2 cards = new Cards2();
        int[][] test = {{19,40}, {23,40}, {17,24}, {18,24}, {71,96}};

        System.out.println(cards.solve(test, 175));
    }
}