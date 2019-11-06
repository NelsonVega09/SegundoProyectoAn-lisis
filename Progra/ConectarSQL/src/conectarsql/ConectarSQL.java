package conectarsql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConectarSQL {


        public static void main(String[] args) {
                //INSTANCIA DE LA CLASE DBConnect; RECIBE EL NOMBRE DE LA BASE DE DATOS A CONECTARSE, EL USUARIO Y //CLAVE
                DBConect bdcon = new DBConect("databaseName=encuesta", "Nelson", "12345");
                //INICIALIZACIÓN DE VARIABLES
                bdcon.setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                bdcon.setUrl("jdbc:sqlserver://localhost:1433;");
                //METODO QUE ABRE LA CONECCIÓN A LA BASE DE DATOS
                Connection conexion = bdcon.getConnection();

                //VARIABLE QUE ALMACENA EL RESULTADO DE EJECUTAR UN QUERY
                ResultSet rs = bdcon.SelectQuery("SELECT * FROM encuestado", null);

                try {
                        while (rs.next()) {
                                int ced = rs.getInt("cedula");
                                String nombres = rs.getString("nombres");
                                String apellidos = rs.getString("apellidos");
                                System.out.println("Cédula: " + ced + " Nombre: " + nombres + " " + apellidos);
                            }
                        } catch (SQLException sqle) {
                            System.out.println("Sql Exception :" + sqle.getMessage());
                        }
                
                
                //--------------------------------------------------------------------------------------------------------------------------------------
                 //CREACIÓN DE LOS PARÁMETROS
                ArrayList<String> firstInsertArgs = new ArrayList();
                firstInsertArgs.add("0000000000");
                firstInsertArgs.add("Víquez Acuña jaja");
                firstInsertArgs.add("Leonardo jaja");
                firstInsertArgs.add("M");
                firstInsertArgs.add("leoviquez 02");
                firstInsertArgs.add("leoviquez 02");
                firstInsertArgs.add("7");
                //EJECUCIÓN DEL INSERT
                bdcon.InsertQuery("insert into encuestado(cedula, apellidos, nombres,sexo,usuario,clave,localidad) values(?,?,?,?,?,?,?)", firstInsertArgs);
                
                
                //--------------------------------------------------------------------------------------------------------------------------------------
                //VARIABLE QUE ALMACENA EL RESULTADO DE EJECUTAR UN QUERY
                rs = bdcon.SelectQuery("SELECT * FROM encuestado", null);

                try {
                        while (rs.next()) {
                                int ced = rs.getInt("cedula");
                                String nombres = rs.getString("nombres");
                                String apellidos = rs.getString("apellidos");
                                System.out.println("Cédula: " + ced + " Nombre: " + nombres + " " + apellidos);
                            }
                        } catch (SQLException sqle) {
                            System.out.println("Sql Exception :" + sqle.getMessage());
                        }

        }
        
}
