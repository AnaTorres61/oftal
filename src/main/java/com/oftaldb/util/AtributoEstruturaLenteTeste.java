package com.oftaldb.util;

import java.sql.SQLException;
import java.util.List;

import com.oftaldb.DAO.AtributoEstruturaLenteDAO;
import com.oftaldb.model.AtributoEstruturaLente;

public class AtributoEstruturaLenteTeste {
    static AtributoEstruturaLenteDAO atributo_estrutura_lenteDAO = new AtributoEstruturaLenteDAO();

    public static void main(String[] args) throws SQLException {

        System.out.println("cout");
        System.out.println(atributo_estrutura_lenteDAO.count());

        System.out.println("salvar");
        AtributoEstruturaLente atributo_estrutura_lente = new AtributoEstruturaLente("None", "Esquerdo");
        atributo_estrutura_lenteDAO.insertAtributoEstruturaLente(atributo_estrutura_lente);

        System.out.println("busca por ID");
        atributo_estrutura_lente = atributo_estrutura_lenteDAO.selectAtributoEstruturaLente(1);
        System.out.println(atributo_estrutura_lente);

        System.out.println("update");
        atributo_estrutura_lente.setDescricao("Descricao");
        atributo_estrutura_lenteDAO.updateAtributoEstruturaLente(atributo_estrutura_lente);
        atributo_estrutura_lente = atributo_estrutura_lenteDAO.selectAtributoEstruturaLente(1);
        System.out.println(atributo_estrutura_lente);

        System.out.println("select all");
        List<AtributoEstruturaLente> atributo_estrutura_lentes = atributo_estrutura_lenteDAO.selectAllAtributoEstruturaLentes();
        atributo_estrutura_lentes.forEach(System.out::println);

        System.out.println("delete");
        atributo_estrutura_lenteDAO.deleteAtributoEstruturaLente(1);
        atributo_estrutura_lenteDAO.selectAllAtributoEstruturaLentes().forEach(System.out::println);
    } 
}
