package br.com.bhas.icabueta.model.repositories;

import br.com.bhas.icabueta.model.entities.Cadeira;

import java.util.ArrayList;
import java.util.List;

public class CadeiraRepository {
    private static List<Cadeira> cadeiras;

    static {
        cadeiras = new ArrayList<>();

        Cadeira c = new Cadeira();
        c.setCodigo(1);
        c.setNome("Desenvolvimento web II");
        c.setAno(2024);
        c.setSemestre(1);
        c.setDescricao("Desenvolvimento web com Java Servlets e JSP.");

        cadeiras.add(c);

        c = new Cadeira();
        c.setCodigo(2);
        c.setNome("Processo de desenvolvimento de software");
        c.setAno(2024);
        c.setSemestre(1);
        c.setDescricao("Mais uma matéria sobre engenharia de software.");

        cadeiras.add(c);
    }

    public static void create(Cadeira c) {
        CadeiraRepository.cadeiras.add(c);
    }

    public static void update(Cadeira c) {
        for (Cadeira cAux: cadeiras) {
            if (cAux.getCodigo() == c.getCodigo()) {
                cAux.setDescricao(c.getDescricao());
                cAux.setAno(c.getAno());
                cAux.setNome(c.getNome());
                cAux.setSemestre(c.getSemestre());

                return;
            }
        }
    }

    public static Cadeira read(int codigo) {
        for (Cadeira cAux: cadeiras) {
            if (cAux.getCodigo() == codigo) {
                return cAux;
            }
        }

        return null;
    }

    public static void delete(int codigo) {
        for (int i = 0; i < cadeiras.size(); i++) {
            if (cadeiras.get(i).getCodigo() == codigo) {
                cadeiras.remove(i);
                return;
            }
        }
    }

    public static List<Cadeira> readAll() {
        return cadeiras;
    }
}
