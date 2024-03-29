package com.salesianostriana.dam.cultodeatenea.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.cultodeatenea.model.LineaVenta;
import com.salesianostriana.dam.cultodeatenea.model.Producto;
import com.salesianostriana.dam.cultodeatenea.model.Venta;

@Repository
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoService {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private LineaVentaService lineaVentaService;

	private Map<Producto, Integer> productos = new HashMap<>();


	public void addProducto(Producto p) {
		if (productos.containsKey(p)) {
			productos.replace(p, productos.get(p) + 1);
		} else {
			productos.put(p, 1);
		}
	}

	public void removeProducto(Producto p) {
		if (productos.containsKey(p)) {
			if (productos.get(p) > 1)
				productos.replace(p, productos.get(p) - 1);
			else if (productos.get(p) == 1) {
				productos.remove(p);
			}
		}
	}

	public void removeAllProducto(Producto p) {
		productos.remove(p);
	}

	public Map<Producto, Integer> getProductsInCart() {
		return Collections.unmodifiableMap(productos);
	}
	
	public void limpiarCarrito() {
		productos = new HashMap<>();
	}

	public void checkout() {
		List<LineaVenta> lineas = new ArrayList<LineaVenta>();
		Venta v = Venta
				.builder()
				.productos(lineas)
				.build();
		Optional<Producto> p;
		
		
		if (!productos.isEmpty()) {
			for (Map.Entry<Producto, Integer> entrada : productos.entrySet()) {
				p = productoService.findById(entrada.getKey().getId());
				
				if (p.isPresent()) {
					if (entrada.getValue() >= 1) {
						LineaVenta l = LineaVenta
								.builder()
								.producto(p.get())
								.cantidad(entrada.getValue())
								.build();
						l.addToVenta(v);
					}
				}
			}
			ventaService.save(v);
			
			v.getProductos().stream()
			.forEach(LineaVenta::calcularSubTotal);
			
			v.calcularTotal();
			
			lineaVentaService.saveAll(v.getProductos());
		}
		
		
		limpiarCarrito();
		
	}

}
