package sk.upjs.sk;

import sk.upjs.jpaz2.Turtle;

public class Fraktalka extends Turtle {
    public void sestuholnik(int u, double d) {
        //Báza rekurzie
        if (u == 0)
            return;

        for (int i = 0; i < 6; i++) {
            //Vnútorný šešťuholník kreslíme na začiatku každej párnej steny
            if (i%2 == 0)
                this.sestuholnik(u-1, d/2);
            this.step(d);
            this.turn(60);
        }
    }
}
