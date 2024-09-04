package br.com.bhas.icabueta.controllers;

import br.com.bhas.icabueta.model.entities.*;
import br.com.bhas.icabueta.model.repositories.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "DenunciaController", value = {"/denuncia"})
public class DenunciaController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cDenunciante = req.getParameter("denunciante");
        String cCadeira = req.getParameter("cadeira");
        String turno = req.getParameter("turno");
        String cProfessor = req.getParameter("professor");
        String cMetodo = req.getParameter("metodo-fila");
        String descricao = req.getParameter("descricao");
        String cData = req.getParameter("data");
        String[] cEstudantes = req.getParameterValues("estudantes");

        int codigo = DenunciaRepository.readAll().size() + 1;
        Cadeira cadeira = CadeiraRepository.read(Integer.parseInt(cCadeira));
        Professor professor = ProfessorRepository.read(Integer.parseInt(cProfessor));
        MetodoFila metodoFila = MetodoFilaRepository.read(Integer.parseInt(cMetodo));
        LocalDate data = LocalDate.parse(cData);
        List<Estudante> denunciados = new ArrayList<>();
        Estudante denunciante = EstudanteRepository.read(Integer.parseInt(cDenunciante));

        for (String id : cEstudantes) {
            denunciados.add(EstudanteRepository.read(Integer.parseInt(id)));
        }

        Denuncia denuncia = new Denuncia();

        Instant instant = data.atStartOfDay(ZoneId.systemDefault()).toInstant();

        denuncia.setCodigo(codigo);
        denuncia.setData(Date.from(instant));
        denuncia.setDescricao(descricao);
        denuncia.setTurno(turno);
        denuncia.setMetodoFila(metodoFila);
        denuncia.setDenunciante(denunciante);
        denuncia.setDenunciados(denunciados);
        denuncia.setCadeira(cadeira);
        denuncia.setProfessor(professor);

        DenunciaRepository.create(denuncia);

        req.getSession().setAttribute("msg", "Denúncia criada com sucesso");
        resp.sendRedirect(req.getContextPath() + "/index-estudante.jsp");
    }
}
