
import Managers.NavesManager;
import Models.NaveAbstracta;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Connections {

    public static void conection() {

        Connection connection;
        Statement statement;
        try {
            String url = "jdbc:mysql://localhost:3306/Softka";
            String user = "root";
            String pass = "";
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection success.");
            statement = connection.createStatement();
            // Creo Tabla en primera ejecucion

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naves_espaciales`("+
                    "id INT NOT NULL AUTO_INCREMENT," +
                    " nombre VARCHAR(100) NOT NULL," +
                    " empuje VARCHAR(101) NOT NULL, " +
                    "velocidad VARCHAR(102) NOT NULL," +
                    "peso VARCHAR(100) NOT NULL," +
                    "tripulacion BOOLEAN," +
                    " lanzadera BOOLEAN ,  PRIMARY KEY (`id`))"

                    );


            connection.close();
            System.out.println("Connection closed.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("VendorError : " + ex.getErrorCode());
        }
    }

    public static void insertDb(NaveAbstracta nave) {
        Connection connection;
        Statement statement;
        try {
            String url = "jdbc:mysql://localhost:3306/Softka";
            String user = "root";
            String pass = "";
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection success.");
            statement = connection.createStatement();
            String nombre= nave.getName();
            String empuje=nave.getempuje();
            String velocidad=nave.getVelocidad();
            String peso=nave.getPeso();
            Boolean tripulacion=nave.isTripulacion();
            boolean lanzadera= nave.isLanzadera();
            String sql = "INSERT INTO naves_espaciales" + "(id, nombre, empuje,velocidad,peso,tripulacion, lanzadera) " +
                    "VALUES(null, '"+nombre+"' , '"+empuje+"', '"+velocidad+"','"+peso+"',"+tripulacion+", "+lanzadera+")";

            statement.executeUpdate(sql);

            connection.close();
            System.out.println("Connection closed.");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("VendorError : " + ex.getErrorCode());
        }
    }

    public static ArrayList getDb() {
        Connection connection;
        Statement statement;
        ArrayList  resultado = new ArrayList();

        try {
            String url = "jdbc:mysql://localhost:3306/Softka";
            String user = "root";
            String pass = "";
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection success.");
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM Softka.naves_espaciales  ");


            while (result.next()) {

                String[] temp = new String[]{result.getString("Nombre"), result.getString("empuje"),
                        result.getString("velocidad"), result.getString("peso"), result.getString("tripulacion"), result.getString("lanzadera")};
                    //Genero Strings con la informacion de cada nave traida de la DB
                resultado.add(temp);
                    //los introduzco en una Lista


            }
            result.close();
            connection.close();
            System.out.println("Connection closed.");
            return resultado;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("VendorError : " + ex.getErrorCode());
        }
        return resultado;
    }

    public static ArrayList getByNameDb(String name) {
        Connection connection;
        Statement statement;
        ArrayList  resultado = new ArrayList();
        try {
            String url = "jdbc:mysql://localhost:3306/Softka";
            String user = "root";
            String pass = "";
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection success.");
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM Softka.naves_espaciales WHERE nombre LIKE '%"+name+"%' " );
            while (result.next()) {
                String[] temp= new String[] { result.getString("Nombre"),result.getString("empuje"),
                        result.getString("velocidad"), result.getString("peso"),result.getString("tripulacion"), result.getString("lanzadera") };
                    //Genero Strings con la informacion de cada nave traida de la DB
                resultado.add(temp);
                    //los introduzco en una Lista

            }
            result.close();
            connection.close();
            System.out.println("Connection closed.");
            return resultado;

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("VendorError : " + ex.getErrorCode());
        }
        return resultado;
    }
}
