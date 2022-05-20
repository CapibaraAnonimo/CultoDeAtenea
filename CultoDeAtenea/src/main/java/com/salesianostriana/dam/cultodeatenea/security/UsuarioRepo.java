package com.salesianostriana.dam.cultodeatenea.security;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepo {
	
	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return Collections.unmodifiableList(usuarios);
	}

	public Optional<Usuario> findUserByUsername(String username) {
		return usuarios.stream()
				.filter(u -> u.getUsername().equals(username))
				.findFirst();
	}
	
	@PostConstruct
	public void init() {
		usuarios = List.of(
				Usuario.builder()
					.username("admin")
					.password("admin")
					.role("ADMIN")
					.nombre("admin")
					.apellidos("puntual")
					.fechaNacimiento(LocalDate.of(1982, 1, 1))
					.build()
				,
				Usuario.builder()
				.username("user")
				.password("1234")
				.role("USER")
				.nombre("user")
				.apellidos("usual")
				.fechaNacimiento(LocalDate.of(1976, 1, 1))
				.build()
				,
				Usuario.builder()
				.username("1")
				.password("1")
				.role("ADMIN")
				.nombre("1")
				.apellidos("1")
				.fechaNacimiento(LocalDate.of(1982, 1, 1))
				.build()
				);			
	}
}
