import java.util.Random;

public class Adivinaelnumero(Respaldo) {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int numeroaleatorio = aleatorio.nextInt(100) + 1;
        int numintentos = 10;
        int intento;
        boolean adivinaxd = false;

        System.out.println("Se genero un numero del 1 al 100, adivinalo en 10 intentos");
        
        for (int i = 1; i <= numintentos; i++) {
            System.out.println("Intento " + i + ": ");
            intento = aleatorio2.nextInt();

            if (intento == numeroaleatorio) {
                adivinaxd = true;
                System.out.println("Has adivinado el numero en " + i + " intentos.");
                break;
            } else if (intento < numeroaleatorio) {
                System.out.println("El numero es mayor");
            } else if (intento > numeroaleatorio) {
                System.out.println("El numero es menor");
            }

        }

        if (adivinaxd) {
            System.out.println("No adivinaste el numero, era: " + numeroaleatorio);
        }

    }
}

