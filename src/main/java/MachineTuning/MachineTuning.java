package MachineTuning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MachineTuning {
    //final String path = "Ejemplo.csv";
    private String archivo;

    public MachineTuning(String archivo) {
        this.archivo = archivo;
    }



    public List<List<String>> leerCsv() {

        //  String fileName = "sucesorBinario.csv";
        String fileName =  this.cargarCvs(this.archivo);
        File file = new File(fileName);

        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;


        try {
            inputStream = new Scanner(file);

            while (inputStream.hasNext()) {
                String line = inputStream.next();
                String[] values = line.split(",");
                lines.add(Arrays.asList(values));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;


    }

    private String cargarCvs(String archivo) {
        switch (archivo) {

            case "1":
                return "sucesorBinario.csv";
            case "2":
                return "antecesorBinario.csv";
            case "3":
                return "Ejemplo.csv";

            default:  return  "Operacion Invalida ";

        }

    }


    public ArrayList<String> cargarAlfabeto() {
        List<List<String>> filas = this.leerCsv();
        ArrayList<String> alfabeto = new ArrayList<>();

        for (int i = 0; i < filas.get(0).size(); i++) {

            alfabeto.add(filas.get(0).get(i));
        }

        return alfabeto;

    }


    public List<List<String>> cargarEstados() {
        List<List<String>> filas = this.leerCsv();
        List<String> estados = this.cargarAlfabeto();

        filas.remove(estados);

        return filas;

    }

    public int getColumna(String alfabeto) {
        int index = 0;
        while (!cargarAlfabeto().get(index).equals(alfabeto))
            index++;

        return index;
    }


    public String dibujarIndicador(int indice) {
        String indicador = " ";
        for (int i = 1; i <= indice; i++) {
            indicador = indicador + "   ";
        }

        return indicador + "▲";
    }


    public void recorrerTabla(String[] columna, Operaciones operaciones, MachineTuning machineTuning) throws InterruptedException {
        this.primerMsj(operaciones);

        while (!"lambda".equals(columna[1])) {

            this.mensajeTabla(columna, operaciones, machineTuning);
            if (!machineTuning.cargarAlfabeto().contains(operaciones.getCaracterActual(operaciones.getCabezal()))) {
                System.out.println("Error caracter invalido :" + operaciones.getCaracterActual(operaciones.getCabezal()));
                break;
            }
            int fila = Integer.parseInt(columna[0]) - 1;
            columna = machineTuning.cargarEstados().get(fila).get(machineTuning.getColumna(operaciones.getCaracterActual(operaciones.getCabezal()))).split("/");

        }
        if (!machineTuning.cargarAlfabeto().contains(operaciones.getCaracterActual(operaciones.getCabezal()))) {
            System.out.println("Error caracter invalido :" + operaciones.getCaracterActual(operaciones.getCabezal()));
        }
        this.mensajeTabla(columna, operaciones, machineTuning);

    }

    private void primerMsj(Operaciones op) {

        System.out.println("Comienza a moverse la cinta ");
        System.out.println("Operacion  inicia => caracter: " + op.getCaracterActual(op.getCabezal()));
        System.out.println(op.getCinta());
        System.out.println(" estado actual:" + 1);

        System.out.println("------------");
    }

    public ArrayList<String> cargarCinta() {
        System.out.println("ingrese la cinta");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strSplit = s.split("");
        ArrayList<String> cinta = new ArrayList<>(Arrays.asList(strSplit));

        cinta.add("$");
        cinta.add(0, "$");

        return cinta;
    }

    private void mensajeTabla(String[] columna, Operaciones operaciones, MachineTuning machineTuning) throws InterruptedException {
        System.out.println(operaciones.getCinta());
        System.out.println(machineTuning.dibujarIndicador(operaciones.getCabezal()));

        System.out.println(operaciones.operacion(columna[1], columna[2]));

        System.out.println(" estado actual:" + columna[0]);

        sleep(2000);
        System.out.println("------------");
        System.out.println(operaciones.getCabezal());

    }


}
