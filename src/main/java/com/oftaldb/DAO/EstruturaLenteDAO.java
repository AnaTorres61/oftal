package com.oftaldb.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oftaldb.model.EstruturaLente;

public class EstruturaLenteDAO extends ConexaoDB {

    private static final String INSERT_ESTRUTURALENTE_SQL = "INSERT INTO estrutura_lente (tipo_correcao, distancia_pupila, id_receita_oculos) VALUES (?, ?, ?);";
    private static final String SELECT_ESTRUTURALENTE_BY_ID = "SELECT id, tipo_correcao, distancia_pupila, id_receita_oculos FROM estrutura_lente WHERE id = ?";
    private static final String SELECT_ALL_ESTRUTURALENTE = "SELECT * FROM estrutura_lente;";
    private static final String DELETE_ESTRUTURALENTE_SQL = "DELETE FROM estrutura_lente WHERE id = ?;";
    private static final String UPDATE_ESTRUTURALENTE_SQL = "UPDATE estrutura_lente SET tipo_correcao = ?, distancia_pupila = ?, id_receita_oculos = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM estrutura_lente;";

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

    public void insertEstruturaLente(EstruturaLente entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_ESTRUTURALENTE_SQL)) {
            preparedStatement.setString(1, entidade.getTipoCorrecao());
            preparedStatement.setInt(2, entidade.getDistanciaPupila());
            preparedStatement.setInt(3, entidade.getIdReceitaOculos());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public EstruturaLente selectEstruturaLente(int id) {
        EstruturaLente entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ESTRUTURALENTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String tipo_correcao = rs.getString("tipo_correcao");
                Integer distancia_pupila = rs.getInt("distancia_pupila");
                Integer id_receita_oculos = rs.getInt("id_receita_oculos");
                entidade = new EstruturaLente(id, tipo_correcao, distancia_pupila, id_receita_oculos);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<EstruturaLente> selectAllEstruturaLentes() {
        List<EstruturaLente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_ESTRUTURALENTE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo_correcao = rs.getString("tipo_correcao");
                Integer distancia_pupila = rs.getInt("distancia_pupila");
                Integer id_receita_oculos = rs.getInt("id_receita_oculos");
                entidades.add(new EstruturaLente(id, tipo_correcao, distancia_pupila, id_receita_oculos));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEstruturaLente(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_ESTRUTURALENTE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEstruturaLente(EstruturaLente entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_ESTRUTURALENTE_SQL)) {
            statement.setString(1, entidade.getTipoCorrecao());
            statement.setInt(2, entidade.getDistanciaPupila());
            statement.setInt(3, entidade.getIdReceitaOculos());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
