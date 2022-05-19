package com.salesianostriana.dam.cultodeatenea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
	@GetMapping("/noticias")
	public String noticias() {
		return "admin/paginaAdminNoticias";
	}
	
	@GetMapping("/login")
    public String login() {
        return "admin/paginaAdminNoticias";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
        return "redirect:/";
    }

}
