package br.com.bhas.icabueta.controllers.tags;

import br.com.bhas.icabueta.model.entities.Estudante;
import br.com.bhas.icabueta.model.repositories.EstudanteRepository;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;
import java.util.List;

public class EstudanteTag extends SimpleTagSupport {
    private String codigo;
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        if (codigo == null || codigo.isEmpty()) {
            List<Estudante> estudantes = EstudanteRepository.readAll();
            getJspContext().setAttribute("estudantes", estudantes, PageContext.REQUEST_SCOPE);
        } else {
            Estudante e = EstudanteRepository.read(Integer.parseInt(codigo));
            getJspContext().setAttribute("estudante", e, PageContext.REQUEST_SCOPE);
        }
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
