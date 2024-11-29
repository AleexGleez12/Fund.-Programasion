import java.util.Scanner;

public class numeropositivo {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el numero entero positivo: ");
        int numero = scanner.nextInt();
        
        if (numero > 0) {
            int cifras = String.valueOf(numero).length();
            
            if (cifras == 1) {
                System.out.println("El número tiene " + cifras + " cifra.");
            } else {
                System.out.println("El número tiene " + cifras + " cifras.");
            }
        } else {
            System.out.println("Un numero positivo, no viste?.");
        } 
        
        scanner.close();
    }
}
