package pe.edu.uni.kabestore.prueba;


import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.kabestore.dto.EmpleadoDto;
import pe.edu.uni.kabestore.service.EmpleadoService;

public class PruebaEmpleados {
    public static void main(String[] args) throws SQLException {
        
      
        EmpleadoService svc = new EmpleadoService();
       
        List<EmpleadoDto> empleados =  svc.listarEmpleados();
        
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println(empleados.get(i).getApellido()+" "+ empleados.get(i).getNombre());
        }
 
    }
}
