package com.salesianostriana.dam.cultodeatenea.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Venta {
	@Id @GeneratedValue
	private long id;
	
	@OneToMany
	private List<LineaVenta> productos;
	private double total;

}
