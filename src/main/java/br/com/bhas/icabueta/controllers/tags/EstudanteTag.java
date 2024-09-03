package br.com.bhas.icabueta.controllers.tags;

import br.com.bhas.icabueta.model.entities.Estudante;
import br.com.bhas.icabueta.model.repositories.EstudanteRepository;;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class EstudanteTag extends SimpleTagSupport {
    private String codigo;
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        List<Estudante> estudantes = EstudanteRepository
                .readAll()
                .stream()
                .filter(estudante -> estudante.getCodigo() != Integer.parseInt(this.codigo))
                .collect(Collectors.toList());

        getJspContext().setAttribute("estudantes", estudantes, PageContext.REQUEST_SCOPE);
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
