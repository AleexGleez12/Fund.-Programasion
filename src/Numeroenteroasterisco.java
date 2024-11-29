import java.util.Scanner;


public class Numeroenteroasterisco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int numerio = scanner.nextInt();

        for (int i = 1; i <= numerio; i++) {
            System.out.print("*");
            if (i > 1) {
                System.out.println(" ".repeat(i - 2) + "*");
            } else {
                System.out.println();
            }
        }

        for (int i = 1; i <= numerio; i++) {
            System.out.print("*");
        }
        System.out.println();

        for (int i = numerio - 1; i >= 1; i--) {
            System.out.print("*");
            if (i > 1) {
                System.out.println(" ".repeat(i - 2) + "*");
            } else {
                System.out.println();
            }
        }

        scanner.close();
    }
}