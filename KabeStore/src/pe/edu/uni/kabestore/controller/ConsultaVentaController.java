package pe.edu.uni.kabestore.controller;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.kabestore.dto.VentaDto;
import pe.edu.uni.kabestore.service.VentasService;

public class ConsultaVentaController {
    
    public List<VentaDto> listarVentasPorRangoFechas(String fechaInicio , String fechaTermino) throws SQLException {
        VentasService svc = new VentasService();
        return svc.listarVentasPorRangoFecha(fechaInicio, fechaTermino);
    }
}
