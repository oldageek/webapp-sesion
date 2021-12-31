package org.gomez.apiservlet.webapp.headers.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.gomez.apiservlet.webapp.headers.models.Usuario;
import org.gomez.apiservlet.webapp.headers.services.LoginService;
import org.gomez.apiservlet.webapp.headers.services.LoginServiceSessionImpl;
import org.gomez.apiservlet.webapp.headers.services.UsuarioService;
import org.gomez.apiservlet.webapp.headers.services.UsuarioServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
    @Inject
    private UsuarioService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuarios = service.listar();

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        req.setAttribute("usuarios", usuarios);
        req.setAttribute("username", usernameOptional);

        req.setAttribute("title", req.getAttribute("title") + ": Listado de usuarios");
        getServletContext().getRequestDispatcher("/listarUsuario.jsp").forward(req, resp);
    }
}
