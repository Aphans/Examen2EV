package material;
public interface Tienda {
	public boolean nuevoTrabajo(String descripcion, int tipo);
	public Resultado añadirHoras(String id, int horas);
	public Resultado añadirMaterial(String id, int importe);
	public double[] finalizarTrabajo(String id);
	public String listarTrabajos();
	public Resultado duplicarRevision(String id);
	public void eliminarDuplicados();
}
