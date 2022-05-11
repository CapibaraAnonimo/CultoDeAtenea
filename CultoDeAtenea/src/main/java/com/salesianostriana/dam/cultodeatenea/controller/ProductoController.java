package com.salesianostriana.dam.cultodeatenea.controller;

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
	public String controladorProducto(Model model) {
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

}
