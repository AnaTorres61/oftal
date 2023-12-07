package com.oftaldb.util;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.oftaldb.DAO.EspecialidadeMedicaDAO;
import com.oftaldb.model.EspecialidadeMedica;

public class EspecialidadeMedicaTeste {
    static EspecialidadeMedicaDAO especialidade_medicaDAO = new EspecialidadeMedicaDAO();

    public static void main(String[] args) throws SQLException {

        System.out.println("cout");
        System.out.println(especialidade_medicaDAO.count());

        System.out.println("salvar");
        EspecialidadeMedica especialidade_medica = new EspecialidadeMedica(1, 1);
        especialidade_medicaDAO.insertEspecialidadeMedica(especialidade_medica);

        System.out.println("busca por ID");
        especialidade_medica = especialidade_medicaDAO.selectEspecialidadeMedica(1);
        System.out.println(especialidade_medica);

        System.out.println("update");
        especialidade_medica.setDtConclusao(Date.valueOf("1970-12-30"));
        especialidade_medicaDAO.updateEspecialidadeMedica(especialidade_medica);
        especialidade_medica = especialidade_medicaDAO.selectEspecialidadeMedica(1);
        System.out.println(especialidade_medica);

        System.out.println("select all");
        List<EspecialidadeMedica> especialidade_medicas = especialidade_medicaDAO.selectAllEspecialidadeMedicas();
        especialidade_medicas.forEach(System.out::println);

        System.out.println("delete");
        especialidade_medicaDAO.deleteEspecialidadeMedica(1);
        especialidade_medicaDAO.selectAllEspecialidadeMedicas().forEach(System.out::println);
    } 
}
