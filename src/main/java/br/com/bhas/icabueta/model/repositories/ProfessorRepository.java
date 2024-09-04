package br.com.bhas.icabueta.model.repositories;

import br.com.bhas.icabueta.model.entities.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private static List<Professor> professores;

    static {
        professores = new ArrayList<>();

        Professor p = new Professor();
        p.setCodigo(1);
        p.setNome("Eduardo de Melo Vasconcelos");
        p.setEmail("eduardo@ifpe.com");
        p.setSenha("123456");

        professores.add(p);

        p = new Professor();
        p.setCodigo(2);
        p.setNome("Tatiane Catarina Fogaça");
        p.setEmail("tatiane@ifpe.com");
        p.setSenha("654321");

        professores.add(p);

        p = new Professor();
        p.setCodigo(3);
        p.setNome("Guilherme Gustavo Ribeiro");
        p.setEmail("guilherme@ifpe.com");
        p.setSenha("123123");

        professores.add(p);
    }

    public static void create(Professor p) {
        ProfessorRepository.professores.add(p);
    }

    public static void update(Professor p) {
        for (Professor pAux: professores) {
            if (pAux.getCodigo() == p.getCodigo()) {
                pAux.setNome(p.getNome());
                pAux.setEmail(p.getEmail());
                pAux.setSenha(p.getSenha());

                return;
            }
        }
    }

    public static Professor read(int codigo) {
        for (Professor pAux: professores) {
            if (pAux.getCodigo() == codigo) {
                return pAux;
            }
        }

        return null;
    }

    public static void delete(int codigo) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getCodigo() == codigo) {
                professores.remove(i);
                return;
            }
        }
    }

    public static List<Professor> readAll() {
        return professores;
    }
    public static Professor login(String email, String senha){
        for(Professor p: professores){
            if(p.getEmail().equals(email) && p.getSenha().equals(senha)){
                return p;
            }
        }

        return null;
    }
}
