package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorProductos gestor = new GestorProductos();
        int opcion = 0;

        do {
            System.out.println("\n--- SISTEMA DE GESTION DE PRODUCTOS ---");
            System.out.println("1. Crear producto");
            System.out.println("2. Leer productos");
            System.out.println("3. Actualizar precio de producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese ID del producto: ");
                        String id = scanner.nextLine();
                        System.out.print("Ingrese nombre del producto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese precio del producto: ");
                        if (scanner.hasNextDouble()) {
                            double precio = scanner.nextDouble();
                            scanner.nextLine();
                            boolean creado = gestor.crearProducto(id, nombre, precio);
                            if (creado) {
                                System.out.println("Producto registrado exitosamente.");
                            } else {
                                System.out.println("Error: Ya existe un producto con ese ID.");
                            }
                        } else {
                            System.out.println("Precio invalido.");
                            scanner.nextLine();
                        }
                        break;

                    case 2:
                        gestor.leerProductos();
                        break;

                    case 3:
                        System.out.print("Ingrese ID del producto a actualizar: ");
                        String idActualizar = scanner.nextLine();
                        System.out.print("Ingrese el nuevo precio: ");
                        if (scanner.hasNextDouble()) {
                            double nuevoPrecio = scanner.nextDouble();
                            scanner.nextLine();
                            boolean actualizado = gestor.actualizarPrecio(idActualizar, nuevoPrecio);
                            if (actualizado) {
                                System.out.println("Precio actualizado exitosamente.");
                            } else {
                                System.out.println("Error: El producto con ese ID no existe.");
                            }
                        } else {
                            System.out.println("Precio invalido.");
                            scanner.nextLine();
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese ID del producto a eliminar: ");
                        String idEliminar = scanner.nextLine();
                        boolean eliminado = gestor.eliminarProducto(idEliminar);
                        if (eliminado) {
                            System.out.println("Producto eliminado exitosamente del inventario.");
                        } else {
                            System.out.println("Error: El producto con ese ID no existe.");
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion invalida. Intente de nuevo.");
                }
            } else {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.next();
            }

        } while (opcion != 5);

        scanner.close();
    }
}