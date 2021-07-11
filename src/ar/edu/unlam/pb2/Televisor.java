package ar.edu.unlam.pb2;

public class Televisor extends Electrodomestico implements ITelevisor{

	private Integer pulgadas;
	
	public Televisor(Integer codigo, String descripcion, Integer pulgadas,Integer garantia, String marca, Double precio) {
		super(codigo, descripcion, garantia, marca, precio);
		this.pulgadas=pulgadas;
	}

	@Override
	public Integer getPulgadas() {
		return this.pulgadas;
	}

	

		
}
