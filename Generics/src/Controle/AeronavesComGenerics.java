package Controle;

import java.util.ArrayList;
import java.util.List;

public class AeronavesComGenerics<T> {

    private List<T> listaAeronaves = new ArrayList<>();

    // Adiciona um voo à fila
    public void addVoo(T nrVoo) {
        listaAeronaves.add(nrVoo);
    }

    // Retorna o primeiro voo (FIFO)
    public T decolar() {
        if (listaAeronaves.isEmpty()) {
            throw new IllegalStateException("Não há aeronaves no pátio");
        }
        return listaAeronaves.get(0);
    }

    // Lista todos os voos
    public void listaVoos() {
        System.out.print(listaAeronaves);
    }
}
