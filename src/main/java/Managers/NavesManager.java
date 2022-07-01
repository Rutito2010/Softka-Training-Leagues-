package Managers;

import Models.NaveAbstracta;
import Models.NaveLanzadera;
import Models.NaveNoTripulada;
import Models.NaveTripulada;

public class NavesManager {



    public static NaveAbstracta crearLanzadera(String name, String empuje, String velocidad, String peso, boolean tripulacion, boolean lanzadera){

        NaveAbstracta temp=new NaveLanzadera(name, empuje, velocidad, peso, tripulacion, lanzadera);

        return temp;
    }
    public static NaveAbstracta crearTripulada(String name, String empuje, String velocidad, String peso, boolean tripulacion, boolean lanzadera){
        NaveAbstracta temp= new NaveTripulada(name, empuje, velocidad, peso, tripulacion, lanzadera);

        return temp;
    }
    public static NaveAbstracta crearNoTripulada(String name, String empuje, String velocidad, String peso, boolean tripulacion, boolean lanzadera){
        NaveAbstracta temp= new NaveNoTripulada(name, empuje, velocidad, peso, tripulacion, lanzadera);
        return temp;
    }
}
