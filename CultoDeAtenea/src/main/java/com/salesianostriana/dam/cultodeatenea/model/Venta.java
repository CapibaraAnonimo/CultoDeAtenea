package com.salesianostriana.dam.cultodeatenea.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venta {
	@Id
	@GeneratedValue
	private long id;

	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "venta", fetch = FetchType.EAGER)
	private List<LineaVenta> productos = new ArrayList<>();
	private double total;

	public void calcularTotal() {
		total = 0;
		Double t = productos
				.stream()
				.mapToDouble(LineaVenta::getSubtotal)
				.sum();
		System.out.println(t);
		total = t;
	}

}
