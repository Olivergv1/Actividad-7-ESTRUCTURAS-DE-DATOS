package libroderecetas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibroDeRecetas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);     //se utiliza para leer la entrada del usuario desde la consola
        Map<String, Receta> libroDeRecetas = new HashMap<>(); // mapa para almacenar recetas

        int opcion; // variable para almacenar la opcion del menu

        
        do {          // menu de opciones
                          
            System.out.println("_________________________________________________");
            System.out.println("Menu:");
            System.out.println("1. Agregar una receta");
            System.out.println("2. Agregar un ingrediente a una receta");
            System.out.println("3. Eliminar un ingrediente de una receta");
            System.out.println("4. Eliminar una receta");
            System.out.println("5. Eliminar Todas las Recetas");
            System.out.println("6. Mostrar las recetas en forma ascendente");
            System.out.println("7. Mostrar las recetas en forma descendente");
            System.out.println("8. Mostrar Todas las recetas");
            System.out.println("9. Comprobar si las recetas estan vacias");
            System.out.println("10. Salir");
            System.out.print("Seleccione una de las 10 opciones: ");

            
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt(); // lee la opcion del usuario
                scanner.nextLine(); // garantisa que solo se lea el numero ingresado por el usuario evitando el salto de línea despues del numero

                switch (opcion) {
                            
                    case 1:     // metodo para agregar una receta
                        
                        System.out.print("Ingrese el nombre de la receta: ");
                        String nombreReceta = scanner.nextLine();
                        libroDeRecetas.put(nombreReceta, new Receta());
                        System.out.println("Receta '" + nombreReceta + "' agregada con éxito.");
                        break;
                    
                        
                    case 2:    // metodo para agregar un ingrediente a una receta existente
                        
                        System.out.print("Ingrese el nombre de la receta: ");
                        String recetaAgregar = scanner.nextLine();
                        
                        if (libroDeRecetas.containsKey(recetaAgregar)) {
                            Receta receta = libroDeRecetas.get(recetaAgregar);
                            System.out.print("Ingrese el nombre del ingrediente: ");
                            String nombreIngrediente = scanner.nextLine();
                            System.out.print("Ingrese la cantidad del ingrediente: ");
                            int cantidadIngrediente = scanner.nextInt();
                            scanner.nextLine();     // garantisa que solo se lea el numero ingresado por el usuario evitando el salto de línea despues del numero
                            receta.agregarIngrediente(nombreIngrediente, cantidadIngrediente);
                            
                            System.out.println("Ingrediente " + nombreIngrediente + " agregado a la receta " + recetaAgregar );
                        } else {
                            System.out.println("La receta '" + recetaAgregar + "' no existe.");
                        }
                        break;
                    
                        
                    case 3:     // metodo para eliminar un ingrediente de una receta existente
                        
                        System.out.print("Ingrese el nombre de la receta: ");
                        String recetaEliminar = scanner.nextLine();
                        
                        if (libroDeRecetas.containsKey(recetaEliminar)) {
                            Receta recetaParaModificar = libroDeRecetas.get(recetaEliminar);
                            System.out.print("Ingrese el nombre del ingrediente a eliminar: ");
                            String nombreIngredienteEliminar = scanner.nextLine();
                            System.out.print("Ingrese la cantidad del ingrediente a eliminar: ");
                            int cantidadIngredienteEliminar = scanner.nextInt();
                            scanner.nextLine(); // garantisa que solo se lea el numero ingresado por el usuario evitando el salto de línea despues del numero
                            recetaParaModificar.eliminarIngrediente(nombreIngredienteEliminar, cantidadIngredienteEliminar);
                            
                            System.out.println("Ingrediente " + nombreIngredienteEliminar + " eliminado de la receta " + recetaEliminar );
                        } else {
                            System.out.println("La receta " + recetaEliminar + " no existe.");
                        }
                        break;
                        
                        
                    case 4:      // metodo para eliminar una receta
                        
                        System.out.print("Ingrese el nombre de la receta a eliminar: ");
                        String recetaParaEliminar = scanner.nextLine();
                        if (libroDeRecetas.containsKey(recetaParaEliminar)) {
                            libroDeRecetas.remove(recetaParaEliminar);
                            
                            System.out.println("Receta '" + recetaParaEliminar + "' eliminada.");
                        } else {
                            System.out.println("La receta '" + recetaParaEliminar + "' no existe.");
                        }
                        break;
                        
                        
                    case 5:   // metodo para eliminar todas las recetas

                        libroDeRecetas.clear();
                        System.out.println("Todas las recetas han sido eliminadas.");
                        break;
                        
                        
                    case 6:  // metodo para mostrar las recetas en orden ascendente alfabetica mente 
                        
                        if (libroDeRecetas.isEmpty()) {
                            System.out.println("Actualmente no hay recetas. Puedes agregar algunas usando la opcion 1.");
                            
                        } else {
                            System.out.println("Recetas en orden ascendente:");
                            libroDeRecetas.entrySet().stream()   // devuelve un conjunto de entradas (pares clave-valor) del mapa y convierte este conjunto en un flujo (stream) para que puedan aplicarse operaciones de programacion funcional 
                                    .sorted(Map.Entry.comparingByKey())  // ordena las entradas del mapa y especifica que el orden debe basarse en las claves de las entradas del mapa.
                                    .forEach(entry -> {
                                        System.out.println(entry.getKey() + " ---  Ingredientes : " + entry.getValue().getIngredientes());
                                    });
                        }
                        break;
                        
                    case 7:     // metodo para mostrar las recetas en orden descendente alfabetica mente
                        
                        if (libroDeRecetas.isEmpty()) {
                            System.out.println("Actualmente no hay recetas. Puedes agregar algunas usando la opcion 1.");
                        } else {
                            System.out.println("Recetas en orden descendente:");
                            libroDeRecetas.entrySet().stream()
                                    .sorted(Map.Entry.<String, Receta>comparingByKey().reversed())  // ordena las entradas del mapa segun sus claves en orden descendente.
                                    .forEach(entry -> {
                                        System.out.println(entry.getKey() + " ---  Ingredientes : " + entry.getValue().getIngredientes());
                                    });
                        }
                        break;
                        
                    case 8:     // metodo para mostrar todas las recetas
                        
                        if (libroDeRecetas.isEmpty()) {
                            System.out.println("Actualmente no hay recetas. Puedes agregar algunas usando la opcion 1.");
                            
                        } else {
                            System.out.println("Todas las recetas:");
                            libroDeRecetas.forEach((nombre, receta) -> {
                                System.out.println(nombre + " ---  Ingredientes :" + receta.getIngredientes());
                            });
                        }
                        break;
                        
                    case 9:     // metodo para comprobar si el libro de recetas esta vacias
                        
                        if (libroDeRecetas.isEmpty()) {
                            System.out.println("Actualmente no hay recetas. Puedes agregar algunas usando la opcion 1.");
                            
                        } else {
                            System.out.println("El libro de recetas no esta vacio. Contiene las siguientes recetas:");
                            libroDeRecetas.forEach((nombre, receta) -> {
                                System.out.println(nombre + ": ---  Ingredientes : " + receta.getIngredientes());
                            });
                        }
                        break;
                        
                    case 10:    // Opcion para salir
                        System.out.println("Saliendo del programa.");
                        break;
                        
                    default:
                        System.out.println("Opcion no valida. Intentelo de nuevo.");
                        break;
                }
                
            } else {
                System.out.println("Error, solo puede ingresar numeros. Intentelo de nuevo.");
                scanner.nextLine();     //limpia el bufer de entrada y permite que el bucle continue para solicitar una nueva entrada valida
                opcion = 0; // si el usuario ingresa algo que no es un numero entero se repite el bucle, permitiendo una nueva entrada valdida
            }

        } while (opcion != 10);  //  el bucle continuara ejecutandose hasta que el usuario elija la opcion 10 para salir del menu
    }

}
