package libroderecetas;

import java.util.HashMap;
import java.util.Map;

    // clase para representar una receta 
public class Receta {
    private final Map<String, Integer> ingredientes; // mapa para almacenar ingredientes con cantidades

    public Receta() {
        this.ingredientes = new HashMap<>();
    }
    

    // metodo para obtener los ingredientes de la receta
    public Map<String, Integer> getIngredientes() {
        return new HashMap<>(ingredientes);
    }
    
    
    // metodo para agregar un ingrediente a la receta

    public void agregarIngrediente(String ingrediente, int cantidad) {
        ingredientes.put(ingrediente, cantidad);
    }
    
    
    // metodo para eliminar un ingrediente de la receta

    public void eliminarIngrediente(String ingrediente, int cantidad) {
        int cantidadActual = ingredientes.getOrDefault(ingrediente,  0);
        if (cantidadActual <= cantidad) {  //comprueba si la cantidad actual es menor o igual a la cantidad que se quiere eliminar
            ingredientes.remove(ingrediente);  // elimina el ingrediente si la cantidad actual es menor o igual a la cantidad que se quiere eliminar
        } else {
            ingredientes.put(ingrediente, cantidadActual - cantidad);  //actualiza la cantidad del ingrediente restando la cantidad que se quiere eliminar
        }
    }
}
