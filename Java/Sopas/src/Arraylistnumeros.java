import java.util.ArrayList;
import java.util.Arrays;

public class Arraylistnumeros {
    public static void main(String[] args) {

        int[] arrayNumeros = new int[100];
        for (int i = 0; i < 100; i++) {
            arrayNumeros[i] = i + 1;
        }


        System.out.println("Array de números del 1 al 100:");
        System.out.println(Arrays.toString(arrayNumeros));


        ArrayList<Integer> arrayListNumeros = new ArrayList<>();
        for (int i = 101; i <= 200; i++) {
            arrayListNumeros.add(i);
        }


        System.out.println("\nArrayList de números del 101 al 200:");
        System.out.println(arrayListNumeros);


        ArrayList<Integer> arrayListCombinado = new ArrayList<>();

        for (int num : arrayNumeros) {
            arrayListCombinado.add(num);
        }


        arrayListCombinado.addAll(arrayListNumeros);


        System.out.println("\nArrayList combinado de números del 1 al 200:");
        System.out.println(arrayListCombinado);
    }
}
