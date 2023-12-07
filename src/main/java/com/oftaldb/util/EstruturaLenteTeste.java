package com.oftaldb.util;

import java.sql.SQLException;
import java.util.List;

import com.oftaldb.DAO.EstruturaLenteDAO;
import com.oftaldb.model.EstruturaLente;

public class EstruturaLenteTeste {
    static EstruturaLenteDAO estrutura_lenteDAO = new EstruturaLenteDAO();

    public static void main(String[] args) throws SQLException {

        System.out.println("cout");
        System.out.println(estrutura_lenteDAO.count());

        System.out.println("salvar");
        EstruturaLente estrutura_lente = new EstruturaLente("tipo1", 1, 1);
        estrutura_lenteDAO.insertEstruturaLente(estrutura_lente);

        System.out.println("busca por ID");
        estrutura_lente = estrutura_lenteDAO.selectEstruturaLente(1);
        System.out.println(estrutura_lente);

        System.out.println("update");
        estrutura_lente.setTipoCorrecao("tipo2");
        estrutura_lenteDAO.updateEstruturaLente(estrutura_lente);
        estrutura_lente = estrutura_lenteDAO.selectEstruturaLente(1);
        System.out.println(estrutura_lente);

        System.out.println("select all");
        List<EstruturaLente> estrutura_lentes = estrutura_lenteDAO.selectAllEstruturaLentes();
        estrutura_lentes.forEach(System.out::println);

        System.out.println("delete");
        estrutura_lenteDAO.deleteEstruturaLente(1);
        estrutura_lenteDAO.selectAllEstruturaLentes().forEach(System.out::println);
    } 
}
