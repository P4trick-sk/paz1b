package sk.upjs.sk;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class FraktalTurtle extends Turtle {

    public void vlocka(int uroven, double rozmer){
        if (uroven == 0){
            return;
        }
        for (int i = 0; i < 6; i++) {
            this.step(rozmer);
            this.vlocka(uroven - 1, rozmer/3);
            this.step(-rozmer);
            this.turn(60);
        }
    }

    public void stvorec(int uroven, double rozmer) {
        if (uroven == 0){
            return;
        }
        for (int i = 0; i < 4; i++) {
            this.step(rozmer);
            this.turn(-90);
            this.stvorec(uroven - 1, rozmer/4);
            this.turn(180);
        }
    }

    public void krizik(int uroven, double rozmer) {
        if (uroven == 0){
            return;
        }
        for (int i = 0; i < 4; i++) {
            this.step(rozmer);
            this.krizik(uroven - 1, rozmer/2);
            this.step(-rozmer);
            this.turn(90);
        }
    }

    public void divnyStvorec(int uroven, double rozmer) {
        if (uroven == 0){
            return;
        }
        for (int i = 0; i < 4; i++) {
            this.step(rozmer);
            this.turn(135);
            this.divnyStvorec(uroven - 1, rozmer/3);
            this.turn(-45);
        }
    }

    public void kruhVKruhu(int uroven, double rozmer){
        this.penUp();
        if (uroven == 0){
            return;
        }
        for (int i = 0; i < 4; i++) {
            this.circle(rozmer/2);
            this.step(rozmer/3);
            this.kruhVKruhu(uroven - 1, rozmer/3);
            this.step(-rozmer/3);
            this.turn(90);
        }
    }

    public void divnejsiStvorec(int uroven, double rozmer) {
        if (uroven == 0){
            return;
        }
        for (int i = 0; i < 4; i++) {
            this.step(rozmer/3);
            this.turn(-90);
            this.divnejsiStvorec(uroven - 1, rozmer/3);
            this.turn(90);
            this.step((rozmer/3)*2);
            this.turn(90);
        }
    }

    /*public void tSquare(int uroven, double rozmer){
        this.setFillColor(Color.BLACK);
        if (uroven == 0){
            return;
        }
        for (int i = 0; i < 4; i++) {
            this.openPolygon();
            this.step((rozmer/4)*3);
            this.turn(-90);
            this.tSquare(uroven - 1, rozmer/4);
            this.turn(90);
            this.step(rozmer/4);
            this.turn(90);
            this.closePolygon();
        }
    }*/

    public void krizikBezUrovne(double rozmer) {
        if (rozmer > 1){
            for (int i = 0; i < 4; i++) {
                this.step(rozmer);
                this.krizikBezUrovne(rozmer/2);
                this.step(-rozmer);
                this.turn(90);
            }
        }
    }
}
