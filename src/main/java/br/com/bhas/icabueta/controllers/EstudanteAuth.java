package br.com.bhas.icabueta.controllers;

import br.com.bhas.icabueta.model.entities.Estudante;
import br.com.bhas.icabueta.model.repositories.EstudanteRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EstudanteAuth", urlPatterns = {"/estudantes/*"})
public class EstudanteAuth extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        String[] paths = url.split("/");

        if (paths[1].equals("login")) {
            String path = "";
            String email = req.getParameter("email");
            String senha = req.getParameter("password");

            Estudante eLogado = EstudanteRepository.login(email, senha);

            if (eLogado == null) {
                req.getSession().setAttribute("msg", "Usuário e/ou senha inválido(s).");
                path = "/login-estudante.jsp";
            } else {
                req.getSession().setAttribute("eLogado", eLogado);
                path = "/index-estudante.jsp";
            }

            resp.sendRedirect(req.getContextPath() + path);
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        String paths[] = url.split("/");

        if(paths[1].equals("logout")){
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + "/login-estudante.jsp");
            return;
        }
    }
}
