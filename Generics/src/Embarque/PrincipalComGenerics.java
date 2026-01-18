package Embarque;

import java.util.Scanner;
import javax.swing.JOptionPane;
import Controle.AeronavesComGenerics;

public class PrincipalComGenerics {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Agora a fila trabalha com String
        AeronavesComGenerics<String> air = new AeronavesComGenerics<>();

        System.out.println("Informe o nr de aeronaves");
        int nrAeronaves = sc.nextInt();

        // adicionando voos
        for (int i = 0; i < nrAeronaves; i++) {
            String nrVoo = JOptionPane.showInputDialog("Informe o número do voo");
            air.addVoo(nrVoo);
        }

        // obtendo o primeiro voo (FIFO)
        String primeiro = air.decolar();

        System.out.println("O primeiro a decolar será o voo: " + primeiro);

        sc.close();
    }
}
