package org.generation.e_tech_mexico.servicio;

import jakarta.servlet.ServletException;
import org.generation.e_tech_mexico.modelo.Categoria;
import org.generation.e_tech_mexico.repositorio.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria createCategoria(Categoria categoria) throws ServletException {

        Optional<Categoria> categoriaOptional = categoriaRepository.findByNombre(categoria.getNombre());

        if (categoriaOptional.isEmpty()) {
            return categoriaRepository.save(categoria);
        }
        throw new ServletException("Categoría con nombre {" + categoria.getNombre() + "} ya existe");
    }

    public Categoria getCategoria(Long id) throws ServletException {
        return categoriaRepository.findById(id).orElseThrow(() -> new ServletException("La categoría con el id [" + id + "] no existe"));
    }

    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria updateCategoria(Long id, String nombre, String descripcion) throws ServletException {
        if(categoriaRepository.existsById(id)){
            Categoria categoria = categoriaRepository.findById(id).get();

            if(nombre != null) categoria.setNombre(nombre);
            if(descripcion != null) categoria.setDescripcion(descripcion);

            return categoriaRepository.save(categoria);
        }

        throw new ServletException("La categoría con el id [" + id + "] no existe");
    }

    public Categoria deleteCategoria(Long id) throws ServletException {
        if (categoriaRepository.existsById(id)) {
            Categoria deletedCategoria = categoriaRepository.findById(id).get();
            categoriaRepository.deleteById(id);
            return deletedCategoria;
        }
        throw new ServletException("La categoría con el id [" + id + "] no existe");
    }


}