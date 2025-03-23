package sk.upjs.sk;

public class Strom {

    public static int hodnotaVStrome(int[] pole, String cesta){
        cesta = cesta.toLowerCase();
        int idx = 0;

        for (int i = 0; i < cesta.length(); i++) {
            if(cesta.charAt(i) == 'l'){
                idx = idx*2+1;
            }
            else if(cesta.charAt(i) == 'r') {
                idx = idx*2+2;
            }
        }

        if (idx > pole.length)
            throw new IndexOutOfBoundsException("neplatná cesta");

        return pole[idx];
    }

    public static boolean jeHaldou(int[] pole) {
        for (int i = 0; i < pole.length; i++) {
            if (i*2+1 < pole.length && pole[i*2+1] > pole[i])
                return false;
            if (i*2+2 < pole.length && pole[i*2+2] > pole[i])
                return false;
        }

        return true;
    }


    public static void main(String[] args) {
        int p[] = {9,5,13,3,6,10,15,1,4,2};
        int p2[] = {15, 10, 11, 4, 5, 6, 4};

        //System.out.println(hodnotaVStrome(p, "RLLLL"));
        System.out.println(jeHaldou(p2));
    }
}
