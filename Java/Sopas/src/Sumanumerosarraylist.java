import java.util.ArrayList;
import java.util.Scanner;

public class Sumanumerosarraylist {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese números enteros. Para terminar, ingrese un número negativo.");

        while (true) {
            System.out.print("Ingrese un número: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Por favor, ingrese un número entero: ");
                scanner.next(); 
            }
            int numero = scanner.nextInt();

            if (numero < 0) {
                break;
            }

            if (!numeros.contains(numero)) {
                numeros.add(numero);
            } else {
                System.out.println("El número ya fue ingresado. No se agregará al listado.");
            }
        }

        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }

        System.out.println("La suma de los números ingresados es: " + suma);
    }
}
