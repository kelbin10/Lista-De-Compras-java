import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListaDeCompras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaCompras = new ArrayList<>();
        int opcion;
        
        do {
            limpiarConsola();
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Agregar un producto a la lista");
            System.out.println("2. Mostrar la lista de compras");
            System.out.println("3. Eliminar un producto de la lista");
            System.out.println("4. Buscar un producto en la lista");
            System.out.println("5. Ordenar la lista de productos alfabéticamente");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String producto = scanner.nextLine().trim();
                    listaCompras.add(producto);
                    System.out.println("Producto agregado.");
                    break;
                case 2:
                    System.out.println("Lista de compras:");
                    if (listaCompras.isEmpty()) {
                        System.out.println("La lista está vacía.");
                    } else {
                        for (String item : listaCompras) {
                            System.out.println("- " + item);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String eliminar = scanner.nextLine().trim();
                    if (listaCompras.removeIf(item -> item.equalsIgnoreCase(eliminar))) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("El producto no está en la lista.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String buscar = scanner.nextLine().trim();
                    boolean encontrado = listaCompras.stream().anyMatch(item -> item.equalsIgnoreCase(buscar));
                    if (encontrado) {
                        System.out.println("El producto está en la lista.");
                    } else {
                        System.out.println("El producto no está en la lista.");
                    }
                    break;
                case 5:
                    Collections.sort(listaCompras, String.CASE_INSENSITIVE_ORDER);
                    System.out.println("Lista ordenada alfabéticamente:");
                    for (String item : listaCompras) {
                        System.out.println("- " + item);
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            
            if (opcion != 6) {
                System.out.println("Presione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcion != 6);
        
        scanner.close();
    }

    public static void limpiarConsola() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
}
