package pe.edu.uni.kabestore.controller;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.kabestore.dto.PublicacionDto;
import pe.edu.uni.kabestore.service.PublicacionService;

public class MantenimientoPublicacionController {
    
     public List<PublicacionDto> listarPublicaciones() throws SQLException{  
        PublicacionService svc = new PublicacionService();     
        return svc.listarPublicacion();
        
    }
    
    public boolean actualizarPrecioPublicacion(String id, double precio) throws SQLException{
    
        PublicacionService svc = new PublicacionService();
        return svc.actualizarPublicacion(id, precio);
    
    }
     
}
