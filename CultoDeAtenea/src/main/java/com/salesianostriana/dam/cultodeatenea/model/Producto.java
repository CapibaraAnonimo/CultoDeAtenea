package com.salesianostriana.dam.cultodeatenea.model;

import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
	@Id
	@GeneratedValue
	private long id;

	private String nombre;
	private URL imagen;
	private String marca;
	private String categoria;
	private Double precio;
	private String clasificacion;
	private String descripcion;
	// Campos Opcionales
	private Double longitudTotal; // cm
	private Double longitudHoja; // cm
	private String filo; // Tipo de filo: afilado, sin afilar
	private Double peso; // kg
	private Double grosor; // mm
	private Double anchura; // mm
	private String pomo; // Tipo de pomo
	private Double pdb; // Punto de balance a partir de la guarda, cm
	private Double longitudMango; // cm
	private String acero; // tipo de acero
	private String dimensiones; // dimensiones especificas
	private String fabricante;
	private String pais;

	public Producto(String nombre) {
		this.nombre = nombre;
	}

	public Producto(String nombre, URL imagen, String marca, String categoria, Double precio) {
		this.nombre = nombre;
		this.imagen = imagen;
		this.marca = marca;
		this.categoria = categoria;
		this.precio = precio;
	}

}
