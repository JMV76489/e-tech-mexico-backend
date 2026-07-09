package org.generation.e_tech_mexico.repositorio;

import org.generation.e_tech_mexico.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // JpaRepository ya tiene implementados findAll, save, findById, etc.
}