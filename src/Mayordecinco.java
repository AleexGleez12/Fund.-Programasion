import java.util.Scanner;

public class Mayordecinco {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mayor = Integer.MIN_VALUE;

        System.out.println("Introduce 5 números:");

        for (int i = 1; i <= 5; i++) {
            System.out.print("Número " + i + ": ");
            int numero = scanner.nextInt();

            if (numero > mayor) {
                mayor = numero;
            }
        }

        System.out.println("El número mayor introducido es: " + mayor);
        scanner.close();
    }
}
