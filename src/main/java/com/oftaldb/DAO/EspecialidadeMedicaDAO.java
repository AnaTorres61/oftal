package com.oftaldb.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.oftaldb.model.EspecialidadeMedica;

public class EspecialidadeMedicaDAO extends ConexaoDB {

    private static final String INSERT_ESPECIALIDADEMEDICA_SQL = "INSERT INTO especialidade_medica (observacao, dt_conclusao, id_especialidade, id_medico) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ESPECIALIDADEMEDICA_BY_ID = "SELECT id, observacao, dt_conclusao, id_especialidade, id_medico FROM especialidade_medica WHERE id = ?";
    private static final String SELECT_ALL_ESPECIALIDADEMEDICA = "SELECT * FROM especialidade_medica;";
    private static final String DELETE_ESPECIALIDADEMEDICA_SQL = "DELETE FROM especialidade_medica WHERE id = ?;";
    private static final String UPDATE_ESPECIALIDADEMEDICA_SQL = "UPDATE especialidade_medica SET observacao = ?, dt_conclusao = ?, id_especialidade = ?, id_medico = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM especialidade_medica;";

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

    public void insertEspecialidadeMedica(EspecialidadeMedica entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_ESPECIALIDADEMEDICA_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setDate(2, new java.sql.Date(entidade.getDtConclusao().getTime()));
            preparedStatement.setInt(3, entidade.getIdEspecialidade());
            preparedStatement.setInt(4, entidade.getIdMedico());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public EspecialidadeMedica selectEspecialidadeMedica(int id) {
        EspecialidadeMedica entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ESPECIALIDADEMEDICA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Date dt_conclusao = rs.getDate("dt_conclusao");
                Integer id_especialidade = rs.getInt("id_especialidade");
                Integer id_medico = rs.getInt("id_medico");
                entidade = new EspecialidadeMedica(id, observacao, dt_conclusao, id_especialidade, id_medico);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<EspecialidadeMedica> selectAllEspecialidadeMedicas() {
        List<EspecialidadeMedica> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_ESPECIALIDADEMEDICA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Date dt_conclusao = rs.getDate("dt_conclusao");
                Integer id_especialidade = rs.getInt("id_especialidade");
                Integer id_medico = rs.getInt("id_medico");
                entidades.add(new EspecialidadeMedica(id, observacao, dt_conclusao, id_especialidade, id_medico));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEspecialidadeMedica(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_ESPECIALIDADEMEDICA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEspecialidadeMedica(EspecialidadeMedica entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_ESPECIALIDADEMEDICA_SQL)) {
            statement.setString(1, entidade.getObservacao());
            statement.setDate(2, new java.sql.Date(entidade.getDtConclusao().getTime()));
            statement.setInt(3, entidade.getIdEspecialidade());
            statement.setInt(4, entidade.getIdMedico());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}