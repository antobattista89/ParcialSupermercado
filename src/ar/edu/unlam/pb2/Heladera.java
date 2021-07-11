package ar.edu.unlam.pb2;

public class Heladera extends Electrodomestico implements IHeladera{
	
	private Boolean isNoFrost;

	public Heladera(Integer codigo, String descripcion, Boolean isNoFrost,Integer garantia, String marca, Double precio) {
		super(codigo, descripcion, garantia, marca, precio);
		this.isNoFrost=isNoFrost;
	}

	@Override
	public Boolean isNoFrost() {
		return this.isNoFrost;
	}

}
