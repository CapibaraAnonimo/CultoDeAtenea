package com.salesianostriana.dam.cultodeatenea;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.cultodeatenea.model.Producto;

import java.util.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@Controller
public class ProductoController {

	@GetMapping("admin/nuevoProducto")
	public String controladorProducto(Model model) {
		List<Producto> productos = new ArrayList<Producto>();

		try {
			productos.add(new Producto("Espada", new URL(
					"https://s3.amazonaws.com/koa-media-library/wp-media-folder-kult-of-athena/wp-content/uploads/2021/11/DSC3686.jpg"),
					"Albion", "Espada", 1000));
			productos.add(new Producto("Espadón", new URL(
					"https://s3.amazonaws.com/koa-media-library/wp-media-folder-kult-of-athena//www/wp-content/uploads/2020/11/DT5161_1_L.jpg"),
					"Albion", "Espada", 1250));
			productos.add(new Producto("Bardiche", new URL(
					"https://s3.amazonaws.com/koa-media-library/wp-media-folder-kult-of-athena//www/wp-content/uploads/2020/11/AH3508_2_L.jpg"),
					"Albion", "Arma de Asta", 800));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("listaProductos", productos);
		return "admin/paginaAdminAniadirProducto";
	}

}
