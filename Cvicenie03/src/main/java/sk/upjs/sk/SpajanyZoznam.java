package sk.upjs.sk;

public class SpajanyZoznam {
    private static class Uzol {
        int hodnota;
        Uzol dalsi;
    }

    private Uzol prvy = null;
    private int velkost = 0;

    public void pridajNaZaciatok(int hodnota) {
        Uzol pridavany = new Uzol();
        pridavany.hodnota = hodnota;
        pridavany.dalsi = prvy;
        prvy = pridavany;
        velkost++;
    }

    private Uzol vratITy(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException();

        Uzol aktualny = this.prvy;
        for (int i = 0; i < index; i++) {
            aktualny = aktualny.dalsi;
            if (aktualny == null)
                break;
        }

        return aktualny;
    }

    public int get(int index) {
        if (index < 0 || index >= velkost)
            throw new IndexOutOfBoundsException();

        return vratITy(index).hodnota;
    }

    public void set(int index, int value) {
        if (index < 0 || index >= velkost)
            throw new IndexOutOfBoundsException();

        Uzol uzol = vratITy(index);
        uzol.hodnota = value;
    }

    public void add(int value) {
        if (prvy == null) {
            pridajNaZaciatok(value);
            return;
        }

        Uzol posledny = new Uzol();
        posledny.hodnota = value;

        Uzol predposledny = vratITy(velkost-1);
        predposledny.dalsi = posledny;
        velkost++;
    }

    public void add(int index, int value) {
        if (index == 0) {
            pridajNaZaciatok(value);
            return;
        }

        Uzol predlosly = vratITy(index-1);
        Uzol pridavany = new Uzol();
        pridavany.hodnota = value;
        pridavany.dalsi = predlosly.dalsi;
        predlosly.dalsi = pridavany;
        velkost++;
    }

    public int size() {
        return velkost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < velkost; i++) {
            sb.append(i + "=>" + this.get(i) + ", ");
        }

        return sb.toString();
    }
}