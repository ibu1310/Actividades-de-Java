import java.util.HashMap;
import java.util.Scanner;

public class TiendaDeZapatos {
    public static void main(String[] args) {
        GestorProductos gestor = new GestorProductos();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("\ttMenú de Opciones ");
            System.out.println("\t1. Agregar Producto al Inventario");
            System.out.println("\t2. Vender Producto");
            System.out.println("\t3. Restablecer Inventario de un Producto");
            System.out.println("\t4. Mostrar Inventario");
            System.out.println("\t0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Ingrese la cantidad inicial en inventario: ");
                    int cantidadInicial = scanner.nextInt();
                    scanner.nextLine();
                    gestor.agregarProducto(nombreProducto, cantidadInicial);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del producto a vender: ");
                    String nombreVenta = scanner.nextLine();
                    System.out.print("Ingrese la cantidad a vender: ");
                    int cantidadVenta = scanner.nextInt();
                    scanner.nextLine();
                    gestor.venderProducto(nombreVenta, cantidadVenta);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto a restablecer: ");
                    String nombreRestablecer = scanner.nextLine();
                    gestor.restablecerProducto(nombreRestablecer);
                    break;
                case 4:
                    System.out.println("Inventario Actual:");
                    gestor.mostrarInventario();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
        System.out.println("Saliendo del programa.");
    }
}
class Producto {
    private final String nombre;
    private int cantidad;
    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void vender(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        } else {
            System.out.println("No hay suficiente inventario.");
        }
    }
    public void restablecer() {
        this.cantidad = 10;
    }
    @Override
    public String toString() {
        return "Producto: " + nombre + " - en Inventario: " + cantidad;
    }
}
class GestorProductos {
    private final HashMap<String, Producto> productos;
    public GestorProductos() {
        productos = new HashMap<>();
    }
    public void agregarProducto(String nombre, int cantidad) {
        productos.put(nombre, new Producto(nombre, cantidad));
        System.out.println("Producto '" + nombre + "' agregado al inventario.");
    }
    public void venderProducto(String nombre, int cantidad) {
        Producto producto = productos.get(nombre);
        if (producto != null) {
            producto.vender(cantidad);
            System.out.println("Venta realizada: " + cantidad + " unidades de '" + nombre + "'.");
        } else {
            System.out.println("Producto no encontrado: " + nombre);
        }
    }
    public void restablecerProducto(String nombre) {
        Producto producto = productos.get(nombre);
        if (producto != null) {
            producto.restablecer();
            System.out.println("Inventario de '" + nombre + "' restablecido.");
        } else {
            System.out.println("Producto no encontrado: " + nombre);
        }
    }
    public void mostrarInventario() {
        for (Producto producto : productos.values()) {
            System.out.println(producto);
        }
    }
}