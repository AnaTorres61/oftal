package com.oftaldb.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oftaldb.model.ReceitaOculos;

public class ReceitaOculosDAO extends ConexaoDB {

    private static final String INSERT_RECEITAOCULOS_SQL = "INSERT INTO receita_oculos (detalhamento, id_consulta) VALUES (?, ?);";
    private static final String SELECT_RECEITAOCULOS_BY_ID = "SELECT id, detalhamento, id_consulta FROM receita_oculos WHERE id = ?";
    private static final String SELECT_ALL_RECEITAOCULOS = "SELECT * FROM receita_oculos;";
    private static final String DELETE_RECEITAOCULOS_SQL = "DELETE FROM receita_oculos WHERE id = ?;";
    private static final String UPDATE_RECEITAOCULOS_SQL = "UPDATE receita_oculos SET detalhamento = ?, id_consulta = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM receita_oculos;";

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

    public void insertReceitaOculos(ReceitaOculos entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_RECEITAOCULOS_SQL)) {
            preparedStatement.setString(1, entidade.getDetalhamento());
            preparedStatement.setInt(2, entidade.getIdConsulta());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ReceitaOculos selectReceitaOculos(int id) {
        ReceitaOculos entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_RECEITAOCULOS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String detalhamento = rs.getString("detalhamento");
                Integer id_consulta = rs.getInt("id_consulta");
                entidade = new ReceitaOculos(id, detalhamento, id_consulta);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ReceitaOculos> selectAllReceitaOculos() {
        List<ReceitaOculos> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_RECEITAOCULOS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String detalhamento = rs.getString("detalhamento");
                Integer id_consulta = rs.getInt("id_consulta");
                entidades.add(new ReceitaOculos(id, detalhamento, id_consulta));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteReceitaOculos(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_RECEITAOCULOS_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateReceitaOculos(ReceitaOculos entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_RECEITAOCULOS_SQL)) {
            statement.setString(1, entidade.getDetalhamento());
            statement.setInt(2, entidade.getIdConsulta());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
