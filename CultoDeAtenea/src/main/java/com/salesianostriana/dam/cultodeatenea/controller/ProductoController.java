package com.salesianostriana.dam.cultodeatenea.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.cultodeatenea.model.Producto;
import com.salesianostriana.dam.cultodeatenea.service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	ProductoService productoService;

	@GetMapping("/admin/nuevoProducto")
	public String nuevoProducto(Model model) {
		model.addAttribute("listaProductos", productoService.findAll());
		model.addAttribute("producto", new Producto());
		return "admin/paginaAdminAniadirProducto";
	}

	@PostMapping("/admin/nuevoProducto/submit")
	public String enviarFormularioNuevoProducto(@ModelAttribute("producto") Producto producto) {
		System.out.println(producto);
		productoService.save(producto);
		return "redirect:/admin/nuevoProducto";
	}
	
	@GetMapping("/admin/editarProducto")
	public String editarProducto(Model model) throws MalformedURLException {
		List<Producto> lista = List.of(
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
		
		model.addAttribute("listaProductos", productoService.findAll());
		model.addAttribute("listaProductos", lista);
		return "admin/paginaAdminEditarProducto";
	}

}
