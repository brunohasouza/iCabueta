package br.com.bhas.icabueta.model.repositories;

import br.com.bhas.icabueta.model.entities.Estudante;

import java.util.ArrayList;
import java.util.List;

public class EstudanteRepository {
    private static List<Estudante> estudantes;

    static {
        estudantes = new ArrayList<>();

        Estudante e = new Estudante();
        e.setCodigo(1);
        e.setNome("Bruno Henrique de Araújo Souza");
        e.setEmail("bruno.henrique@email.com");
        e.setAnoEntrada(2018);
        e.setSenha("123456");

        estudantes.add(e);

        e = new Estudante();
        e.setCodigo(2);
        e.setNome("Henrique Bruno de Souza Araújo");
        e.setEmail("henrique.bruno@email.com");
        e.setAnoEntrada(2020);
        e.setSenha("789012");

        estudantes.add(e);

        e = new Estudante();
        e.setCodigo(3);
        e.setNome("Bruno Souza");
        e.setEmail("bruno@email.com");
        e.setAnoEntrada(2019);
        e.setSenha("123456");

        estudantes.add(e);
    }

    public static void create(Estudante e) {
        EstudanteRepository.estudantes.add(e);
    }

    public static void update(Estudante e) {
        for (Estudante eAux: estudantes) {
            if (eAux.getCodigo() == e.getCodigo()) {
                eAux.setNome(e.getNome());
                eAux.setEmail(e.getEmail());
                eAux.setAnoEntrada(e.getAnoEntrada());
                eAux.setSenha(e.getSenha());

                return;
            }
        }
    }

    public static Estudante read(int codigo) {
        for (Estudante eAux: estudantes) {
            if (eAux.getCodigo() == codigo) {
                return eAux;
            }
        }

        return null;
    }

    public static void delete(int codigo) {
        for (int i = 0; i < estudantes.size(); i++) {
            if (estudantes.get(i).getCodigo() == codigo) {
                estudantes.remove(i);
                return;
            }
        }
    }

    public static List<Estudante> readAll() {
        return estudantes;
    }

    public static Estudante login(String email, String senha){
        for(Estudante e: estudantes){
            if(e.getEmail().equals(email) && e.getSenha().equals(senha)){
                return e;
            }
        }

        return null;
    }
}
