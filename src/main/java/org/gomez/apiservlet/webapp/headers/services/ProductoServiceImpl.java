package org.gomez.apiservlet.webapp.headers.services;

import jakarta.enterprise.inject.Alternative;
import org.gomez.apiservlet.webapp.headers.models.Categoria;
import org.gomez.apiservlet.webapp.headers.models.Producto;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@Alternative
public class ProductoServiceImpl  implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebook", "computacion", 12000),
                new Producto(2L, "mesa escritorio", "oficina", 10000),
                new Producto(3L, "teclado mecanico", "computacion", 500));
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return listar().stream().filter(p -> p.getId().equals(id)).findAny();
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Categoria> listarCategoria() {
        return null;
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.empty();
    }
}
