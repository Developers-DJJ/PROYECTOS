package pe.edu.uni.kabestore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.kabestore.db.AccesoDB;
import pe.edu.uni.kabestore.dto.PublicacionDto;

public class PublicacionService {

    private Connection cn;
    private PreparedStatement pstm;

    private final String GET_ALL = "select idpublicacion, titulo, idtipo, autor, nroedicion, precio , stock from PUBLICACION; ";

    private final String GET_ID = "select idpublicacion from PUBLICACION "
            + "where stock>0 and idpublicacion = ? ;";
    private final String GET_IDPUBLICACION = "SELECT idpublicacion, stock , precio FROM PUBLICACION\n"
            + "WHERE idpublicacion = ? ;";
    private final String GET_IDTIPO = "select idpublicacion, titulo, idtipo,autor, nroedicion, precio, stock from PUBLICACION "
            + "where idtipo = ? and idpublicacion LIKE ? ;";

    private final String UPDATE_PRECIO = "update PUBLICACION "
            + "set precio = ? "
            + "where idpublicacion = ?";
    
    private final String UPDATE_STOCK = "update PUBLICACION set stock=stock - ? "
            + "where idpublicacion= ? ";

    public List<PublicacionDto> listarPublicacion() throws SQLException {

        List<PublicacionDto> publicaciones = new ArrayList<>();

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_ALL);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                PublicacionDto dto = new PublicacionDto();
                dto.setIdPublicacion(rs.getString("idpublicacion"));
                dto.setTitulo(rs.getString("titulo"));
                dto.setIdTipo(rs.getString("idtipo"));
                dto.setAutor(rs.getString("autor"));
                dto.setNroEdicion(rs.getInt("nroedicion"));
                dto.setPrecio(rs.getDouble("precio"));
                dto.setStock(rs.getInt("stock"));

                publicaciones.add(dto);
            }
            pstm.close();

        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return publicaciones;
    }

    public boolean validarStock(String id) throws SQLException {

        boolean respuesta = false;

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_ID);
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
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

    public boolean actualizarPublicacion(String id, double precio) throws SQLException {
        boolean respuesta = false;

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(UPDATE_PRECIO);
            pstm.setDouble(1, precio);
            pstm.setString(2, id);

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
    
     public boolean actualizarStock(int cantidad, String idPublicacion) throws SQLException {
         
        boolean respuesta = false;

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(UPDATE_STOCK);
            pstm.setInt(1, cantidad);
            pstm.setString(2, idPublicacion);

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

    public List<PublicacionDto> listarPublicacionesPorTipo(String idTipo, String idPublicacion) throws SQLException {

        List<PublicacionDto> lista = new ArrayList<>();

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_IDTIPO);
            pstm.setString(1, idTipo);
            pstm.setString(2,"%" + idPublicacion + "%");
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                PublicacionDto dto = new PublicacionDto();
                dto.setIdPublicacion(rs.getString("idpublicacion"));
                dto.setTitulo(rs.getString("titulo"));
                dto.setIdTipo(rs.getString("idtipo"));
                dto.setAutor(rs.getString("autor"));
                dto.setNroEdicion(rs.getInt("nroedicion"));
                dto.setPrecio(rs.getDouble("precio"));
                dto.setStock(rs.getInt("stock"));

                lista.add(dto);
            }
            pstm.close();

        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return lista;
    }

    public PublicacionDto getPublicacionPorId(String idPublicacion) throws SQLException {

        PublicacionDto publicacion = new PublicacionDto();

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_IDPUBLICACION);
            pstm.setString(1, idPublicacion);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                publicacion.setIdPublicacion(rs.getString("idpublicacion"));
                publicacion.setStock(rs.getInt("stock"));
                publicacion.setPrecio(rs.getDouble("precio"));

            }
            pstm.close();

        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return publicacion;
    }

}
