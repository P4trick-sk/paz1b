package sk.upjs.sk;

public class Zahradka {
    private int[][] urodnost;
    private int[][] sucty;
    private int riadky;
    private int stlpce;


    public Zahradka(int[][] urodnost) {
        this.urodnost = urodnost;
        this.sucty = new int[urodnost.length][urodnost[0].length];
        this.stlpce = urodnost[0].length;
        this.riadky = urodnost.length;
    }

    public int vypocitajMaximum() {
        sucty[0][0] = urodnost[0][0];

        // Vyplnenie prveho stlpca
        for (int i = 1; i < riadky; i++) {
            sucty[i][0] = sucty[i-1][0] + urodnost[i][0];
        }

        // Vyplnenie prveho riadku
        for (int i = 1; i < stlpce; i++) {
            sucty[0][i] = sucty[0][i-1] + urodnost[0][i];
        }

        for (int i = 1; i < riadky; i++) {
            for (int j = 1; j < stlpce; j++) {
                int maximum = Math.max(sucty[i][j-1], sucty[i-1][j]);
                sucty[i][j] = maximum + urodnost[i][j];
            }
        }

        return sucty[riadky-1][stlpce-1];
    }

    public static void main(String[] args) {
        int[][] uroda = {{3, 10, 5, 2}, {8, 7, 3, 1}, {4, 6, 9, 5}};
        Zahradka zahradka = new Zahradka(uroda);
        System.out.println(zahradka.vypocitajMaximum());
    }
}
