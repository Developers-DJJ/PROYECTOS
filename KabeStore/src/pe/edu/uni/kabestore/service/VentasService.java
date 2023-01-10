package pe.edu.uni.kabestore.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.kabestore.dto.VentaDto;
import pe.edu.uni.kabestore.db.AccesoDB;
import pe.edu.uni.kabestore.dto.PromocionDto;

public class VentasService {

    private Connection cn;
    private PreparedStatement pstm;

    private final String GET_VENTASRANGOFECHA = "select idventa, cliente, fecha, idempleado,idpublicacion, "
            + " cantidad, precio, dcto, "
            + "subtotal, impuesto, total from VENTA "
            + "where fecha between ? + ' 00:00:00.000' and ? +  ' 23:59:59.999';";

    private final String GET_ALL = "select idventa, cliente, fecha, idempleado, idpublicacion, "
            + "cantidad, precio, dcto, subtotal, impuesto, total "
            + "from VENTA";
    private final String INSERT_VENTA = "insert into venta values(?,?,?,?,?,?,?,?,?,?,?);";

    private final String GET_IDVENTA = "select count(*) + 1 as codigoVenta  from VENTA; ";

    public List<VentaDto> listarVentas() throws SQLException {

        List<VentaDto> ventas = new ArrayList<>();

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_ALL);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                VentaDto dto = new VentaDto();
                dto.setIdVenta(rs.getInt("idventa"));
                dto.setCliente(rs.getString("cliente"));
                dto.setFecha(rs.getDate("fecha").toLocalDate());
                dto.setIdEmpleado(rs.getInt("idEmpleado"));
                dto.setIdPublicacion(rs.getString("idPublicacion"));
                dto.setCantidad(rs.getInt("cantidad"));
                dto.setPrecio(rs.getDouble("precio"));
                dto.setDcto(rs.getDouble("dcto"));
                dto.setSubTotal(rs.getDouble("subTotal"));
                dto.setImpuesto(rs.getDouble("impuesto"));
                dto.setTotal(rs.getDouble("total"));

                ventas.add(dto);
            }
            pstm.close();

        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return ventas;
    }

    public List<VentaDto> listarVentasPorRangoFecha(String fechaInicio, String fechTermino) throws SQLException {

        List<VentaDto> ventas = new ArrayList<>();

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_VENTASRANGOFECHA);
            pstm.setString(1, fechaInicio);
            pstm.setString(2, fechTermino);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                VentaDto dto = new VentaDto();
                dto.setIdVenta(rs.getInt("idventa"));
                dto.setCliente(rs.getString("cliente"));
                dto.setFecha(rs.getDate("fecha").toLocalDate());
                dto.setIdEmpleado(rs.getInt("idEmpleado"));
                dto.setIdPublicacion(rs.getString("idPublicacion"));
                dto.setCantidad(rs.getInt("cantidad"));
                dto.setPrecio(rs.getDouble("precio"));
                dto.setDcto(rs.getDouble("dcto"));
                dto.setSubTotal(rs.getDouble("subTotal"));
                dto.setImpuesto(rs.getDouble("impuesto"));
                dto.setTotal(rs.getDouble("total"));

                ventas.add(dto);
            }
            pstm.close();

        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return ventas;
    }

    public VentaDto calcular(VentaDto dto, double igv) throws SQLException {
        
        PromocionService svc = new PromocionService();
        //variables de entrada
        int cantidad;
        double Precio;
       
        //variable de salida
        double descuento, total, subtotal, impuesto, totalbruto;
        //reasignacion de variables
        cantidad = dto.getCantidad();
        PromocionDto promocion = svc.getPorcentajePromocion(cantidad);
        double procentaje = promocion.getPorcentaje();
        
        Precio = dto.getPrecio();
        //proceso
        descuento = cantidad * Precio * procentaje;
        totalbruto = (cantidad * Precio) - descuento;
        impuesto = totalbruto * igv;
        subtotal = totalbruto - impuesto;
        total = subtotal + impuesto;
        
        dto.setPorcentaje(procentaje);
        dto.setDcto(descuento);
        dto.setSubTotal(subtotal);
        dto.setImpuesto(impuesto);
        dto.setTotal(total);

        return dto;

    }

    public int getIdVenta() throws SQLException {

        int idVenta = 0;
        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_IDVENTA);    
            ResultSet rs = pstm.executeQuery();

           rs.next();
           idVenta = rs.getInt("codigoVenta");
           pstm.close();
        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return idVenta;
    }
    
     public boolean insertarVenta(VentaDto dto) throws SQLException {
        boolean respuesta = false;
        
        
        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(INSERT_VENTA);
            pstm.setInt(1,dto.getIdVenta() );
            pstm.setString(2, dto.getCliente() );
            pstm.setDate(3, Date.valueOf(dto.getFecha()));
            pstm.setInt(4, dto.getIdEmpleado());
            pstm.setString(5, dto.getIdPublicacion());
            pstm.setInt(6, dto.getCantidad());
            pstm.setDouble(7, dto.getPrecio() );
            pstm.setDouble(8, dto.getDcto());
            pstm.setDouble(9,dto.getSubTotal() );
            pstm.setDouble(10, dto.getImpuesto());
            pstm.setDouble(11,dto.getTotal() );
  
            if (pstm.executeUpdate() > 0) {
                respuesta = true;
            }
            pstm.close();

        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return respuesta;
    }
}
