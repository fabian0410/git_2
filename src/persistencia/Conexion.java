package persistencia;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexion {
    Connection conexion;
    String url = "jdbc:mysql://localhost:3306/git_2";
    String usuario = "root";
    String password = "";

    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Exito");

        } catch (ClassNotFoundException e){
            System.out.println("Error al cargar el driver de mysql");
        } catch (SQLException e){
            System.out.println("Error al conectar la base de datos");
        }
    }
    public Connection getConexion(){
        return conexion;
    }
    public void cerrarConec(){
        try {
            if (conexion != null && !conexion.isClosed()){
                conexion.close();
                System.out.println("Conexion Cerrada");
            }
        } catch (SQLException e){
            System.out.println("Error al cerrar la conexion");
        }
    }
    public String[] validar(String consultita) {
        String[] resul = new String[3]; // Array to store 6 pieces of information
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultita);

            if (rs.next()) {
                resul[0] = rs.getString("cc");
                resul[1] = rs.getString("nombre");
                resul[2] = rs.getString("contraseña");


            }
            System.out.println(resul[0]);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return resul;
    }

}