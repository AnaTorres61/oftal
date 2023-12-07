package com.oftaldb.util;

import java.sql.SQLException;
import java.util.List;

import com.oftaldb.DAO.ReceitaOculosDAO;
import com.oftaldb.model.ReceitaOculos;

public class ReceitaOculosTeste {
    static ReceitaOculosDAO receita_oculosDAO = new ReceitaOculosDAO();

    public static void main(String[] args) throws SQLException {

        System.out.println("cout");
        System.out.println(receita_oculosDAO.count());

        System.out.println("salvar");
        ReceitaOculos receita_oculos = new ReceitaOculos(1);
        receita_oculosDAO.insertReceitaOculos(receita_oculos);

        System.out.println("busca por ID");
        receita_oculos = receita_oculosDAO.selectReceitaOculos(1);
        System.out.println(receita_oculos);

        System.out.println("update");
        receita_oculos.setDetalhamento("detalhes");
        receita_oculosDAO.updateReceitaOculos(receita_oculos);
        receita_oculos = receita_oculosDAO.selectReceitaOculos(1);
        System.out.println(receita_oculos);

        System.out.println("select all");
        List<ReceitaOculos> receita_oculoss = receita_oculosDAO.selectAllReceitaOculos();
        receita_oculoss.forEach(System.out::println);

        System.out.println("delete");
        receita_oculosDAO.deleteReceitaOculos(1);
        receita_oculosDAO.selectAllReceitaOculos().forEach(System.out::println);
    } 
}
