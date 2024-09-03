package br.com.bhas.icabueta.model.repositories;

import br.com.bhas.icabueta.model.entities.MetodoFila;

import java.util.ArrayList;
import java.util.List;

public class MetodoFilaRepository {
    private static List<MetodoFila> metodos;

    static {
        metodos = new ArrayList<>();

        MetodoFila m = new MetodoFila();
        m.setCodigo(1);
        m.setDescricaoCurta("Fila entre os dedos.");
        m.setDescricaoLonga("Os estudantes colocam as filas entre os dedos das mãos ou dos pés.");

        metodos.add(m);
    }

    public static void create(MetodoFila m) {
        MetodoFilaRepository.metodos.add(m);
    }

    public static void update(MetodoFila m) {
        for (MetodoFila mAux: metodos) {
            if (mAux.getCodigo() == m.getCodigo()) {
                mAux.setDescricaoLonga(m.getDescricaoLonga());
                mAux.setDescricaoCurta(m.getDescricaoCurta());

                return;
            }
        }
    }

    public static MetodoFila read(int codigo) {
        for (MetodoFila mAux: metodos) {
            if (mAux.getCodigo() == codigo) {
                return mAux;
            }
        }

        return null;
    }

    public static void delete(int codigo) {
        for (int i = 0; i < metodos.size(); i++) {
            if (metodos.get(i).getCodigo() == codigo) {
                metodos.remove(i);
                return;
            }
        }
    }

    public static List<MetodoFila> readAll() {
        return metodos;
    }
}
