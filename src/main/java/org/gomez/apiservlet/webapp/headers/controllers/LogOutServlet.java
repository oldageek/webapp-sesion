package org.gomez.apiservlet.webapp.headers.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.gomez.apiservlet.webapp.headers.services.LoginService;
import org.gomez.apiservlet.webapp.headers.services.LoginServiceCookieImpl;
import org.gomez.apiservlet.webapp.headers.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    @Inject
    private  LoginService auth;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> username = auth.getUsername(req);
        if (username.isPresent()) {
            HttpSession session = req.getSession();
            session.invalidate();
        }

        resp.sendRedirect(req.getContextPath() + "/login.html");
    }
}
