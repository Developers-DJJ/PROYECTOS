package pe.edu.uni.kabestore.prueba;

import java.sql.SQLException;
import pe.edu.uni.kabestore.dto.UsuarioDto;
import pe.edu.uni.kabestore.service.UsuarioService;

public class PruebaUsuario {
    
    public static void main(String[] args) throws SQLException {
      
       try {
            UsuarioService service = new UsuarioService();
				 UsuarioDto dto = service.validarUsuario("eaguero", "cazador");
				 System.out.println("Hola: " + dto.getUsuario());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }
}
