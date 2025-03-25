package sk.upjs.sk;

import java.util.Arrays;

public class FinonacciKeš {
    private long[] cache;
    private int NEVIEM = -1;

    public long fibonacci(int n) {
        cache = new long[n + 1];
        Arrays.fill(cache, NEVIEM);

        return cešovanyFibo(n);
    }

    private long cešovanyFibo(int cislo){
        if (cache[cislo] != NEVIEM) {
            return cache[cislo];
        }

        if (cislo == 1 || cislo == 0){
            return cislo;
        }

        long vysledok = cešovanyFibo(cislo-1) + cešovanyFibo(cislo-2);
        cache[cislo] = vysledok;

        return vysledok;
    }

    public static void main(String[] args) {
        FinonacciKeš finonacci = new FinonacciKeš();
        System.out.println(finonacci.fibonacci(100));
    }
}
