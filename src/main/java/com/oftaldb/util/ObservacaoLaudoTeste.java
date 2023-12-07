package com.oftaldb.util;

import java.sql.SQLException;
import java.util.List;

import com.oftaldb.DAO.ObservacaoLaudoDAO;
import com.oftaldb.model.ObservacaoLaudo;

public class ObservacaoLaudoTeste {
    static ObservacaoLaudoDAO observacao_laudoDAO = new ObservacaoLaudoDAO();

    public static void main(String[] args) throws SQLException {

        System.out.println("cout");
        System.out.println(observacao_laudoDAO.count());

        System.out.println("salvar");
        ObservacaoLaudo observacao_laudo = new ObservacaoLaudo("observacao", 1);
        observacao_laudoDAO.insertObservacaoLaudo(observacao_laudo);

        System.out.println("busca por ID");
        observacao_laudo = observacao_laudoDAO.selectObservacaoLaudo(1);
        System.out.println(observacao_laudo);

        System.out.println("update");
        observacao_laudo.setDescricao("descricao");
        observacao_laudoDAO.updateObservacaoLaudo(observacao_laudo);
        observacao_laudo = observacao_laudoDAO.selectObservacaoLaudo(1);
        System.out.println(observacao_laudo);

        System.out.println("select all");
        List<ObservacaoLaudo> observacao_laudos = observacao_laudoDAO.selectAllObservacaoLaudos();
        observacao_laudos.forEach(System.out::println);

        System.out.println("delete");
        observacao_laudoDAO.deleteObservacaoLaudo(1);
        observacao_laudoDAO.selectAllObservacaoLaudos().forEach(System.out::println);
    } 
}
