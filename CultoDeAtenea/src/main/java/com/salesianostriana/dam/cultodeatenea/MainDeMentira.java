package com.salesianostriana.dam.cultodeatenea;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.cultodeatenea.model.Producto;
import com.salesianostriana.dam.cultodeatenea.service.ProductoService;

@Component
public class MainDeMentira {
	
	@Autowired
	private ProductoService productoService;
	
//	@Autowired
//	private LineaVentaService lineaVentaService;
//	
//	@Autowired
//	private VentaService ventaService;
	
	@PostConstruct
	public void run() throws MalformedURLException {
		
		List<Producto> productos = List.of(
				Producto
				.builder()
				.nombre("Espada")
				.imagen(new URL("https://s3.amazonaws.com/koa-media-library/wp-media-folder-kult-of-athena/wp-content/uploads/2021/11/DSC3686.jpg"))
				.fabricante("Albion")
				.categoria("Espada")
				.precio(1000.0)
				.build()
				,
				Producto
				.builder()
				.nombre("Espadón")
				.imagen(new URL("https://s3.amazonaws.com/koa-media-library/wp-media-folder-kult-of-athena//www/wp-content/uploads/2020/11/DT5161_1_L.jpg"))
				.fabricante("Albion")
				.categoria("Espada")
				.precio(1250.0)
				.build()
				,
				Producto
				.builder()
				.nombre("Bardiche")
				.imagen(new URL("https://s3.amazonaws.com/koa-media-library/wp-media-folder-kult-of-athena//www/wp-content/uploads/2020/11/AH3508_2_L.jpg"))
				.fabricante("Albion")
				.categoria("Arma de Asta")
				.precio(800.0)
				.build()
				);
		
		for(Producto p : productos) {
			System.out.println(p);
		}
		productoService.saveAll(productos);
		
	}

}
