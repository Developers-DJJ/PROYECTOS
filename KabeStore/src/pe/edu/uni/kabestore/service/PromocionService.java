package pe.edu.uni.kabestore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uni.kabestore.db.AccesoDB;
import pe.edu.uni.kabestore.dto.PromocionDto;

public class PromocionService {

    private Connection cn;
    private PreparedStatement pstm;

    private final String GET_PORCENTAJE = "SELECT porcentaje "
            + "FROM PROMOCION "
            + "WHERE " +  "? "
            + "between cantmin AND cantmax;";
    
     public PromocionDto getPorcentajePromocion(int cantidad) throws SQLException{
          PromocionDto Porcentaje = new PromocionDto();

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_PORCENTAJE);
            pstm.setInt(1, cantidad);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Porcentaje.setPorcentaje(rs.getDouble("porcentaje"));      
            }
            pstm.close();

        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return Porcentaje;
    }
}
