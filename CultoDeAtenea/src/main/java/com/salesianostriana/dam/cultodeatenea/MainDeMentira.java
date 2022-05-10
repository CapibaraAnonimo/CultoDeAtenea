package com.salesianostriana.dam.cultodeatenea;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesianostriana.dam.cultodeatenea.service.LineaVentaService;
import com.salesianostriana.dam.cultodeatenea.service.ProductoService;
import com.salesianostriana.dam.cultodeatenea.service.VentaService;

public class MainDeMentira {
	
	@Autowired
	private ProductoService alumnoService;
	
	@Autowired
	private LineaVentaService lineaVentaService;
	
	@Autowired
	private VentaService ventaService;
	
	@PostConstruct
	public void run() {
		
	}

}
