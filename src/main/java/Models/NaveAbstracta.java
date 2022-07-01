package Models;

import Service.NavesService;

public abstract class NaveAbstracta implements NavesService {

    String name;
    String empuje;
    String velocidad;
    String peso;
    boolean tripulacion;
    boolean lanzadera;

    public NaveAbstracta() {

    }


    public NaveAbstracta(String name, String empuje, String velocidad, String peso, boolean tripulacion, boolean lanzadera ) {
        this.name = name;
        this.empuje = empuje;
        this.velocidad = velocidad;
        this.peso = peso;
        this.tripulacion = tripulacion;
        this.lanzadera=lanzadera;

    }

    public String getempuje() {
        return empuje;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public String getPeso() {
        return peso;
    }

    public String getName() {
        return name;
    }

    @Override
    public void mandarSeñal(String señal) {
        System.out.println(señal);
    }

    public boolean isTripulacion() {
        return tripulacion;
    }

    public boolean isLanzadera() {
        return lanzadera;
    }

    protected abstract void acelerar();
    protected abstract void despegar();

}
