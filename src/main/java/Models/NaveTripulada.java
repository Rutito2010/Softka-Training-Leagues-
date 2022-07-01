package Models;

public class NaveTripulada extends NaveAbstracta {


    public NaveTripulada() {
    }

    public NaveTripulada(String name, String empuje, String velocidad, String peso, boolean tripulacion, boolean lanzadera) {
        super(name, empuje, velocidad, peso, tripulacion, lanzadera);
    }

    public void comportamiento(){
        System.out.println("control de aire presurizado");
    };
    @Override
    public String getempuje() {
        return super.getempuje();
    }

    @Override
    public String getVelocidad() {
        return super.getVelocidad();
    }

    @Override
    public String getPeso() {
        return super.getPeso();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void mandarSeñal(String señal) {
        super.mandarSeñal(señal);
    }

    @Override
    public boolean isTripulacion() {
        return super.isTripulacion();
    }

    @Override
    public boolean isLanzadera() {
        return super.isLanzadera();
    }

    @Override
    public String toString() {
        return "Tripulada { " +
                "nombre = " + name +
                ", empuje =" + empuje +
                ", velocidad = " + velocidad +
                ", peso = " + peso +
                '}';
    }



    @Override
    protected void acelerar() {
        System.out.println("aceleramiento de una nave tripulada");
    }

    @Override
    protected void despegar() {
        System.out.println("despegue de una nave tripulada");
    }
}
