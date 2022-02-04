package model;

public class Vaca extends Animal{
    private int cantidad_de_leche;

    public Vaca(int cantidad_de_leche, int id, Corral corral, double peso, double altura, boolean esta_vacunado) {
        super(id, corral, peso, altura, esta_vacunado);
        this.cantidad_de_leche = cantidad_de_leche;
    }
    
}
