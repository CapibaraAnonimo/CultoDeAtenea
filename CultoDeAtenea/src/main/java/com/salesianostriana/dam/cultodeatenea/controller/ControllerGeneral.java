package com.salesianostriana.dam.cultodeatenea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerGeneral {
	@GetMapping("admin/noticias")
	public String noticias() {
		return "admin/paginaAdminNoticias";
	}

}
