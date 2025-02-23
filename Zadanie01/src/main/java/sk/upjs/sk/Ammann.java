package sk.upjs.sk;

import sk.upjs.jpaz2.Turtle;

public class Ammann extends Turtle {
    public void hexagonAmmann(int u, double d) {
        if (u == 0)
            return;

        double psi = Math.sqrt(5 - 1)/2;

        System.out.println(psi);
        this.step(d);
        turn(90);
        this.step(Math.pow(psi, 3));
        turn(90);
        this.step(Math.pow(psi, 4));
        turn(-90);
        this.step(Math.pow(psi, 5));
        turn(90);
        this.step(Math.pow(psi, 2));
        turn(90);
        this.step(psi);

        //Nechcelo sa mi, život je boj
    }
}
