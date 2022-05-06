package com.salesianostriana.dam.cultodeatenea;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data @RequiredArgsConstructor
public class LineaVenta {
	private Producto producto;
	private int cantidad;
	private double subtotal;

}
