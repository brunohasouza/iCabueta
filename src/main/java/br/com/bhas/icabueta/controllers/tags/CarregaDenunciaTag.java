package br.com.bhas.icabueta.controllers.tags;

import br.com.bhas.icabueta.model.entities.Denuncia;
import br.com.bhas.icabueta.model.entities.Estudante;
import br.com.bhas.icabueta.model.repositories.DenunciaRepository;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class CarregaDenunciaTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        Estudante estudante = (Estudante) getJspContext().getAttribute("eLogado", PageContext.SESSION_SCOPE);
        List<Denuncia> denuncias = DenunciaRepository.filterBy(estudante);
        getJspContext().setAttribute("denuncias", denuncias, PageContext.PAGE_SCOPE);
    }
}
