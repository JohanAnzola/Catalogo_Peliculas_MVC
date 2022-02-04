package model;

public class Animal {
    private int id;
    private Corral corral;
    private double peso;
    private double altura;
    private boolean esta_vacunado;

    public Animal(int id, Corral corral, double peso, double altura, boolean esta_vacunado) {
        this.id = id;
        this.corral = corral;
        this.peso = peso;
        this.altura = altura;
        this.esta_vacunado = esta_vacunado;
    }
    
}
