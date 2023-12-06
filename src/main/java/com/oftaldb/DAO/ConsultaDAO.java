package com.oftaldb.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.oftaldb.model.Consulta;

public class ConsultaDAO extends ConexaoDB {

    private static final String INSERT_CONSULTA_SQL = "INSERT INTO consulta (assinatura, dt_consulta, id_paciente, id_medico) VALUES (?, ?, ?, ?);";
    private static final String SELECT_CONSULTA_BY_ID = "SELECT id, assinatura, dt_consulta, id_paciente, id_medico FROM consulta WHERE id = ?";
    private static final String SELECT_ALL_CONSULTA = "SELECT * FROM consulta;";
    private static final String DELETE_CONSULTA_SQL = "DELETE FROM consulta WHERE id = ?;";
    private static final String UPDATE_CONSULTA_SQL = "UPDATE consulta SET assinatura = ?, dt_consulta = ?, id_paciente = ?, id_medico = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM consulta;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prapararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insertConsulta(Consulta entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_CONSULTA_SQL)) {
            preparedStatement.setString(1, entidade.getAssinatura());
            preparedStatement.setDate(2, new java.sql.Date(entidade.getDtConsulta().getTime()));
            preparedStatement.setInt(3, entidade.getIdPaciente());
            preparedStatement.setInt(4, entidade.getIdMedico());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Consulta selectConsulta(int id) {
        Consulta entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_CONSULTA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String assinatura = rs.getString("assinatura");
                Date dt_consulta = rs.getDate("dt_consulta");
                Integer id_paciente = rs.getInt("id_paciente");
                Integer id_medico = rs.getInt("id_medico");
                entidade = new Consulta(id, assinatura, dt_consulta, id_paciente, id_medico);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Consulta> selectAllConsultas() {
        List<Consulta> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_CONSULTA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String assinatura = rs.getString("assinatura");
                Date dt_consulta = rs.getDate("dt_consulta");
                Integer id_paciente = rs.getInt("id_paciente");
                Integer id_medico = rs.getInt("id_medico");
                entidades.add(new Consulta(id, assinatura, dt_consulta, id_paciente, id_medico));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteConsulta(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_CONSULTA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateConsulta(Consulta entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_CONSULTA_SQL)) {
            statement.setString(1, entidade.getAssinatura());
            statement.setDate(2, new java.sql.Date(entidade.getDtConsulta().getTime()));
            statement.setInt(3, entidade.getIdPaciente());
            statement.setInt(4, entidade.getIdMedico());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
