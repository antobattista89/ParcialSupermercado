package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Venta {
	
	private Integer dniDelComprador;
	private String nombreDelComprador;
	private List<Producto>carrito;
	
	public Venta(Integer dniDelComprador, String nombreDelComprador) {
		this.dniDelComprador = dniDelComprador;
		this.nombreDelComprador = nombreDelComprador;
		this.carrito=new ArrayList<Producto>();
	}

	public Integer getDniDelComprador() {
		return dniDelComprador;
	}

	public void setDniDelComprador(Integer dniDelComprador) {
		this.dniDelComprador = dniDelComprador;
	}

	public String getNombreDelComprador() {
		return nombreDelComprador;
	}

	public void setNombreDelComprador(String nombreDelComprador) {
		this.nombreDelComprador = nombreDelComprador;
	}

	public List<Producto> getCarrito() {
		return carrito;
	}

	public Double getImporte() {
		Double totalCarrito = 0.0;
		for(Producto producto: carrito ) {			
			totalCarrito += producto.getPrecio();
			
		}
		return totalCarrito;
	}
	
	

}
