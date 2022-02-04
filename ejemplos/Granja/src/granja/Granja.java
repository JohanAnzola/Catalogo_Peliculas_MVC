package granja;
import view.CorralVista;

import controlador.Conector;

public class Granja {

    public static void main(String[] args) {
        // Conexión
        Conector.conectar();
        // Abrir pantalla del corral
        CorralVista pantalla_corral = new CorralVista();
        pantalla_corral.setVisible(true);
    }
    
}
