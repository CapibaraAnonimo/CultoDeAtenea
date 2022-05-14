package com.salesianostriana.dam.cultodeatenea.controller;

import java.net.MalformedURLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("listaProductos", productoService.findAll());
		return "admin/paginaAdminEditarProducto";
	}
	
	@GetMapping("/admin/editarProducto/{id}")
	public String editarProductoId(@PathVariable("id") long id, Model model) {
		Optional<Producto> p = productoService.findById(id);
		
		if(p.isPresent()) {
			model.addAttribute("producto", p.get());
			return "admin/paginaAdminEditarProductoId";
		}
		else {
			return "redirect:/admin/noticias/";
		}
	}
	
	@PostMapping("/admin/editarProducto/submit")
	public String editarProductoSubmit(@ModelAttribute("producto") Producto producto) {
		productoService.edit(producto);
		return "redirect:/admin/editarProducto/";
	}
	
	@GetMapping("/admin/editarProducto/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") long id) {
		productoService.deleteById(id);
		return "redirect:/admin/editarProducto";
	}

}
