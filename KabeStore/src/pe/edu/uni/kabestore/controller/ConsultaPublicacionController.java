package pe.edu.uni.kabestore.controller;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.kabestore.dto.PublicacionDto;
import pe.edu.uni.kabestore.dto.TipoDto;
import pe.edu.uni.kabestore.service.PublicacionService;
import pe.edu.uni.kabestore.service.TipoService;

public class ConsultaPublicacionController {

    public List<TipoDto> listarTipos() throws SQLException{
        TipoService svc = new TipoService();
        return svc.listarTipoDto();  
    }
    
    public List<PublicacionDto> listarPublicacionPorTipo(String idTipo , String idPublicacion) throws SQLException{  
        PublicacionService svc = new PublicacionService();     
        return svc.listarPublicacionesPorTipo(idTipo, idPublicacion);
        
    }
    
    
}
