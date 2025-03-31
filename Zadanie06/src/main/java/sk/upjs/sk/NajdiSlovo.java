package sk.upjs.sk;

public class NajdiSlovo {
    private String slovo;
    private int hashCode;

    public NajdiSlovo(String slovo, int hashCode) {
        this.slovo = slovo;
        this.hashCode = hashCode;
    }

    public String najdiRiesenie() {
        // Začíname od prvého indexu, keďže na začiatku nemôže byť medzera
        return generuj(1, String.valueOf(slovo.charAt(0)));
    }

    /*
    * Metóda generuje (skladá) rôzne verzie slova s medzerami a bez medzier pomocou backtracku.
    * */
    private String generuj(int idx, String aḱtualneSlovo) {
        if (idx == slovo.length()) {
            if (aḱtualneSlovo.hashCode() == hashCode) {
                return aḱtualneSlovo;
            } else {
                return null;
            }
        }

        /*
        * V tejto vetve sa k slovu iba pripíše ďalší znak bez medzery.
        * */
        String sMedzerou = generuj(idx + 1, aḱtualneSlovo + slovo.charAt(idx));
        if (sMedzerou != null)
            return sMedzerou;

        /*
        * V tejto vetve sa k slovu pridá medze a ďalší znak.
        * */
        String bezMedzery = generuj(idx + 1, aḱtualneSlovo + " " + slovo.charAt(idx));
        if (bezMedzery != null)
            return bezMedzery;

        return null;
    }

    public static void main(String[] args) {
        NajdiSlovo solver = new NajdiSlovo("jetook", "je to ok".hashCode());
        System.out.println(solver.najdiRiesenie());
    }
}
