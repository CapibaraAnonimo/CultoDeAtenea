package com.salesianostriana.dam.cultodeatenea.model;

import java.net.URL;
import java.util.Locale.IsoCountryCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Producto {
	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private URL imagen;
	private String marca;
	private String categoria;
	private double precio;
	private String clasificacion;
	private String descripcion;
	//Campos Opcionales
	private double longitudTotal; //cm
	private double longitudHoja; //cm
	private String filo; //Tipo de filo: afilado, sin afilar
	private double peso; //kg
	private double grosor; //mm
	private double anchura; //mm
	private String pomo; //Tipo de pomo
	private double pdb; //Punto de balance a partir de la guarda, cm
	private double longitudMango; //cm
	private String acero; //tipo de acero
	private String dimensiones; //dimensiones especificas
	private String fabricante;
	private IsoCountryCode pais;
	
	public Producto(String nombre) {
		this.nombre = nombre;
	}

	public Producto(String nombre, URL imagen, String marca, String categoria, int precio) {
		this.nombre = nombre;
		this.imagen = imagen;
		this.marca = marca;
		this.categoria = categoria;
		this.precio = precio;
	}
	
}