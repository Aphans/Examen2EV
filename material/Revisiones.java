package material;

public class Revisiones extends Trabajo {

	public Revisiones(String descripcion,TipoTrabajo tipo) {
		super(descripcion, tipo);
		// TODO Auto-generated constructor stub
	}

	public Revisiones() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public double calcularPrecio() {
		// TODO Auto-generated method stub
		return importeTotal+20;
	}


}
