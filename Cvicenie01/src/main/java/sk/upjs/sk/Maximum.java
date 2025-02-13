package sk.upjs.sk;

public class Maximum {
    public static int maximum(int[] p, int odIdx, int poIdx) {
        if (odIdx == poIdx)
            return p[odIdx];

        return Math.max(p[odIdx], maximum(p, odIdx + 1, poIdx));
    }

    public static void main(String[] args) {
        System.out.println(maximum(new int[]{1, 2, 13, 4, 5}, 1, 4));
    }
}
