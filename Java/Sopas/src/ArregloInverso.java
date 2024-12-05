public class ArregloInverso {
    public static void main(String[] args) {
        int[] arreglo = new int[100];

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = 1000 + i;
        }

        System.out.println("Valores del arreglo (del índice 99 al 0):");
        for (int i = arreglo.length - 1; i >= 0; i--) {
            System.out.println("Índice " + i + ": " + arreglo[i]);
        }
    }
}

