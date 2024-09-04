package br.com.bhas.icabueta.controllers;

import br.com.bhas.icabueta.model.entities.Estudante;
import br.com.bhas.icabueta.model.repositories.EstudanteRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EstudanteController", value = {"/estudante/*"})
public class EstudanteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();

        String[] urlBr = url.split("/");

        System.out.println(req.getSession().getAttribute("eLogado"));

        if (urlBr[1].equals("atualizar")) {
            String nome = req.getParameter("nome");
            String email = req.getParameter("email");
            int anoEntrada = Integer.parseInt(req.getParameter("ano-entrada"));
            String senha = req.getParameter("senha");

            HttpSession session = req.getSession();

            Estudante estudante = (Estudante) session.getAttribute("eLogado");
            estudante.setNome(nome);
            estudante.setEmail(email);
            estudante.setAnoEntrada(anoEntrada);
            estudante.setSenha(senha);

            EstudanteRepository.update(estudante);

            session.setAttribute("msg", "Perfil atualizado com sucesso");
            resp.sendRedirect(req.getContextPath() + "/index-estudante.jsp");
        }
    }
}
