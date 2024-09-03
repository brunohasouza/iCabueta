package br.com.bhas.icabueta.controllers.tags;

import br.com.bhas.icabueta.model.entities.Cadeira;
import br.com.bhas.icabueta.model.entities.Estudante;
import br.com.bhas.icabueta.model.entities.MetodoFila;
import br.com.bhas.icabueta.model.entities.Professor;
import br.com.bhas.icabueta.model.repositories.CadeiraRepository;
import br.com.bhas.icabueta.model.repositories.EstudanteRepository;
import br.com.bhas.icabueta.model.repositories.MetodoFilaRepository;
import br.com.bhas.icabueta.model.repositories.ProfessorRepository;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SetupNovaDenunciaTag extends SimpleTagSupport {
    private String codigo;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        List<Estudante> estudantes = EstudanteRepository
                .readAll()
                .stream()
                .filter(estudante -> estudante.getCodigo() != Integer.parseInt(this.codigo))
                .collect(Collectors.toList());

        List<Professor> professores = ProfessorRepository.readAll();
        List<Cadeira> cadeiras = CadeiraRepository.readAll();
        List<MetodoFila> metodos = MetodoFilaRepository.readAll();

        getJspContext().setAttribute("estudantes", estudantes, PageContext.REQUEST_SCOPE);
        getJspContext().setAttribute("professores", professores, PageContext.REQUEST_SCOPE);
        getJspContext().setAttribute("cadeiras", cadeiras, PageContext.REQUEST_SCOPE);
        getJspContext().setAttribute("metodosFila", metodos, PageContext.REQUEST_SCOPE);
    }
}
