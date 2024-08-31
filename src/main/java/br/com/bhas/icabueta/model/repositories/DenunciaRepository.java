package br.com.bhas.icabueta.model.repositories;

import br.com.bhas.icabueta.model.entities.Denuncia;
import br.com.bhas.icabueta.model.entities.Estudante;

import java.util.ArrayList;
import java.util.List;

public class DenunciaRepository {
    private static List<Denuncia> denuncias;

    static {
        denuncias = new ArrayList<>();
    }

    public static void create(Denuncia d) {
        DenunciaRepository.denuncias.add(d);
    }

    public static void update(Denuncia d) {
        for (Denuncia dAux: denuncias) {
            if (dAux.getCodigo() == d.getCodigo()) {
                dAux.setCadeira(d.getCadeira());
                dAux.setData(d.getData());
                dAux.setDenunciante(d.getDenunciante());
                dAux.setProfessor(d.getProfessor());
                dAux.setMetodoFila(d.getMetodoFila());
                dAux.setTurno(d.getTurno());

                return;
            }
        }
    }

    public static Denuncia read(int codigo) {
        for (Denuncia dAux: denuncias) {
            if (dAux.getCodigo() == codigo) {
                return dAux;
            }
        }

        return null;
    }

    public static void delete(int codigo) {
        for (int i = 0; i < denuncias.size(); i++) {
            if (denuncias.get(i).getCodigo() == codigo) {
                denuncias.remove(i);
                return;
            }
        }
    }

    public static List<Denuncia> readAll() {
        return denuncias;
    }

    public static List<Denuncia> filterBy(Estudante e) {
        List<Denuncia> denuncias = new ArrayList<>();

        for (Denuncia d: denuncias) {
            if (d.getDenunciante().getCodigo() == e.getCodigo()) {
                denuncias.add(d);
            }
        }

        return denuncias;
    }
}
