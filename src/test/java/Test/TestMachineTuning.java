package Test;

import MachineTuning.MachineTuning;
import MachineTuning.Operaciones;

import java.util.ArrayList;

public class TestMachineTuning {
    public static void main(String[] args) throws InterruptedException {
        Menu menu = new Menu();
        MachineTuning mt = new MachineTuning(menu.Mensaje());

        // System.out.println("filas de la matriz :" + mt.cargarEstados());

        ArrayList<String> cinta =mt.cargarCinta();

        Operaciones op = new Operaciones(cinta);
        String[] estadoInicial = mt.cargarEstados().get(0).get(mt.getColumna(op.getCaracterActual(0))).split("/");

        mt.recorrerTabla(estadoInicial, op, mt);

    }

}
