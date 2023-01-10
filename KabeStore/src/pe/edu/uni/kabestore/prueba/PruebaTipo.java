package pe.edu.uni.kabestore.prueba;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.kabestore.dto.TipoDto;
import pe.edu.uni.kabestore.service.TipoService;

public class PruebaTipo {
    
    public static void main(String[] args) throws SQLException{
        TipoService svc = new TipoService();
        List<TipoDto> publicaciones = svc.listarTipoDto();
        for (int i = 0; i < publicaciones.size(); i++) {
            System.out.println(publicaciones.get(i).getDescripcion());
        }
    }
}
