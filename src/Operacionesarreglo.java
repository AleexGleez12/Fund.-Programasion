public class Operacionesarreglo {
    public static void main(String[] args) {
     double sumar = 0.0, promedio = 0.0;

        int edades[] = new int[3];
        edades[0] = 18;
        edades[1] = 23;
        edades[2] = 35;

        for (int posicion = 0; posicion < 3; posicion++) {
            sumar = sumar + edades[posicion];
        }

        promedio = sumar;
        System.err.println("Resultado: " + promedio);
    }
}
