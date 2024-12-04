import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
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
            opcion = leerEntero("Selecciona una opción:");
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
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("*****************************************************");
        System.out.println("* Bienvenido al Catálogo de Productos. (Proyecto Ayala Gonzalez Alejandro)             *");
        System.out.println("* Selecciona una de las siguientes opciones:       *");
        System.out.println("* 1) Buscar Producto                               *");
        System.out.println("* 2) Agregar Producto                              *");
        System.out.println("* 3) Eliminar Producto                             *");
        System.out.println("* 0) Salir                                         *");
        System.out.println("*****************************************************");
    }

    private static void buscarProducto() {
        int id = leerEntero("Ingresa el ID del producto a buscar(1-20):");
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
                System.out.println("Precio: $" + productoJson.get("price").getAsDouble());
                System.out.println("Descripción: " + productoJson.get("description").getAsString());

                String opcion = leerCadena("¿Deseas descargar las características del producto? (S/N):");
                if (opcion.equalsIgnoreCase("S")) {
                    generarPDFProducto(productoJson);
                }
            } else {
                System.out.println("Producto no encontrado. Código: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el producto: " + e.getMessage());
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
                System.out.println("Producto agregado exitosamente:");
                System.out.println(response.body());
            } else {
                System.out.println("Error al agregar el producto. Código: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error al agregar el producto: " + e.getMessage());
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
                System.out.println("Producto eliminado exitosamente:");
                System.out.println(response.body());
            } else {
                System.out.println("Error al eliminar el producto. Código: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }

    private static void generarPDFProducto(JsonObject productoJson) {
        Document documento = new Document();
        int id = productoJson.get("id").getAsInt();
        String nombreArchivo = "producto_" + id + ".pdf";

        try {
            PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));
            documento.open();

            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph titulo = new Paragraph("Especificaciones del Producto", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            documento.add(new Paragraph(" ")); 

            Font detalleFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            documento.add(new Paragraph("ID del Producto: " + id, detalleFont));
            documento.add(new Paragraph("Nombre: " + productoJson.get("title").getAsString(), detalleFont));
            documento.add(new Paragraph("Categoria: " + productoJson.get("category").getAsString(), detalleFont)); 
            documento.add(new Paragraph("Precio: $" + productoJson.get("price").getAsDouble(), detalleFont));
            documento.add(new Paragraph("Descripción: " + productoJson.get("description").getAsString(), detalleFont));

            System.out.println("PDF generado correctamente: " + nombreArchivo);
        } catch (Exception e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        } finally {
            documento.close();
        }
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje + " ");
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. " + mensaje + " ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double leerDouble(String mensaje) {
        System.out.print(mensaje + " ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Entrada inválida. " + mensaje + " ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static String leerCadena(String mensaje) {
        System.out.print(mensaje + " ");
        scanner.nextLine(); 
        return scanner.nextLine();
    }
}





