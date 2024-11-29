import java.util.Scanner;

public class Calculararea {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Selecciona una figura para calcular el área:");
            System.out.println("1. Triángulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Círculo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce la base del triángulo: ");
                    double baseTriangulo = scanner.nextDouble();
                    System.out.print("Introduce la altura del triángulo: ");
                    double alturaTriangulo = scanner.nextDouble();
                    double areaTriangulo = (baseTriangulo * alturaTriangulo) / 2;
                    System.out.println("El área del triángulo es: " + areaTriangulo);
                    break;

                case 2:
                    System.out.print("Introduce el lado del cuadrado: ");
                    double ladoCuadrado = scanner.nextDouble();
                    double areaCuadrado = ladoCuadrado * ladoCuadrado;
                    System.out.println("El área del cuadrado es: " + areaCuadrado);
                    break;

                case 3:
                    System.out.print("Introduce el radio del círculo: ");
                    double radioCirculo = scanner.nextDouble();
                    double areaCirculo = Math.PI * Math.pow(radioCirculo, 2);
                    System.out.println("El área del círculo es: " + areaCirculo);
                    break;

                case 4:
                    System.out.print("Introduce la base del rectángulo: ");
                    double baseRectangulo = scanner.nextDouble();
                    System.out.print("Introduce la altura del rectángulo: ");
                    double alturaRectangulo = scanner.nextDouble();
                    double areaRectangulo = baseRectangulo * alturaRectangulo;
                    System.out.println("El área del rectángulo es: " + areaRectangulo);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
                    break;
            }
            System.out.println(); 
        } while (opcion != 5);

        scanner.close();
    }
}
