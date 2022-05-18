package com.salesianostriana.dam.cultodeatenea.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.cultodeatenea.model.Producto;
import com.salesianostriana.dam.cultodeatenea.service.CarritoService;
import com.salesianostriana.dam.cultodeatenea.service.ProductoService;

@Controller
public class CarritoController {

	@Autowired
	private CarritoService carritoService;

	@Autowired
	private ProductoService productoService;

	@GetMapping("/carrito")
	public String mostrarCarrito(Model model) {
		if (model.addAttribute("productos", carritoService.getProductsInCart()) == null)
			return "redirect:/";
		model.addAttribute("productos", carritoService.getProductsInCart());
		return "carrito";
	}
	
	@GetMapping ("/productoCarrito/{id}")
    public String productoACarrito (@PathVariable("id") Long id, Model model) {
    	Optional<Producto> p = productoService.findById(id);
    	if(p.isPresent()) {
    		carritoService.addProducto(p.get());
    	}
    	return "redirect:/carrito";
    }
	
	@GetMapping("/carrito/eliminar/{id}")
	public String eliminarProductoCarrito(@PathVariable("id") long id) {
		System.out.println(id);
		Optional<Producto> p = productoService.findById(id);
		
		if(p.isPresent())
			carritoService.removeProducto(p.get());
		return "redirect:/carrito";
	}
	
	@GetMapping("/carrito/eliminarAll/{id}")
	public String eliminarTodosProductoCarrito(@PathVariable("id") long id) {
		System.out.println(id);
		Optional<Producto> p = productoService.findById(id);
		
		if(p.isPresent())
			carritoService.removeAllProducto(p.get());
		return "redirect:/carrito";
	}
	
	@GetMapping("carrito/checkout")
	public String checkout(Model model) {
		carritoService.checkout();
		return "redirect:/";
	}

}
