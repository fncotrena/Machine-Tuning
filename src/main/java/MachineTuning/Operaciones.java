package MachineTuning;

import java.util.ArrayList;

public class Operaciones {
    private ArrayList<String> cinta;
    private int cabezal = 0;

    public Operaciones(ArrayList<String> cinta) {
        this.cinta = cinta;
    }

    public ArrayList<String> getCinta() {
        return cinta;
    }

    public void setCinta(ArrayList<String> cinta) {
        this.cinta = cinta;
    }

    public int getCabezal() {
        return cabezal;
    }

    public void setCabezal(int cabezal) {
        this.cabezal = cabezal;
    }

    public String getCaracterActual(int i) {
        return cinta.get(i);
    }


    public void right() {
        this.setCabezal(this.getCabezal()+1);
       ;

    }

    public void left() {
        if (this.cabezal > 0) {
            this.cabezal -= 1;;
        } else {
            this.cabezal=0;
        }
    }

    public void shiftRight() {
        if (this.getCabezal() < this.getCinta().size() && this.getCabezal()>0) {
            this.getCinta().remove(1 + this.getCabezal());
            this.setCabezal(this.cabezal - 1);
        }

    }

    public void shiftLeft() {
        if (this.getCabezal() < this.getCinta().size() && this.getCabezal()>0) {
            this.getCinta().remove((this.getCabezal() - 1));
            this.setCabezal(this.cabezal - 1);
        }
    }

    public void rightTo(String caracter) {
        if (this.getCabezal() < this.getCinta().size() || this.getCaracterActual(this.getCabezal()) != caracter) {
            this.right();
        }
    }

    public void leftTo(String caracter) {
        if (this.getCabezal() > this.getCinta().size() || this.getCaracterActual(this.getCabezal()) != caracter) {
            if (this.cabezal > 0)
                this.left();
        }

    }

    public void put(String caracter) {
        this.cinta.set(this.getCabezal(), caracter);
    }

    public String operacion(String Operacion, String Caracter) {
        switch (Operacion) {

            case "R":
                this.right();
                return "Operacion R => caracter: " + this.getCaracterActual((this.evaluarCabezal()));
            case "L":
                this.left();
                    return "Operacion L => caracter: " + this.getCaracterActual(this.evaluarCabezal());
            case "SR":
                this.shiftRight();
                return "Operacion SR => caracter: " + this.getCaracterActual(this.evaluarCabezal());

            case "SL":
                this.shiftLeft();
                return "Operacion SL => caracter: " + this.getCaracterActual(this.evaluarCabezal());
            case "P":
                this.put(Caracter);
                return "Operacion PUT => caracter: " + this.getCaracterActual(this.evaluarCabezal());
            case "RT":
                this.rightTo(Caracter);
                return "Operacion RighTo => caracter: " + this.getCaracterActual(this.evaluarCabezal());
            case "LT":
                this.leftTo(Caracter);
                return "Operacion LeftTo => caracter: " + this.getCaracterActual(this.evaluarCabezal());

            case "lambda":
                return "estado aceptador => :"+Caracter;

                default:  return  "Operacion Invalida ";

        }

    }


    private int evaluarCabezal() {


        return this.getCabezal();
    }

}