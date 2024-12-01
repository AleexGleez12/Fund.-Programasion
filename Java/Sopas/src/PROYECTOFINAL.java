import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PROYECTOFINAL {
    private static final String BASE_URL = "https://fakestoreapi.com/products";
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Selecciona:");
            switch (opcion) {
                case 1:
                    buscarProducto();
                    break;
                case 2:
                    agregarProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 0:
                    System.out.println("Saliendo de la tiendita xd");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("*****************************************************");
        System.out.println("* Bienvenido al Catálogo de Productos.             *");
        System.out.println("* Selecciona una de las siguientes opciones:       *");
        System.out.println("* 1) Buscar Producto                               *");
        System.out.println("* 2) Agregar Producto                              *");
        System.out.println("* 3) Eliminar Producto                             *");
        System.out.println("* 0) Salir                                         *");
        System.out.println("*****************************************************");
    }

    private static void buscarProducto() {
        int id = leerEntero("Ingresa el ID del producto (1-20):");
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/" + id))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                JsonObject productoJson = gson.fromJson(response.body(), JsonObject.class);

                System.out.println("Producto encontrado:");
                System.out.println("ID: " + productoJson.get("id").getAsInt());
                System.out.println("Nombre: " + productoJson.get("title").getAsString());
                System.out.println("Categoria: " + productoJson.get("category").getAsString());
                System.out.println("Precio: " + productoJson.get("price").getAsDouble());
                System.out.println("Descripción: " + productoJson.get("description").getAsString());
                System.out.println("imagen: " + productoJson.get("image").getAsString());
            } else {
                System.out.println("No se encontro, código: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }

    private static void agregarProducto() {
        String nombre = leerCadena("Ingresa el nombre:");
        String categoria = leerCadena("Ingresa la categoría:");
        double precio = leerDouble("Ingresa el precio:");

        String nuevoProductoJson = String.format(
                "{\"title\": \"%s\", \"price\": %.2f, \"category\": \"%s\", \"description\": \"Descripción genérica\"}",
                nombre, precio, categoria
        );

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(nuevoProductoJson))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200 || response.statusCode() == 201) {
                System.out.println("Producto agregado:");
                System.out.println(response.body());
            } else {
                System.out.println("Error. Código: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void eliminarProducto() {
        int id = leerEntero("Ingresa el ID del producto a eliminar:");

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/" + id))
                    .DELETE()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("Producto eliminado :");
                System.out.println(response.body());
            } else {
                System.out.println("Error. Código: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje + " ");
        return scanner.nextInt();
    }

    private static double leerDouble(String mensaje) {
        System.out.print(mensaje + " ");
        return scanner.nextDouble();
    }

    private static String leerCadena(String mensaje) {
        System.out.print(mensaje + " ");
        scanner.nextLine(); 
        return scanner.nextLine();
    }
}



