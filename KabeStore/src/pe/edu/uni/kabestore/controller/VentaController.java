package pe.edu.uni.kabestore.controller;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.kabestore.dto.EmpleadoDto;
import pe.edu.uni.kabestore.dto.PublicacionDto;

import pe.edu.uni.kabestore.dto.VentaDto;
import pe.edu.uni.kabestore.service.ControlService;
import pe.edu.uni.kabestore.service.EmpleadoService;

import pe.edu.uni.kabestore.service.PublicacionService;

import pe.edu.uni.kabestore.service.VentasService;

public class VentaController {

    public List<PublicacionDto> listarPublicaciones() throws SQLException {
        PublicacionService svc = new PublicacionService();
        return svc.listarPublicacion();

    }

    public List<EmpleadoDto> listarEmpleados() throws SQLException {
        EmpleadoService svc = new EmpleadoService();
        return svc.listarEmpleados();

    }

    public List<VentaDto> listarVentas() throws SQLException {
        VentasService svc = new VentasService();
        return svc.listarVentas();
    }

    public PublicacionDto getPublicacionPorId(String idPublicacion) throws SQLException {
        PublicacionService svc = new PublicacionService();
        return svc.getPublicacionPorId(idPublicacion);

    }

    public VentaDto calcular(VentaDto dto, double igv) throws SQLException {
        VentasService svc = new VentasService();
        return svc.calcular(dto, igv);
    }

    public int getIdventa() throws SQLException {
        VentasService svc = new VentasService();
        return svc.getIdVenta();
    }

    public boolean insertarVenta(VentaDto dto) throws SQLException {

        VentasService svc = new VentasService();
        return svc.insertarVenta(dto);
    }

    public boolean actualizarStock(int cantidad, String idPublicacion) throws SQLException {
        PublicacionService svc = new PublicacionService();
        return svc.actualizarStock(cantidad, idPublicacion);
    }

    public double getIgv() throws SQLException {
        ControlService svc = new ControlService();
        return Double.parseDouble(svc.getControl("IGV"));
    }

    public boolean sumVenta() throws SQLException {
        ControlService svc = new ControlService();
        int venta = Integer.parseInt(svc.getControl("VENTA"));
        return  svc.actualizarControl("VENTA", String.valueOf(venta + 1));

    }

}
