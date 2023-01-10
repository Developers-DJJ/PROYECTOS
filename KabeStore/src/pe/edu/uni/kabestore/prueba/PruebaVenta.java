package pe.edu.uni.kabestore.prueba;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.kabestore.dto.VentaDto;
import pe.edu.uni.kabestore.service.VentasService;

/**
 *
 * @author DBOULLOSA
 */
public class PruebaVenta {

    public static void main(String[] args) throws SQLException {
        //listarVentas();
        //listarPorRangoFecha("15-07-2022", "17-07-2022");
        //calcular();
        idventa();
        
    }

    public static void listarVentas() throws SQLException {
        VentasService svc = new VentasService();
        List<VentaDto> ventas = svc.listarVentas();
        for (int i = 0; i < ventas.size(); i++) {
            System.out.println(ventas.get(i).getCliente());
        }
    }

    public static void listarPorRangoFecha(String fechainicio, String fechaTermino) throws SQLException {
        VentasService svc = new VentasService();
        List<VentaDto> ventas = svc.listarVentasPorRangoFecha(fechainicio, fechaTermino);
        for (int i = 0; i < ventas.size(); i++) {
            System.out.println(ventas.get(i).getCliente());
        }
    }
    
    public static void calcular() throws SQLException{
    VentaDto dto = new VentaDto(50,50);
        VentasService svc = new VentasService();

        dto = svc.calcular(dto, 0.18);

        System.out.println(String.valueOf(dto.getDcto())+" " +String.valueOf(dto.getSubTotal())+ " "+ String.valueOf(dto.getImpuesto())+ " "+String.valueOf(dto.getTotal()));
    
    }
    
    public static void idventa() throws SQLException{
    VentasService svc = new VentasService();
    int codigo =  svc.getIdVenta();
    
        System.out.println(String.valueOf(codigo));
    
    }

}
