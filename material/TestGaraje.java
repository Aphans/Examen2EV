package material;
import java.util.Scanner;

public class TestGaraje {
	public static void main(String[] args) {
		// Crear un garaje.
		Garaje garaje = new Garaje();

		Scanner entrada = new Scanner(System.in);
		mostrarMenu();
		int opcion = entrada.nextInt();
		entrada.nextLine();

		// Variables para usar en las opciones del menú
		Resultado resultado;
		String id;

		while(opcion!=0) {
			switch(opcion) {

			// 1- Crear trabajo
			case 1:
				System.out.println("Introduzca la descripción del trabajo:");
				String descripcion = entrada.nextLine();
				System.out.println("Introduzca el tipo de trabajo (reparación mecánica(1), reparación de chapa y pintura(2) o revisión(3)):");
				int tipo = entrada.nextInt();
				entrada.nextLine();
				System.out.println(garaje.nuevoTrabajo(descripcion, tipo));
				break;

				// 2- Añadir horas a un trabajo
			case 2:
				System.out.println("Introduzca el id del trabajo:");
				id = entrada.next();
				System.out.println("Introduzca el número de horas:");
				int horas = entrada.nextInt();
				garaje.añadirHoras(id, horas);
				break;

				// 3- Añadir coste material a un trabajo
			case 3:
				System.out.println("Introduzca el id del trabajo:");
				id = entrada.nextLine();
				System.out.println("Introduzca el importe del material:");
				int importe = entrada.nextInt();
				garaje.añadirMaterial(id, importe);
				break;

				// 4- Listar trabajos
			case 4:
				System.out.println(garaje.listarTrabajos());
				break;

				// 5- Finalizar trabajo
			case 5:
				System.out.println("Introduzca el id del trabajo:");
				id = entrada.nextLine();
				double a[] = garaje.finalizarTrabajo(id);
				System.out.println("Horas: " + a[0] + ", precio: " + a[1]);
				break;

				// 6- Duplicar revisión
			case 6:
				System.out.println("Introduzca el id del trabajo:");
				id = entrada.nextLine();
				System.out.println(garaje.duplicarRevision(id));
				break;

				// 7- Eliminar duplicados
			case 7:
				// TODO: llamada para eliminar duplicados
				garaje.eliminarDuplicados();
				break;

				// Desconocido- Salir del programa
			default:
				opcion = 0;
			}
			// Mostramos menú y pedimos nueva opción
			mostrarMenu();
			opcion = entrada.nextInt();
			entrada.nextLine();
		}

		// Fin del programa
		System.out.println("Saliendo del programa");
		entrada.close();
	}

	// Mostrar el menú principal
	public static void mostrarMenu() {
		System.out.println("Elija una opción:");
		System.out.println("1- Crear un trabajo");
		System.out.println("2- Añadir horas a un trabajo");
		System.out.println("3- Añadir coste material a un trabajo");
		System.out.println("4- Listar trabajos");
		System.out.println("5- Finalizar trabajo");
		System.out.println("6- Duplicar revisión");
		System.out.println("7- Eliminar duplicados");
		System.out.println("0- Salir");
	}

	// Mostrar resultado obtenido en la operación
	public static void mostrarResultado(Resultado resultado) {
		switch(resultado) {
		case CORRECTO:
			System.out.println("La operación se ha realizado correctamente");
			break;
		case NO_EXISTE:
			System.out.println("No se han encontrado resultados");
			break;
		case FINALIZADO:
			System.out.println("El trabajo ha sido finalizado");
			break;
		case TIPO_INCORRECTO:
			System.out.println("El trabajo no es del tipo correcto");
			break;


		}
	}
}
