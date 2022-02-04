package model;

public class Gallina extends Animal{
    private int cantidad_de_huevos;

    public Gallina(int cantidad_de_huevos, int id, Corral corral, double peso, double altura, boolean esta_vacunado) {
        super(id, corral, peso, altura, esta_vacunado);
        this.cantidad_de_huevos = cantidad_de_huevos;
    }
}
