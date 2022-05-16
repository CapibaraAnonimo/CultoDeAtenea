package com.salesianostriana.dam.cultodeatenea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.cultodeatenea.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findByNombreContainsIgnoreCaseOrMarcaContainsIgnoreCaseOrCategoriaContainsIgnoreCase(
			String nombre, String marca, String categoria);

}
