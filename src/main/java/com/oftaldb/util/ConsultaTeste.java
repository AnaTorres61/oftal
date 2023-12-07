package com.oftaldb.util;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.oftaldb.DAO.ConsultaDAO;
import com.oftaldb.model.Consulta;

public class ConsultaTeste {
    static ConsultaDAO especialidadeDAO = new ConsultaDAO();

    public static void main(String[] args) throws SQLException {

        System.out.println("cout");
        System.out.println(especialidadeDAO.count());

        System.out.println("salvar");
        Consulta especialidade = new Consulta("Carlos", Date.valueOf("2023-05-12"), 1, 1);
        especialidadeDAO.insertConsulta(especialidade);

        System.out.println("busca por ID");
        especialidade = especialidadeDAO.selectConsulta(1);
        System.out.println(especialidade);

        System.out.println("update");
        especialidade.setAssinatura("Jorge");
        especialidadeDAO.updateConsulta(especialidade);
        especialidade = especialidadeDAO.selectConsulta(1);
        System.out.println(especialidade);

        System.out.println("select all");
        List<Consulta> especialidades = especialidadeDAO.selectAllConsultas();
        especialidades.forEach(System.out::println);

        System.out.println("delete");
        especialidadeDAO.deleteConsulta(1);
        especialidadeDAO.selectAllConsultas().forEach(System.out::println);
    } 
}
