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

		// Variables para usar en las opciones del men�
		Resultado resultado;
		String id;

		while(opcion!=0) {
			switch(opcion) {

			// 1- Crear trabajo
			case 1:
				System.out.println("Introduzca la descripci�n del trabajo:");
				String descripcion = entrada.nextLine();
				System.out.println("Introduzca el tipo de trabajo (reparaci�n mec�nica(1), reparaci�n de chapa y pintura(2) o revisi�n(3)):");
				int tipo = entrada.nextInt();
				entrada.nextLine();
				System.out.println(garaje.nuevoTrabajo(descripcion, tipo));
				break;

				// 2- A�adir horas a un trabajo
			case 2:
				System.out.println("Introduzca el id del trabajo:");
				id = entrada.next();
				System.out.println("Introduzca el n�mero de horas:");
				int horas = entrada.nextInt();
				garaje.a�adirHoras(id, horas);
				break;

				// 3- A�adir coste material a un trabajo
			case 3:
				System.out.println("Introduzca el id del trabajo:");
				id = entrada.nextLine();
				System.out.println("Introduzca el importe del material:");
				int importe = entrada.nextInt();
				garaje.a�adirMaterial(id, importe);
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

				// 6- Duplicar revisi�n
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
			// Mostramos men� y pedimos nueva opci�n
			mostrarMenu();
			opcion = entrada.nextInt();
			entrada.nextLine();
		}

		// Fin del programa
		System.out.println("Saliendo del programa");
		entrada.close();
	}

	// Mostrar el men� principal
	public static void mostrarMenu() {
		System.out.println("Elija una opci�n:");
		System.out.println("1- Crear un trabajo");
		System.out.println("2- A�adir horas a un trabajo");
		System.out.println("3- A�adir coste material a un trabajo");
		System.out.println("4- Listar trabajos");
		System.out.println("5- Finalizar trabajo");
		System.out.println("6- Duplicar revisi�n");
		System.out.println("7- Eliminar duplicados");
		System.out.println("0- Salir");
	}

	// Mostrar resultado obtenido en la operaci�n
	public static void mostrarResultado(Resultado resultado) {
		switch(resultado) {
		case CORRECTO:
			System.out.println("La operaci�n se ha realizado correctamente");
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
