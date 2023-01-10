package pe.edu.uni.kabestore.prueba;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.kabestore.dto.PublicacionDto;
import pe.edu.uni.kabestore.service.PublicacionService;

public class PruebaPublicaciones {

    public static void main(String[] args) throws SQLException {
        testUpdatePrecio();
        listarPublicacion();
        testValidarStock();
      
    }

    public static void listarPublicacion() throws SQLException {
        PublicacionService svc = new PublicacionService();
        List<PublicacionDto> publicaciones = svc.listarPublicacion();
        for (int i = 0; i < publicaciones.size(); i++) {
            System.out.println(publicaciones.get(i).getTitulo());
        }
    }

    public static void testValidarStock() throws SQLException {
        PublicacionService svc = new PublicacionService();
        // prueba validar stock 
        if (svc.validarStock("REV00003")) {
            System.out.println("si tiene stock");
        } else {
            System.out.println("no tiene stock");
        }
    }

    public static void testUpdatePrecio() throws SQLException {
        PublicacionService svc = new PublicacionService();

        if (svc.actualizarPublicacion("REV00045464", 12.5)) {
            System.out.println("actualizado correctamente");
        } else {
            System.out.println("no se actualizaron datos");
        }

    }
  
}
