package com.salesianostriana.dam.cultodeatenea.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data @RequiredArgsConstructor
public class LineaVenta {
	private long idLineaVenta;
	private Producto producto;
	private int cantidad;
	private double subtotal;

}
