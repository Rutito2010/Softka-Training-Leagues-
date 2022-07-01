package Managers;

import Models.NaveAbstracta;

import java.util.ArrayList;
import java.util.List;

public class FiltrosClaseManager {
    public static List filtroNaveLanzadera(List lista){

            List filtered = new ArrayList();
            for (int j = 0; j < lista.size(); j++) {
                NaveAbstracta temp = (NaveAbstracta) lista.get(j);
                if (temp.isLanzadera() ) {
                    filtered.add(temp);
                }
            }
            return filtered;
        }

    public static List filtroNaveNoTripulada(List lista){
        List filtered = new ArrayList();
        for (int j = 0; j < lista.size(); j++) {
            NaveAbstracta temp = (NaveAbstracta) lista.get(j);
            if (!temp.isLanzadera() && !temp.isTripulacion()) {
                filtered.add(temp);
            }
        }
        return filtered;
    }

    public static List filtroNaveTripulada(List lista){
            List filtered = new ArrayList();
            for (int j = 0; j < lista.size(); j++) {
                NaveAbstracta temp = (NaveAbstracta) lista.get(j);
                if (!temp.isLanzadera() && temp.isTripulacion()) {
                    filtered.add(temp);
                }
            }
            return filtered;
        }
    }


