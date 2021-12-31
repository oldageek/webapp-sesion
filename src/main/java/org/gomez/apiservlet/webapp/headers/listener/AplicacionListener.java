package org.gomez.apiservlet.webapp.headers.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.gomez.apiservlet.webapp.headers.models.Carro;

@WebListener
public class AplicacionListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {
    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Inicializando la aplicacion");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mensaje", "algun valor no valido");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.log("Destruyendo la aplicacion");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Iniciando el request!");
        sre.getServletRequest().setAttribute("mensaje", "guardando valor para el request");
        sre.getServletRequest().setAttribute("title", "Catalogo Servlet");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        sre.getServletContext().log("Destruyendo el request!");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("Iniciando la session Http");
//        Carro carro = new Carro();
//        HttpSession session = se.getSession();
//        session.setAttribute("carro", carro);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("Destruyendo la session Http");
    }
}
