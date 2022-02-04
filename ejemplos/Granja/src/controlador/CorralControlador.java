package controlador;
import model.Corral;
import java.util.ArrayList;

public class CorralControlador {
    public static ArrayList<Corral> corrales = new ArrayList<>();
    
    public static Corral crear_corral(int id, double area, boolean esta_limpio){
        Corral nuevo_corral = new Corral(id, area, esta_limpio);
        corrales.add(nuevo_corral);
        return nuevo_corral;
    }
}
