package sk.upjs.sk;

public class BubbleSort extends TriediaciAlgoritmus{
    @Override
    protected void utried(int dlzkaPola) {
        boolean bolaVymena;
        int k = 0; // vylepseny bubblesort
        do {
            bolaVymena = false;
            for (int i=0; i<dlzkaPola-1-k; i++)
                if (porovnaj(i, i+1) > 0) {
                    vymen(i, i+1);
                    bolaVymena = true;
                }
            k++;
        } while (bolaVymena);
    }
}
