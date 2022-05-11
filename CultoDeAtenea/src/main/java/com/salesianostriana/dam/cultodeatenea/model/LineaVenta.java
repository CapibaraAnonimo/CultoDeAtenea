package com.salesianostriana.dam.cultodeatenea.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LineaVenta {
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Producto producto;
	private int cantidad;
	private double subtotal;

	@ManyToOne
	private Venta venta;
	
	public void addToVenta(Venta venta) {
		this.venta = venta;
		venta.getProductos().add(this);
	}
	
	public void removeFromVenta(Venta curso) {
		venta.getProductos().remove(this);
		this.venta = null;
	}

}
