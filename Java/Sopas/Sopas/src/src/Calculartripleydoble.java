import java.util.Scanner;

public class Calculartripleydoble {
    public static void main(String[] args) {
        Scanner xd = new Scanner(System.in);
        
        System.out.print("Introduce el primer número: ");
        int num1 = xd.nextInt();
        
        System.out.print("Introduce el segundo número: ");
        int num2 = xd.nextInt();
        
        int resultado = (3 * num1) + (2 * num2);
        System.out.println("El resultado es: " + resultado);
        System.err.println("Explicacion: Triple del primer numero: " + (3 * num1) + ". El doble del segundo numero: " + (2 * num2) + ". Sumados dan: " + resultado + ". Y no fuimo");
        xd.close();
    }
}
