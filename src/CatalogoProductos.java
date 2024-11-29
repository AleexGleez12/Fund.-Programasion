import java.util.*;

public class CatalogoProductos {

    static class Producto {
        private int id;
        private String nombre;
        private String categoria;
        private double precio;

        public Producto(int id, String nombre, String categoria, double precio) {
            this.id = id;
            this.nombre = nombre;
            this.categoria = categoria;
            this.precio = precio;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCategoria() {
            return categoria;
        }

        public double getPrecio() {
            return precio;
        }

        @Override
        public String toString() {
            return "Producto [ID: " + id + ", Nombre: " + nombre + ", Categoría: " + categoria + ", Precio: $" + precio + "]";
        }
    }

    private static List<Producto> catalogo = new ArrayList<>();
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Selecciona una opción:");
            switch (opcion) {
                case 1:
                    buscarProductos();
                    break;
                case 2:
                    agregarProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema. ¡Gracias!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("*****************************************************");
        System.out.println("* Bienvenido al Catálogo de Productos.             ");
        System.out.println("* Selecciona una de las siguientes opciones:       ");
        System.out.println("* 1) Buscar Productos                              ");
        System.out.println("* 2) Agregar Producto                              ");
        System.out.println("* 3) Eliminar Producto                             ");
        System.out.println("* 0) Salir                                         ");
        System.out.println("*****************************************************");
    }

    private static void buscarProductos() {
        System.out.println("*****************************************************");
        System.out.println("1) Buscar productos por:");
        System.out.println("   a) ID");
        System.out.println("   b) Categoría");
        System.out.println("   c) Nombre/Descripción");
        System.out.println("   d) Rango de precio");
        System.out.println("*****************************************************");
        char opcion = leerCaracter("Selecciona una opción:");
        
        switch (opcion) {
            case 'a':
                int id = leerEntero("Ingresa el ID:");
                buscarPorId(id);
                break;
            case 'b':
                String categoria = leerCadena("Ingresa la categoría:");
                buscarPorCategoria(categoria);
                break;
            case 'c':
                String nombre = leerCadena("Ingresa el nombre o descripción:");
                buscarPorNombre(nombre);
                break;
            case 'd':
                double min = leerDouble("Ingresa el precio mínimo:");
                double max = leerDouble("Ingresa el precio máximo:");
                buscarPorRangoPrecio(min, max);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private static void buscarPorId(int id) {
        Producto producto = catalogo.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void buscarPorCategoria(String categoria) {
        catalogo.stream().filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .forEach(System.out::println);
    }

    private static void buscarPorNombre(String nombre) {
        catalogo.stream().filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .forEach(System.out::println);
    }

    private static void buscarPorRangoPrecio(double min, double max) {
        catalogo.stream().filter(p -> p.getPrecio() >= min && p.getPrecio() <= max)
                .forEach(System.out::println);
    }

    private static void agregarProducto() {
        System.out.println("*****************************************************");
        int id = leerEntero("Ingresa el ID:");
        String nombre = leerCadena("Ingresa el nombre:");
        String categoria = leerCadena("Ingresa la categoría:");
        double precio = leerDouble("Ingresa el precio:");

        catalogo.add(new Producto(id, nombre, categoria, precio));
        System.out.println("Producto agregado correctamente.");
    }

    private static void eliminarProducto() {
        System.out.println("*****************************************************");
        int id = leerEntero("Ingresa el ID del producto a eliminar:");
        Producto producto = catalogo.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

        if (producto != null) {
            catalogo.remove(producto);
            System.out.println("Se borró correctamente el producto \"" + producto.getNombre() + "\".");
            System.out.println("Quedan " + catalogo.size() + " producto(s) en el catálogo.");
        } else {
            System.out.println("Producto no encontrado.");
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
        scanner.nextLine(); // Limpiar el buffer
        return scanner.nextLine();
    }

    private static char leerCaracter(String mensaje) {
        System.out.print(mensaje + " ");
        return scanner.next().charAt(0);
    }
}

