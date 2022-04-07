 package material;


public class Reparaciones extends Trabajo {
	@Override
	public String toString() {
		return super.toString()+"Reparaciones [importeTotalMaterial=" + importeTotalMaterial + "]";
	}
	int importeTotalMaterial;

	public int getImporteTotalMaterial() {
		return importeTotalMaterial;
	}

	public Reparaciones(String descripcion, TipoTrabajo tipo) {
		super(descripcion, tipo);
	}


	public Reparaciones() {
		// TODO Auto-generated constructor stub
	}

	public double usarMaterial(int importe) {
		return this.importeTotalMaterial+=importe;
	}

	@Override
	public double calcularPrecio() {
		switch(getTipo()) {
		case ReparacionChapaYPintura:
			return importeTotalMaterial * 1.3 + importeTotal;
		case ReparacionMecanica:
			return importeTotalMaterial * 1.1 + importeTotal;
		default:
			return 0;
			
		}
	}

}
	
	


