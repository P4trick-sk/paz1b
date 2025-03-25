package sk.upjs.sk;

public class Finonacci1 {
    public long rekurzivnyFibo(int cislo){
        if (cislo == 1 || cislo == 0){
            return cislo;
        }

        return rekurzivnyFibo(cislo-1) + rekurzivnyFibo(cislo-2);
    }

    public static void main(String[] args) {
        Finonacci1 finonacci1 = new Finonacci1();
        System.out.println(finonacci1.rekurzivnyFibo(15));
    }
}
