package pe.edu.uni.kabestore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.kabestore.db.AccesoDB;
import pe.edu.uni.kabestore.dto.TipoDto;

public class TipoService {

    private Connection cn;
    public List<TipoDto> listarTipoDto() throws SQLException {

        List<TipoDto> tipos = new ArrayList<>();

        final String SQL = "select idtipo, descripcion , contador from tipo";

        try {
            cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                TipoDto dto = new TipoDto();
                dto.setIdTipo(rs.getString("idtipo"));
                dto.setDescripcion(rs.getString("descripcion"));
                dto.setContador(rs.getInt("contador"));
                tipos.add(dto);
            }
            pstm.close();
        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return tipos;
    }
}
