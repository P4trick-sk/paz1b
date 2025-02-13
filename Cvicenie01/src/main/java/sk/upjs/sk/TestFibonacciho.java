package sk.upjs.sk;

import sk.upjs.calltree.CallTree;

public class TestFibonacciho {

    private static int pocetVolani = 0;
    private static int maxVnorenie = 0;

    public static int fibonacci(int n, int uroven) {
       // CallTree.markCall();

        if (uroven > maxVnorenie) {
            maxVnorenie = uroven;
        }

        if (n == 0) {
            //CallTree.markReturn(0);
            return 0;
        }

        if (n == 1) {
            //CallTree.markReturn(1);
            return 1;
        }

        int vysledok = fibonacci(n - 2, uroven + 1) + fibonacci(n - 1, uroven + 1);
       // CallTree.markReturn(vysledok);
        return vysledok;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5, 0));
        System.out.println(pocetVolani);
        System.out.println(maxVnorenie);
    }
}