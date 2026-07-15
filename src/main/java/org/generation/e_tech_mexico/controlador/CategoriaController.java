package org.generation.e_tech_mexico.controlador;

import jakarta.servlet.ServletException;
import org.generation.e_tech_mexico.modelo.Categoria;
import org.generation.e_tech_mexico.servicio.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categorias/")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) throws ServletException {
        return categoriaService.createCategoria(categoria);
    }

    @GetMapping("{categoriaId}")
    public Categoria getCategoria(@PathVariable("categoriaId") Long id) throws ServletException {
        return categoriaService.getCategoria(id);
    }

    @GetMapping
    public List<Categoria> getCategorias() {
        return categoriaService.getCategorias();
    }

    @PutMapping("{categoriaId}")
    public Categoria updateCategoria(@PathVariable("categoriaId") Long id,
                                     @RequestParam(name = "nombre", required = false) String nombre,
                                     @RequestParam(name = "descripcion", required = false) String descripcion
    ) throws ServletException {
        return categoriaService.updateCategoria(id,nombre,descripcion);
    }

    @DeleteMapping("{categoriaId}")
    public Categoria deleteCategoria(@PathVariable("categoriaId") Long id) throws ServletException {
        return categoriaService.deleteCategoria(id);
    }


}
