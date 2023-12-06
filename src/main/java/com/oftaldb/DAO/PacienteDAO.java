package com.oftaldb.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.oftaldb.model.Paciente;

public class PacienteDAO extends ConexaoDB {

    private static final String INSERT_PACIENTE_SQL = "INSERT INTO paciente (nome, cpf, dt_nascimento) VALUES (?, ?, ?);";
    private static final String SELECT_PACIENTE_BY_ID = "SELECT id, nome, cpf, dt_nascimento FROM paciente WHERE id = ?";
    private static final String SELECT_ALL_PACIENTE = "SELECT * FROM paciente;";
    private static final String DELETE_PACIENTE_SQL = "DELETE FROM paciente WHERE id = ?;";
    private static final String UPDATE_PACIENTE_SQL = "UPDATE paciente SET nome = ?, cpf = ?, dt_nascimento = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM paciente;";

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

    public void insertPaciente(Paciente entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_PACIENTE_SQL)) {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setString(2, entidade.getCpf());
            preparedStatement.setDate(3, new java.sql.Date(entidade.getDtNascimento().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Paciente selectPaciente(int id) {
        Paciente entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_PACIENTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Date dt_nascimento = rs.getDate("dt_nascimento");
                entidade = new Paciente(id, nome, cpf, dt_nascimento);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Paciente> selectAllPacientes() {
        List<Paciente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_PACIENTE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Date dt_nascimento = rs.getDate("dt_nascimento");
                entidades.add(new Paciente(id, nome, cpf, dt_nascimento));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deletePaciente(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_PACIENTE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePaciente(Paciente entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_PACIENTE_SQL)) {
            statement.setString(1, entidade.getNome());
            statement.setString(2, entidade.getCpf());
            statement.setDate(3, new java.sql.Date(entidade.getDtNascimento().getTime()));
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
