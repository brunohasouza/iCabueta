package br.com.bhas.icabueta.controllers;

import br.com.bhas.icabueta.model.entities.Professor;
import br.com.bhas.icabueta.model.repositories.ProfessorRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "ProfessorController", value = {"/professor/*"})
public class ProfessorController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();

        String[] path = url.split("/");

        if (path[1].equals("atualizar")) {
            String nome = req.getParameter("nome");
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");

            HttpSession session = req.getSession();
            Professor professor = (Professor) session.getAttribute("pLogado");
            professor.setNome(nome);
            professor.setEmail(email);
            professor.setSenha(senha);

            ProfessorRepository.update(professor);
            session.setAttribute("msg", "Professor atualizado com sucesso");
            resp.sendRedirect(req.getContextPath() + "/index-professor.jsp");
        }
    }
}
