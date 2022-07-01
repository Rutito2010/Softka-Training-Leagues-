package Models;

public class NaveLanzadera extends NaveAbstracta  {


    public NaveLanzadera() {
    }

    public NaveLanzadera(String name, String empuje, String velocidad, String peso, boolean tripulacion , boolean lanzadera ) {
        super(name, empuje, velocidad, peso, tripulacion, lanzadera);
        this.lanzadera = true;
    }

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
    public boolean isTripulacion() {
        return super.isTripulacion();
    }

    @Override
    public boolean isLanzadera() {
        return super.isLanzadera();
    }

    @Override
    public String toString() {
        return "Lanzadera { " +
                "nombre = " + name +
                ", empuje =" + empuje +
                ", velocidad = " + velocidad +
                ", peso = " + peso +
                '}';
    }

    @Override
    public void mandarSeñal(String señal) {
        super.mandarSeñal("nave lanzadera: "+señal);
    }

    @Override
    protected void acelerar() {
        System.out.println("aceleracion de una lanzadera");
    }

    @Override
    protected void despegar() {
        System.out.println("despegue de una lanzadera");
    }
}
