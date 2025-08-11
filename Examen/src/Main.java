//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {

    // Procedimiento para mostrar todas las temperaturas
    public static void mostrarTemperaturas(double[] temperaturas) {
        System.out.println("Temperaturas registradas en la semana:");
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.println(dias[i] + ": " + temperaturas[i] + " °C");
        }
    }

    // Función para obtener la temperatura máxima
    public static double obtenerMaxima(double[] temperaturas) {
        double max = temperaturas[0];
        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > max) {
                max = temperaturas[i];
            }
        }
        return max;
    }

    // Metdo sobre cargado con parametros double
    public static void mostrarMaxima(double temperatura) {
        System.out.println("\nLa temperatura máxima es: " + temperatura );
    }

    // Metodo sobre cargado parametro double y string
    public static void mostrarMaxima(double temperatura, String dia) {
        System.out.println("Temperatura máxima fue de " + temperatura);
    }

    // Función recursiva para sumar temperaturas
    public static double sumaRecursiva(double[] temperaturas, int indice) {
        if (indice == temperaturas.length) {
            return 0;
        }
        return temperaturas[indice] + sumaRecursiva(temperaturas, indice + 1);
    }

    //Solicitamos las temperaturas
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] temperaturas = new double[7];
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        boolean salir = false;
        boolean datosIngresados = false;

        do {
            System.out.println("Menú de Opciones ");
            System.out.println("1. Ingresar temperaturas");
            System.out.println("2. Mostrar todas las temperaturas");
            System.out.println("3. Mostrar temperatura máxima");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < 7; i++) {
                        System.out.print("Ingrese la temperatura del " + dias[i] + ": ");
                        temperaturas[i] = scanner.nextDouble();
                    }
                    datosIngresados = true;
                    break;

                case 2:
                    if (datosIngresados) {
                        mostrarTemperaturas(temperaturas);
                        double suma = sumaRecursiva(temperaturas, 0);
                        System.out.println("Suma total de temperaturas (recursiva): " + suma);
                    } else {
                        System.out.println("Primero debe ingresar las temperaturas.");
                    }
                    break;

                case 3:
                    if (datosIngresados) {
                        double max = obtenerMaxima(temperaturas);
                        // Encontrar el día correspondiente
                        String diaMax = "";
                        for (int i = 0; i < temperaturas.length; i++) {
                            if (temperaturas[i] == max) {
                                diaMax = dias[i];
                                break;
                            }
                        }
                        mostrarMaxima(max); // Sin día
                        mostrarMaxima(max, diaMax); // Con día
                    } else {
                        System.out.println("Primero debe ingresar las temperaturas.");
                    }
                    break;

                case 4:
                    salir = true;
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (!salir);

        scanner.close();
    }
}
