package material;

import java.util.Objects;

public abstract class Trabajo {

	//Declaraciones atributos de un trabajo
	String idTrabajo = null;
	String descripcion;
	int Totalhoras,importeTotal;
	TipoTrabajo tipo;
	Resultado resultado;
	static int contador=0;
	String estado;
	
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	//Constructor de la creación de un trabajo
	public Trabajo(String descripcion,TipoTrabajo tipo) {
		String start = "T";
		String idTrabajo = start.concat(String.format("%07d",0)+contador);
		this.idTrabajo=idTrabajo;
		contador++;
		this.descripcion = descripcion;
		this.tipo=tipo;
		this.Totalhoras=0;
	}

	public Trabajo() {
		
	}
	public String getIdTrabajo() {
		return idTrabajo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public TipoTrabajo getTipo() {
		return tipo;
	}
	public int getTotalhoras() {
		return Totalhoras;
	}
	//Incrementar horas
	public Resultado incrementarHoras(int horasDedicadas) {
		if(resultado == Resultado.FINALIZADO) return resultado;
		
		Totalhoras+=horasDedicadas;
		
		return Resultado.CORRECTO;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajo other = (Trabajo) obj;
		return Totalhoras == other.Totalhoras && Objects.equals(descripcion, other.descripcion)
				&& importeTotal == other.importeTotal && resultado == other.resultado && tipo == other.tipo;
	}
	@Override
	public String toString() {
		return getTipo()+"[idTrabajo=" + idTrabajo + ", descripcion=" + descripcion + ", Totalhoras=" + Totalhoras
				+ ", tipo=" + tipo + ", importeTotal=" + importeTotal + "]";
	}
	public abstract double calcularPrecio();


}