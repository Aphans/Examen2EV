package material;

import java.util.ArrayList;

public class Garaje implements Tienda{
	static int contador=0;
	ArrayList<Trabajo> listaTrabajos;
	Resultado resultado;
	TestGaraje gj = new TestGaraje();
	public Garaje() {
		listaTrabajos = new ArrayList<Trabajo>();
	}
	
	public Trabajo getTrabajo(String id) {
		for (int i = 0; i < listaTrabajos.size(); i++) {
			if(listaTrabajos.get(i).getIdTrabajo().equals(id)) return listaTrabajos.get(i);
		}
		return null;
	}
	
	@Override
	public boolean nuevoTrabajo(String descripcion, int tipo) {
		Trabajo trabajo = null;
		TipoTrabajo tipoTrabajo = null;
		contador++;
		switch(tipo) {
		case 1:
			tipoTrabajo = TipoTrabajo.ReparacionMecanica;
			trabajo = new Reparaciones(descripcion, tipoTrabajo); //Reparaciones se hace pasar por trabajo
			break;
		case 2:
			tipoTrabajo = TipoTrabajo.ReparacionChapaYPintura;
			trabajo = new Reparaciones( descripcion, tipoTrabajo);;
			break;
		case 3:
			tipoTrabajo = TipoTrabajo.Revision;
			trabajo = new Revisiones( descripcion, tipoTrabajo);
			break;
		}
         listaTrabajos.add(trabajo);

		return true;
	}

	@Override
	public Resultado añadirHoras(String id, int horas) {
		for (int i = 0; i < listaTrabajos.size(); i++) {
			Trabajo trab = listaTrabajos.get(i);
			if (!trab.getIdTrabajo().equals(id)) continue;
			if (trab.resultado == Resultado.FINALIZADO) return Resultado.FINALIZADO;
			
			trab.incrementarHoras(horas);
		}
		return Resultado.NO_EXISTE;
	}


	@Override
	public double[] finalizarTrabajo(String id) {
		Trabajo trab = getTrabajo(id);
		if (trab == null) return null;
		double total[] = {trab.getTotalhoras(),trab.calcularPrecio()};
		trab.resultado = Resultado.FINALIZADO;
		
		return total;
	}

	@Override
	public String listarTrabajos() {
		return listaTrabajos.toString();
	}

	@Override
	public Resultado duplicarRevision(String id) {
		String start = "T";
		String idTrabajo = start.concat(String.format("%07d",0+1));
		for (int i = 0; i < listaTrabajos.size(); i++) {
			Trabajo trab = listaTrabajos.get(i);
			if(!trab.getIdTrabajo().equals(id)) continue;
			if (trab.getTipo() != TipoTrabajo.Revision) continue;
			
			trab = new Revisiones(trab.descripcion, trab.tipo);
			listaTrabajos.add(trab);
			
			return Resultado.CORRECTO;
		}
	
		return Resultado.NO_EXISTE;
	}

	@Override
	public void eliminarDuplicados() {
		for (int i = 0; i < listaTrabajos.size(); i++) {
			Trabajo trab1 = listaTrabajos.get(i);
			for(int ii = 0; ii < listaTrabajos.size(); ii++) {
				Trabajo trab2 = listaTrabajos.get(ii);
				if (trab1.equals(trab2)) {
					listaTrabajos.remove(ii);
				}
			}
		}
	}

	@Override
	public Resultado añadirMaterial(String id, int importe) {
		for (int i = 0; i < listaTrabajos.size(); i++) {
			Trabajo trab = listaTrabajos.get(i);
			if (!trab.getIdTrabajo().equals(id)) continue;
			if (trab.tipo != TipoTrabajo.ReparacionChapaYPintura &&
					trab.tipo != TipoTrabajo.ReparacionMecanica) return Resultado.TIPO_INCORRECTO;
			if (trab.resultado == Resultado.FINALIZADO) return Resultado.FINALIZADO;
			
			Reparaciones rep = (Reparaciones)trab;
			
			
			rep.usarMaterial(importe);
			
		
		}
		return Resultado.NO_EXISTE ;
	}

}
