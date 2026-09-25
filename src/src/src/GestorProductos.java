
package src;
import java.util.ArrayList;

public class GestorProductos {
    private ArrayList<Producto> listaProductos;

    public GestorProductos() {
        this.listaProductos = new ArrayList<>();
    }

    // Crear
    public boolean crearProducto(String id, String nombre, double precio) {
        for (Producto p : listaProductos) {
            if (p.getId().equals(id)) {
                return false; 
            }
        }
        listaProductos.add(new Producto(id, nombre, precio));
        return true;
    }

    // Leer
    public void leerProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados en el inventario.");
        } else {
            System.out.println("\n--- LISTA DE PRODUCTOS ---");
            for (Producto p : listaProductos) {
                System.out.println(p);
            }
        }
    }

    // Actualizar
    public boolean actualizarPrecio(String id, double nuevoPrecio) {
        for (Producto p : listaProductos) {
            if (p.getId().equals(id)) {
                p.setPrecio(nuevoPrecio);
                return true;
            }
        }
        return false; // Producto no encontrado
    }

    // Eliminar
    public boolean eliminarProducto(String id) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getId().equals(id)) {
                listaProductos.remove(i);
                return true;
            }
        }
        return false; // Producto no encontrado
    }
}