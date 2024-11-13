
import java.util.Arrays;

public class Personas {
     public static void main(String[] args){
        Personas2 p1 = new Personas2();
        p1.nombre = "Alejandro";
        p1.edad = 17;

        Personas2 p2 = new Personas2();
        p2.nombre = "Alejandra";
        p2.edad = 17;

        Personas2[] personas2s = {p1, p2};

        System.out.println(Arrays.toString(personas2s));
     }
}
