package Managers;


import Models.NaveAbstracta;
import Service.FiltradoNombreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FiltroNombreManager  {

    public static List filtrarNombre(List lista, String arg) {
        List filtered = new ArrayList();

        for (int i = 0; i < lista.size(); i++) {
            NaveAbstracta temp = (NaveAbstracta) lista.get(i);
            if(temp.getName().toLowerCase().contains(arg.toLowerCase())){
            filtered.add(temp);
            }

        }
        return filtered;
    };
}
