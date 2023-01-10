package pe.edu.uni.kabestore.prueba;
import java.sql.Connection;
import pe.edu.uni.kabestore.db.AccesoDB;


//jhon banister

public class Prueba01 {
    
    public static void main(String[] args) {
        try {
            //prueba de coneccion con la base de datos
            Connection cn = AccesoDB.getConnection();
            System.out.println("coneccion ok");
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
