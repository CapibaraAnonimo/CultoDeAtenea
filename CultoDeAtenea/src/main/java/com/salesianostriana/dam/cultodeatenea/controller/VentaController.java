package com.salesianostriana.dam.cultodeatenea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.cultodeatenea.service.VentaService;

@Controller
public class VentaController {
	
	@Autowired
	VentaService ventaService;
	
	@GetMapping("admin/ventas")
	public String mostrarVentas(Model model) {
		model.addAttribute("listaVentas", ventaService.findAll());
		return "admin/paginaAdminVentas";
	}

}
