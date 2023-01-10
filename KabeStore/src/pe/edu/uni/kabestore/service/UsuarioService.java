package pe.edu.uni.kabestore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uni.kabestore.db.AccesoDB;
import pe.edu.uni.kabestore.dto.EmpleadoDto;
import pe.edu.uni.kabestore.dto.UsuarioDto;

public class UsuarioService extends EmpleadoDto {

    private Connection cn;

    public UsuarioDto validarUsuario(String usuario, String clave) {
        UsuarioDto dto = null;
        final String SQL = "select u.idempleado as idempleado,e.apellido as apellido,e.nombre as nombre,activo , e.direccion as direccion, e.email, u.usuario as usuario,  u.clave as clave "
                + "from USUARIO U inner join EMPLEADO E on u.idempleado=e."
                + "idempleado where u.usuario=? and u.clave=?;";
        try {
            cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(SQL);
            pstm.setString(1, usuario);
            pstm.setString(2, clave);
            ResultSet rs = pstm.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Datos incorrectos.");
            }
            dto = new UsuarioDto();
            dto.setIdEmpleado(rs.getInt("idempleado"));
            dto.setApellido(rs.getString("apellido"));
            dto.setNombre(rs.getString("nombre"));
            dto.setDireccion(rs.getString("direccion"));
            dto.setEmail(rs.getString("email"));
            dto.setUsuario(rs.getString("usuario"));
            dto.setClave(rs.getString("clave"));

            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error en el proceso, intentelo nuevamente.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return dto;
    }
}
