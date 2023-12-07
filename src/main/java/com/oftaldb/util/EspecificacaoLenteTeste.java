package com.oftaldb.util;

import java.sql.SQLException;
import java.util.List;

import com.oftaldb.DAO.EspecificacaoLenteDAO;
import com.oftaldb.model.EspecificacaoLente;

public class EspecificacaoLenteTeste {
    static EspecificacaoLenteDAO especificacao_lenteDAO = new EspecificacaoLenteDAO();

    public static void main(String[] args) throws SQLException {

        System.out.println("cout");
        System.out.println(especificacao_lenteDAO.count());

        System.out.println("salvar");
        EspecificacaoLente especificacao_lente = new EspecificacaoLente(100.99f, 1, 1);
        especificacao_lenteDAO.insertEspecificacaoLente(especificacao_lente);

        System.out.println("busca por ID");
        especificacao_lente = especificacao_lenteDAO.selectEspecificacaoLente(1);
        System.out.println(especificacao_lente);

        System.out.println("update");
        especificacao_lente.setValor(199f);
        especificacao_lenteDAO.updateEspecificacaoLente(especificacao_lente);
        especificacao_lente = especificacao_lenteDAO.selectEspecificacaoLente(1);
        System.out.println(especificacao_lente);

        System.out.println("select all");
        List<EspecificacaoLente> especificacao_lentes = especificacao_lenteDAO.selectAllEspecificacaoLentes();
        especificacao_lentes.forEach(System.out::println);

        System.out.println("delete");
        especificacao_lenteDAO.deleteEspecificacaoLente(1);
        especificacao_lenteDAO.selectAllEspecificacaoLentes().forEach(System.out::println);
    } 
}
