package pe.edu.uni.kabestore.controller;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.kabestore.dto.ControlDto;
import pe.edu.uni.kabestore.service.ControlService;

public class ControlController {
     public List<ControlDto> listarControl() throws SQLException{  
         ControlService svc = new ControlService();     
        return svc.listarControl();
        
    }  
     public boolean actualizar(String parametro, String valor ) throws SQLException{  
         ControlService svc = new ControlService();     
        return svc.actualizarControl(parametro, valor);
        
    }
  
}
