package com.salesianostriana.dam.cultodeatenea.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cultodeatenea.model.Producto;
import com.salesianostriana.dam.cultodeatenea.repository.ProductoRepository;
import com.salesianostriana.dam.cultodeatenea.service.base.ServicioBaseImpl;

@Service
public class ProductoService extends ServicioBaseImpl<Producto, Long, ProductoRepository> {
	
	public List<Producto> buscarAdmin(String cadena) {
	    
		return this.repositorio.findByNombreContainsIgnoreCaseOrMarcaContainsIgnoreCaseOrCategoriaContainsIgnoreCase(cadena, cadena, cadena);
	}
	
//	public List<Producto> buscarAdmin2(String cadena);

}
