package sk.upjs.sk;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Cards {
    public boolean solve(int[][] cards, int number) {
        Set<Integer> sucty = new HashSet<>();
        sucty.add(0);

        for (int[] card : cards) {
            Set<Integer> novySucty = new HashSet<>(sucty);

            for (int sum : sucty) {
                int sumA = sum + card[0];
                int sumB = sum + card[1];

                if (sumA <= number)
                    novySucty.add(sumA);
                if (sumB <= number)
                    novySucty.add(sumB);
            }

            sucty = novySucty;
        }

        return sucty.contains(number);
    }

    public static void main(String[] args) {
        Cards cards = new Cards();
        int[][] test = {{19,40}, {23,40}, {17,24}, {18,24}, {71,96}};

        System.out.println(cards.solve(test, 175));
    }
}