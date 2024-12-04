import java.util.Random;

public class OrdenamientoBurbuja {
    public static void main(String[] args) {

        int[] arreglo = new int[100];

 
        Random random = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = random.nextInt(501) + 500; 
        }


        System.out.println("Arreglo antes del ordenamiento:");
        mostrarArreglo(arreglo);

        burbuja(arreglo);


        System.out.println("\nArreglo después del ordenamiento:");
        mostrarArreglo(arreglo);
    }


    public static void burbuja(int[] arreglo) {
        int n = arreglo.length;
        int temp;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false; 
           
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
              
                    temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    swapped = true;
                }
            }
         
            if (!swapped) break;
        }
    }

    
    public static void mostrarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println(); 
            }
        }
    }
}
