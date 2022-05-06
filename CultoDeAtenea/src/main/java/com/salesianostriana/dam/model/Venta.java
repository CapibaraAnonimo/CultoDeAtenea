package com.salesianostriana.dam.model;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data @RequiredArgsConstructor
public class Venta {
	private long idVenta;
	private List<LineaVenta> productos;
	private double total;

}
