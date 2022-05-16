package com.salesianostriana.dam.cultodeatenea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.cultodeatenea.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	@Query("Select p from Producto p WHERE lower(p.nombre) LIKE lower(concat('%', :cadena, '%')) OR lower(p.marca) LIKE lower(concat('%', :cadena, '%')) OR lower(p.categoria) LIKE lower(concat('%', :cadena, '%')) OR lower(p.id) LIKE lower(concat('%', :cadena, '%'))")
	public 	List<Producto> buscarAdmin(String cadena);

}
