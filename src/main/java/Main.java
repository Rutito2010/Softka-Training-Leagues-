import Managers.FiltroNombreManager;
import Managers.FiltrosClaseManager;
import Managers.NavesManager;
import Models.NaveAbstracta;
import Models.NaveLanzadera;
import Models.NaveNoTripulada;
import Models.NaveTripulada;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Connections.conection();
        int opcion, numeroFinal;
        List vistaDB = Connections.getDb();
        if (vistaDB.size() < 1) {

            NaveAbstracta naveTripulada = NavesManager.crearTripulada("Nave Tripulada inicial", "sin especificar", "sin especificar", "420t", true, false);
            Connections.insertDb(naveTripulada);
        } else {
            do {
                System.out.println("Intoduzca el numero segun la tarea que desea realizar ");
                System.out.println("1.Adquirir todas las naves");
                System.out.println("2.Crear nave");
                System.out.println("3.Buscar nave por nombre");
                System.out.println("4.Filtrar por tipo de nave");

                Scanner sc = new Scanner(System.in);
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1: {
                        List<NaveAbstracta> naves = new ArrayList();
                        //Creo una lista que contendra los resultados finales de la DB

                        ArrayList resultado = Connections.getDb();

                        for (int i = 0; i < resultado.size(); i++) {
                            String[] temp = (String[]) resultado.get(i);
                            boolean tripulacion = Integer.parseInt(temp[4]) == 1;//devuelvo los valores obtenidos de la base de dato a su forma booleana original
                            boolean lanzadera = Integer.parseInt(temp[5]) == 1;
                            if (!tripulacion && lanzadera) {//utilizo los booleanos para diferenciar que tipo de nave es cada arraay de strings que genere con los resultados de la base de datos
                                NaveAbstracta nave = NavesManager.crearLanzadera(temp[0], temp[1], temp[2], temp[3], Boolean.parseBoolean(temp[4]), Boolean.parseBoolean(temp[5]));
                                naves.add(nave);
                            } else if (tripulacion && !lanzadera) {
                                NaveAbstracta nave = NavesManager.crearTripulada(temp[0], temp[1], temp[2], temp[3], Boolean.parseBoolean(temp[4]), Boolean.parseBoolean(temp[5]));
                                naves.add(nave);
                            } else if (!tripulacion && !lanzadera) {
                                NaveAbstracta nave = NavesManager.crearNoTripulada(temp[0], temp[1], temp[2], temp[3], Boolean.parseBoolean(temp[4]), Boolean.parseBoolean(temp[5]));
                                naves.add(nave);
                            }
                        }
                        for (int j = 0; j < naves.size(); j++) {
                            System.out.println(naves.get(j));
                        }
                    }
                    break;
                    case 2:
                        System.out.println("Para crear una nave introduza los siguientes campos (en caso de no conocer el dato coloque 'sin especificar') : ");
                        System.out.println("Nombre*");
                        String nombre = sc.next();
                        System.out.println("Empuje (ejemplo 3600t)*");
                        String empuje = sc.next();
                        System.out.println("Velocidad (ejemplo 1200km/h)*");
                        String velocidad = sc.next();
                        System.out.println("peso (ejemplo 500 kg)*");
                        String peso = sc.next();

                        int nave;
                        System.out.println("Introducza el tipo de nave que desea crear");
                        System.out.println("1. Nave Lanzadera");
                        System.out.println("2. Nave Tripulada");
                        System.out.println("3. Nave No Tripulada");
                        nave = sc.nextInt();
                        if (nave == 1) {// utilizo una implementacion para crear distintas funciones para cada tipo de nave
                            NaveAbstracta naveLanzadera = NavesManager.crearLanzadera(nombre, empuje, velocidad, peso, false, true);
                            Connections.insertDb(naveLanzadera);
                        } else if (nave == 2) {
                            NaveAbstracta naveTripulada = NavesManager.crearTripulada(nombre, empuje, velocidad, peso, true, false);
                            Connections.insertDb(naveTripulada);
                        } else if (nave == 3) {
                            NaveAbstracta naveNoTripulada = NavesManager.crearNoTripulada(nombre, empuje, velocidad, peso, false, false);
                            Connections.insertDb(naveNoTripulada);
                        }
                        break;
                    case 3: {
                        System.out.println("Introduzca el nombre de la nave que desea buscar");

                        List<NaveAbstracta> navesPorNombre = new ArrayList();
                        String name = sc.next();

                        ArrayList resultado = Connections.getByNameDb(name);

                        for (int i = 0; i < resultado.size(); i++) {
                            String[] temp = (String[]) resultado.get(i);
                            boolean tripulacion = Integer.parseInt(temp[4]) == 1;
                            boolean lanzadera = Integer.parseInt(temp[5]) == 1;
                            if (!tripulacion && lanzadera) {
                                NaveAbstracta navePorNombre = NavesManager.crearLanzadera(temp[0], temp[1], temp[2], temp[3], false, true);
                                navesPorNombre.add(navePorNombre);
                            } else if (tripulacion && !lanzadera) {
                                NaveAbstracta navePorNombre = NavesManager.crearTripulada(temp[0], temp[1], temp[2], temp[3], true, false);
                                navesPorNombre.add(navePorNombre);
                            } else if (!tripulacion && !lanzadera) {
                                NaveAbstracta navePorNombre = NavesManager.crearNoTripulada(temp[0], temp[1], temp[2], temp[3], false, false);
                                navesPorNombre.add(navePorNombre);
                            }
                        }
                        if(navesPorNombre.size()<1){
                            System.out.println("No se encontraron naves con nombre similares al introducido");} else {
                            for (int j = 0; j < navesPorNombre.size(); j++) {
                                System.out.println(navesPorNombre.get(j));
                            }
                        }
                    }
                    break;
                    case 4: {
                        List<NaveAbstracta> navesPorClase = new ArrayList();
                        System.out.println("Intrdocuza el tipo de nave que desea ver");
                        System.out.println("1. Nave Lanzadera");
                        System.out.println("2. Nave Tripulada");
                        System.out.println("3. Nave No Tripulada");

                        int clase = sc.nextInt();


                        ArrayList resultado = Connections.getDb();

                        for (int i = 0; i < resultado.size(); i++) {
                            String[] temp = (String[]) resultado.get(i);
                            boolean tripulacion = Integer.parseInt(temp[4]) == 1;
                            boolean lanzadera = Integer.parseInt(temp[5]) == 1;
                            if (!tripulacion && lanzadera) {
                                NaveAbstracta navePorClase = NavesManager.crearLanzadera(temp[0], temp[1], temp[2], temp[3], false, true);
                                navesPorClase.add(navePorClase);
                            } else if (tripulacion && !lanzadera) {
                                NaveAbstracta navePorClase = NavesManager.crearTripulada(temp[0], temp[1], temp[2], temp[3], true, false);
                                navesPorClase.add(navePorClase);
                            } else if (!tripulacion && !lanzadera) {
                                NaveAbstracta navePorClase = NavesManager.crearNoTripulada(temp[0], temp[1], temp[2], temp[3], false, false);
                                navesPorClase.add(navePorClase);
                            }
                        }
                        if (clase == 1) {//utilizo una clase filtros con metodos especificos para cada tipo de nave
                            List lanzaderas = FiltrosClaseManager.filtroNaveLanzadera(navesPorClase);
                            if( lanzaderas.size()<1){
                                System.out.println("No hay naves lanzaderas en el inventario");}else{
                            System.out.println(lanzaderas);}
                        } else if (clase == 2) {
                            List tripuladas = FiltrosClaseManager.filtroNaveTripulada(navesPorClase);
                            if( tripuladas.size()<1){
                                System.out.println("No hay naves lanzaderas en el inventario");}else{
                                System.out.println(tripuladas);}
                        } else if (clase == 3) {
                            List noTripuladas = FiltrosClaseManager.filtroNaveNoTripulada(navesPorClase);
                            if( noTripuladas.size()<1){
                                System.out.println("No hay naves lanzaderas en el inventario");}else{
                            System.out.println(noTripuladas);}
                        }

                    }break;

                    default:

                        System.out.println("Wrong input..!");
                        break;

                }
                System.out.println("Presiona 5 para continuar");
                numeroFinal = sc.nextInt();
            }//mantengo el programa corriendo al reinicial el do a traves de la tecla 5
            while (numeroFinal == 5);


        }
    }
}



