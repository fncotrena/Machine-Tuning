package Test;

import java.util.Scanner;

public class Menu {
    public Menu() {
    }

    public String Mensaje(){
        System.out.println(" Maquina de tuning ");

        System.out.println("Ingrese el archivo a cargar");

        System.out.println("Ingrese 1 para Sucesor Binario");

        System.out.println("Ingrese 2 para Antecesor Binario");

        System.out.println("Ingrese 3 Ejemplo.csv");

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        return s;


    }
}
