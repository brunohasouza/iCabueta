package br.com.bhas.icabueta.controllers;

import br.com.bhas.icabueta.model.entities.Professor;
import br.com.bhas.icabueta.model.repositories.ProfessorRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProfessorAuth", urlPatterns = {"/professores/*"})
public class ProfessorAuth extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        String[] paths = url.split("/");

        if (paths[1].equals("login")) {
            String path = "";
            String email = req.getParameter("email");
            String senha = req.getParameter("password");

            Professor p = ProfessorRepository.login(email, senha);

            if (p == null) {
                req.getSession().setAttribute("msg", "Usuário e/ou senha incorreto(s).");
                path = "/login-professor.jsp";
            } else {
                req.getSession().setAttribute("pLogado", p);
                path = "/index-professor.jsp";
            }

            resp.sendRedirect(req.getContextPath() + path);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        String paths[] = url.split("/");

        if(paths[1].equals("logout")){
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + "/login-professor.jsp");
            return;
        }

    }
}
