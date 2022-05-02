package com.salesianostriana.dam.cultodeatenea;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.ArrayList;

@Controller
public class ProductoController {

	@GetMapping("/productos")
	public String controladorProducto(Model model) {
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(new Producto("Espada"));
		productos.add(new Producto("Espadón"));
		productos.add(new Producto("Bardiche"));
		
		model.addAttribute("listaProductos", productos);
		return "paginaAdmin";
	}

}
