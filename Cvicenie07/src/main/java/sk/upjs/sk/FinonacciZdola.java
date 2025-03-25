package sk.upjs.sk;

public class FinonacciZdola {
    private long[] cache;

    public long fibonacci(int n) {
        cache = new long[n + 1];
        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }

    public static void main(String[] args) {
        FinonacciZdola finonacci = new FinonacciZdola();
        System.out.println(finonacci.fibonacci(10_000_000));
    }
}
