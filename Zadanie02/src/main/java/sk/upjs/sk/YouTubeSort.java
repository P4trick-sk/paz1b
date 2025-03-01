package sk.upjs.sk;

public class YouTubeSort extends TriediaciAlgoritmus {

    /*
    * Impelemntácia podľa klasického Selection Sortu, ktorý si zoberie i-ty prvok z poľa
    * a preň si zoberie každý ďaľší prvok a porovná ich a uloží si id toho menšieho
    * a až na konci tieto 2 prvky vymenil. Algoritmus vo videu však ihneď po nájdení zlého poradia
    * tieto 2 prvky vymení.
    * */
    @Override
    protected void utried(int dlzkaPola) {
        for (int i = 0; i < dlzkaPola; i++) {
            for (int j = i + 1; j < dlzkaPola; j++) {
                if (porovnaj(i, j) > 0){
                    vymen(i, j);
                }
            }
        }
    }

}