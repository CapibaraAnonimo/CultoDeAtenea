package com.salesianostriana.dam.cultodeatenea;

import org.springframework.web.bind.annotation.GetMapping;

public class ControllerGeneral {
	@GetMapping("admin/noticias")
	public String noticias() {
		return "admin/paginaAdminNoticias";
	}

}
