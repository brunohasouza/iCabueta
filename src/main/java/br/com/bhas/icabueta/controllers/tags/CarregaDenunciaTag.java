package br.com.bhas.icabueta.controllers.tags;

import br.com.bhas.icabueta.model.entities.Denuncia;
import br.com.bhas.icabueta.model.entities.DenunciaFiltro;
import br.com.bhas.icabueta.model.entities.Estudante;
import br.com.bhas.icabueta.model.entities.Professor;
import br.com.bhas.icabueta.model.repositories.DenunciaRepository;
import br.com.bhas.icabueta.model.repositories.EstudanteRepository;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarregaDenunciaTag extends SimpleTagSupport {
    private DenunciaFiltro filtro;
    private String denunciante;
    private String denunciado;
    private String denuncia;

    public void setFiltro(DenunciaFiltro filtro) {
        this.filtro = filtro;
    }

    public void setDenunciado(String denunciado) {
        this.denunciado = denunciado;
    }

    public void setDenunciante(String denunciante) {
        this.denunciante = denunciante;
    }

    public void setDenuncia(String denuncia) {
        this.denuncia = denuncia;
    }

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        List<Denuncia> denuncias = new ArrayList<>();

        switch (this.filtro) {
            case ESTUDANTE:
                Estudante estudante = (Estudante) getJspContext().getAttribute("eLogado", PageContext.SESSION_SCOPE);
                denuncias = DenunciaRepository.filterBy(estudante);
                break;

            case PROFESSOR:
                Professor professor = (Professor) getJspContext().getAttribute("pLogado", PageContext.SESSION_SCOPE);
                denuncias = DenunciaRepository.filterBy(professor);
                break;

            case FILTRO:
                List<Denuncia> localDenuncias = DenunciaRepository.readAll();

                if (denunciante != null && !denunciante.isEmpty()) {
                    Estudante d = EstudanteRepository.read(Integer.parseInt(denunciante));
                    localDenuncias = DenunciaRepository.filterBy(d);
                }

                if (denunciado != null && !denunciado.isEmpty()) {
                    Estudante d = EstudanteRepository.read(Integer.parseInt(denunciado));
                    localDenuncias = DenunciaRepository.filterBy(d, localDenuncias);
                }

                denuncias = localDenuncias;
                break;

            case DENUNCIA:
                Denuncia d = DenunciaRepository.read(Integer.parseInt(denuncia));
                getJspContext().setAttribute("denuncia", d, PageContext.PAGE_SCOPE);
                break;
        }

        denuncias.sort(Comparator.comparing(Denuncia::getCodigo).reversed());
        getJspContext().setAttribute("denuncias", denuncias, PageContext.PAGE_SCOPE);
    }
}
