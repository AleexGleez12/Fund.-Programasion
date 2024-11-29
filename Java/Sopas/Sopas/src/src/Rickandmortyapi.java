
import java.util.Scanner;



public class Rickandmortyapi {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Ingresa el id del personaje a elegir(1, 826)");
            Scanner personajes = new Scanner(System.in);
            int rickpers = personajes.nextInt();
            Character character = ApiUtil.getCharacterById(rickpers);
            System.out.println("Nombre: " + character.name);
            System.out.println("Estado: " + character.status);
            System.out.println("Episodios: " + character.episode.size());
            System.out.println("Imagen: " + character.image);
            System.out.println("Genero " + character.gender);
            System.out.println("Especie: " + character.origin);
            System.out.println("Tipo: " + character.type);
            personajes.close();
            // Imprimir más datos según sea necesario
        } catch (Exception e) {
            e.printStackTrace();

            
        }
    }
}
