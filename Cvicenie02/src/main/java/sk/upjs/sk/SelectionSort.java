package sk.upjs.sk;

public class SelectionSort extends TriediaciAlgoritmus{
    @Override
    protected void utried(int dlzkaPola) {
        for (int i = 0; i < dlzkaPola - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < dlzkaPola; j++) {
                if (porovnaj(j, minIdx) < 0)
                    minIdx = j;
            }

            if (minIdx != i) {
                vymen(i, minIdx);
            }
            vypisPole();
        }
    }
}
