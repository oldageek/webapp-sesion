package org.gomez.apiservlet.webapp.headers.configs;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@ApplicationScoped
public class ProducerResourses {
    @Inject
    private Logger log;

    @Resource(name = "jdbc/mysqlDB")
    private DataSource ds;

    @Produces
    @RequestScoped
    @MySQLConn
    private Connection beanConnection() throws NamingException, SQLException {
        return ds.getConnection();
    }

//    Entrega info de la clase, en la cual vamos a inyectar este beans
    @Produces
    private Logger beanLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

//    Cierra la conexion
    public void close(@Disposes @MySQLConn Connection connection) throws SQLException {
        connection.close();
        log.info("Cerrando la conexion a la ddbb mysql!");
    }
}
