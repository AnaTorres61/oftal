package com.oftaldb.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oftaldb.model.ObservacaoLaudo;

public class ObservacaoLaudoDAO extends ConexaoDB {

    private static final String INSERT_OBSERVACAOLAUDO_SQL = "INSERT INTO observacao_laudo (descricao, id_receita_oculos) VALUES (?, ?);";
    private static final String SELECT_OBSERVACAOLAUDO_BY_ID = "SELECT id, descricao, id_receita_oculos FROM observacao_laudo WHERE id = ?";
    private static final String SELECT_ALL_OBSERVACAOLAUDO = "SELECT * FROM observacao_laudo;";
    private static final String DELETE_OBSERVACAOLAUDO_SQL = "DELETE FROM observacao_laudo WHERE id = ?;";
    private static final String UPDATE_OBSERVACAOLAUDO_SQL = "UPDATE observacao_laudo SET descricao = ?, id_receita_oculos = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM observacao_laudo;";

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

    public void insertObservacaoLaudo(ObservacaoLaudo entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_OBSERVACAOLAUDO_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getIdReceitaOculos());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservacaoLaudo selectObservacaoLaudo(int id) {
        ObservacaoLaudo entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_OBSERVACAOLAUDO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Integer id_receita_oculos = rs.getInt("id_receita_oculos");
                entidade = new ObservacaoLaudo(id, descricao, id_receita_oculos);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ObservacaoLaudo> selectAllObservacaoLaudos() {
        List<ObservacaoLaudo> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_OBSERVACAOLAUDO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Integer id_receita_oculos = rs.getInt("id_receita_oculos");
                entidades.add(new ObservacaoLaudo(id, descricao, id_receita_oculos));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteObservacaoLaudo(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_OBSERVACAOLAUDO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateObservacaoLaudo(ObservacaoLaudo entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_OBSERVACAOLAUDO_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getIdReceitaOculos());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}