package br.com.bhas.icabueta.model.repositories;

import br.com.bhas.icabueta.model.entities.Cadeira;
import br.com.bhas.icabueta.model.entities.Denuncia;
import br.com.bhas.icabueta.model.entities.Estudante;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DenunciaRepository {
    private static List<Denuncia> denuncias;

    static {
        denuncias = new ArrayList<>();

        Denuncia denuncia = new Denuncia();
        List<Estudante> denunciados = new ArrayList<>();

        denunciados.add(EstudanteRepository.read(1));
        denunciados.add(EstudanteRepository.read(2));

        denuncia.setDenunciante(EstudanteRepository.read(3));
        denuncia.setDenunciados(denunciados);
        denuncia.setCadeira(CadeiraRepository.read(1));
        denuncia.setTurno("noite");
        denuncia.setProfessor(ProfessorRepository.read(1));
        denuncia.setCodigo(1);
        denuncia.setMetodoFila(MetodoFilaRepository.read(1));
        denuncia.setDescricao("Filaram de mim e ainda tiraram 0.");
        denuncia.setData(new Date());

        denuncias.add(denuncia);
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
        List<Denuncia> denunciasFiltradas = new ArrayList<>();

        for (Denuncia d: denuncias) {
            if (d.getDenunciante().getCodigo() == e.getCodigo()) {
                denunciasFiltradas.add(d);
            }
        }

        return denunciasFiltradas;
    }
}
