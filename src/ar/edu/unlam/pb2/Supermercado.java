package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Supermercado {

	String nombre; // Nombre del supermercado
	private Set<Producto> productosExistentes; // Listado de productos que se comercializan
	private List<Producto> productosDisponibles; // Detalle de cada producto ingresado
	private Map<Integer, Venta> ventasRealizadas; // Listado de ventas realizadas (identificadas por el número de venta)
	Integer contadorDeVentas; // Identificador del número de venta

	public Supermercado(String nombre) {
		this.nombre = nombre;
		this.contadorDeVentas = 0;
		this.productosExistentes = new HashSet<Producto>();
		this.productosDisponibles = new ArrayList<Producto>();
		this.ventasRealizadas = new HashMap<Integer,Venta>();
	}

	public void ingresarProducto(Producto nuevo) {
		this.productosExistentes.add(nuevo);
		this.productosDisponibles.add(nuevo);
	}

	public Set<Producto> getOfertaDeProductos() {
		// Devuelve el conjunto de productos que s
		return this.productosExistentes;

	}

	public Integer getStock(Integer codigo) {
		// Devuelve la cantidad de unidades de un producto determinado
		Integer cantidadStock = 0;
		for (Producto productos : productosDisponibles) {
			if (productos.getCodigo().equals(codigo)) {
				cantidadStock++;
			}
		}
		return cantidadStock;
	}

	private Boolean productoExiste(Integer codigoDeProducto) throws ProductoInexistente {
		// Verifica si un producto existe
		for (Producto productos : productosExistentes) {
			if (productos.getCodigo().equals(codigoDeProducto)) {
				return true;
			}
		}
		throw new ProductoInexistente();

	}

	private Producto getProductoPorCodigo(Integer codigoDeProducto) throws ProductoSinStock {
		// Busca la disponibilidad de un producto
		for (Producto productos : productosDisponibles) {
			if (productos.getCodigo().equals(codigoDeProducto)) {
				return productos;
			}

		}
		throw new ProductoSinStock();
	}

	public Integer registrarNuevaVenta(Integer dniDelComprador, String nombreDelComprador) {
		// Registra una nueva venta
		ventasRealizadas.put(++contadorDeVentas, new Venta(dniDelComprador, nombreDelComprador));
		return contadorDeVentas;
	}

	public Venta getVenta(Integer nueroDeVenta) {
		// Devuelve una venta en función de su número identificatorio
		return this.ventasRealizadas.get(nueroDeVenta);
	}

	public void agregarAlCarrito(Integer numeroDeVenta, Integer codigoDeProducto)
			throws ProductoSinStock, ProductoInexistente {
		// Incorpora al carrito de compras de la venta identificada por el
		// "numeroDeVenta", el producto identificado por el "codigoDeProducto"

		if (this.productoExiste(codigoDeProducto)) {

			if (this.getStock(codigoDeProducto) > 0) {

				this.getVenta(numeroDeVenta).getCarrito().add(this.getProductoPorCodigo(codigoDeProducto));
			}
			else {
				
				throw new ProductoSinStock();
			}
			
		} else {

			throw new ProductoInexistente();
		}
	}
}
