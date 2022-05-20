package com.salesianostriana.dam.cultodeatenea.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.cultodeatenea.model.LineaVenta;
import com.salesianostriana.dam.cultodeatenea.model.Producto;
import com.salesianostriana.dam.cultodeatenea.repository.LineaVentaRepository;
import com.salesianostriana.dam.cultodeatenea.service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	LineaVentaRepository lineaVentaRepository;
	
	@GetMapping("/")
	public String inicio(Model model) {
		List<Producto> lista = productoService.findAll();
		Collections.shuffle(lista);
		model.addAttribute("listaProductos", lista);
		return "inicio";
	}
	
	@GetMapping("/buscar")
	public String buscar(Model model, @RequestParam String buscar) {
		model.addAttribute("listaProductos", productoService.buscarGeneral(buscar));
		return "inicio";
	}

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
	public String editarProducto(Model model) {
		model.addAttribute("listaProductos", productoService.findAll());
		return "admin/paginaAdminEditarProducto";
	}
	
	@GetMapping("/admin/editarProducto/buscar")
	public String editarProductoBuscar(Model model, @RequestParam String buscar) {
		model.addAttribute("listaProductos", productoService.buscarAdmin(buscar));
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
		lineaVentaRepository.findAll().stream()
		.filter(l -> l.getProducto().getId() == id)
		.collect(Collectors.toList())
		.forEach(l -> l.setProducto(null));
		
		productoService.deleteById(id);
		return "redirect:/admin/editarProducto";
	}


}
