package com.salesianostriana.dam.cultodeatenea.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class LineaVenta {
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	private Producto producto;
	private int cantidad;
	private double subtotal;

}
