package material;
public interface Tienda {
	public boolean nuevoTrabajo(String descripcion, int tipo);
	public Resultado a�adirHoras(String id, int horas);
	public Resultado a�adirMaterial(String id, int importe);
	public double[] finalizarTrabajo(String id);
	public String listarTrabajos();
	public Resultado duplicarRevision(String id);
	public void eliminarDuplicados();
}
