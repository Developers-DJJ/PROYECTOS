package pe.edu.uni.kabestore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.kabestore.db.AccesoDB;
import pe.edu.uni.kabestore.dto.EmpleadoDto;

public class EmpleadoService {

    private Connection cn;
    private PreparedStatement pstm;

    private final String GET_ALL = "select idempleado, apellido , nombre from EMPLEADO;";

    public List<EmpleadoDto> listarEmpleados() throws SQLException {

        List<EmpleadoDto> empleados = new ArrayList<>();
        
        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_ALL);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                EmpleadoDto dto = new EmpleadoDto();
                dto.setIdEmpleado(rs.getInt("idempleado"));
                dto.setApellido(rs.getString("apellido"));
                dto.setNombre(rs.getString("nombre"));
                
                empleados.add(dto);
            }
              pstm.close();
            
        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return empleados;
    }

}
