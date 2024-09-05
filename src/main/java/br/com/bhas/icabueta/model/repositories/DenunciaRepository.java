package br.com.bhas.icabueta.model.repositories;

import br.com.bhas.icabueta.model.entities.Cadeira;
import br.com.bhas.icabueta.model.entities.Denuncia;
import br.com.bhas.icabueta.model.entities.Estudante;
import br.com.bhas.icabueta.model.entities.Professor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DenunciaRepository {
    private static List<Denuncia> denuncias;

    static {
        denuncias = new ArrayList<>();
        List<String> turnos = new ArrayList<>();
        turnos.add("manha");
        turnos.add("tarde");
        turnos.add("noite");
        int[] estudantes = { 3, 4, 5 };
        int lastIndex = 1;

        for (int i = 0; i < 20; i++) {
            Denuncia denuncia = new Denuncia();

            int codigo = i + 1;
            int sizeProfessor = ProfessorRepository.readAll().size();
            int sizeCadeira = CadeiraRepository.readAll().size();
            int sizeMetodo = MetodoFilaRepository.readAll().size();
            int limit = estudantes[i % estudantes.length];
            Date data = new Date();
            data.setDate(i + 1);

            List<Estudante> denunciados = new ArrayList<>();

            for (int j = 0; j < limit; j++ ) {
                if (j + 1 < limit) {
                    denunciados.add(EstudanteRepository.read(lastIndex));
                }

                if (lastIndex == EstudanteRepository.readAll().size()) {
                    lastIndex = 1;
                } else {
                    lastIndex += 1;
                }
            }

            denuncia.setDenunciados(denunciados);
            denuncia.setDenunciante(EstudanteRepository.read(lastIndex));
            denuncia.setCodigo(codigo);
            denuncia.setData(data);
            denuncia.setTurno(turnos.get(i % turnos.size()));
            denuncia.setProfessor(ProfessorRepository.read((i % sizeProfessor) + 1));
            denuncia.setCadeira(CadeiraRepository.read((i % sizeCadeira) + 1));
            denuncia.setMetodoFila(MetodoFilaRepository.read((i % sizeMetodo) + 1));
            denuncia.setDescricao("Lorem ipsum iaculis torquent lacinia elementum adipiscing dapibus, cras turpis fermentum nibh magna platea, consequat elementum tortor platea cursus praesent. turpis tincidunt dictum vel metus quis cubilia accumsan.");

            denuncias.add(denuncia);
        }
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

    public static List<Denuncia> filterBy(Professor p) {
        List<Denuncia> denunciasFiltradas = new ArrayList<>();

        for (Denuncia d: denuncias) {
            if (d.getProfessor().getCodigo() == p.getCodigo()) {
                denunciasFiltradas.add(d);
            }
        }

        return denunciasFiltradas;
    }

    public static List<Denuncia> filterBy(Estudante denunciado, List<Denuncia> denuncias) {
        List<Denuncia> denunciasFiltradas = new ArrayList<>();

        for (Denuncia denuncia : denuncias) {
            for (Estudante d : denuncia.getDenunciados()) {
                if (denunciado.getCodigo() == d.getCodigo()) {
                    denunciasFiltradas.add(denuncia);
                }
            }
        }


        return denunciasFiltradas;
    }
}
