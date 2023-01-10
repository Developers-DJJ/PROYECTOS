package pe.edu.uni.kabestore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.kabestore.db.AccesoDB;
import pe.edu.uni.kabestore.dto.ControlDto;

public class ControlService {

    private Connection cn;
    private PreparedStatement pstm;

    private final String GET_ALL = "SELECT parametro, valor FROM CONTROL; ";

    private final String GET = "select valor from control "
            + "where parametro = ? ;";

    private final String UPDATE = "UPDATE CONTROL SET VALOR = ? "
            + "WHERE parametro = ? ";

    public List<ControlDto> listarControl() throws SQLException {

        List<ControlDto> controles = new ArrayList<>();

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_ALL);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                ControlDto dto = new ControlDto();
                dto.setParametro(rs.getString("parametro"));
                dto.setValor(rs.getString("valor"));

                controles.add(dto);
            }
            pstm.close();

        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return controles;
    }

    public String getControl(String parametro) throws SQLException {

        String control = "";

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET);
            pstm.setString(1, parametro);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                control = rs.getString("valor");
            }
            pstm.close();

        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return control;
    }

    public boolean actualizarControl(String parametro, String valor) throws SQLException {

        boolean respuesta = false;

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(UPDATE);
            pstm.setString(1, valor);
            pstm.setString(2, parametro);

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
