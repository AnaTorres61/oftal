package com.oftaldb.util;

import java.sql.SQLException;
import java.util.List;

import com.oftaldb.DAO.EspecialidadeDAO;
import com.oftaldb.model.Especialidade;


public class EspecialidadeTeste {
    static EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();

    public static void main(String[] args) throws SQLException {

        System.out.println("cout");
        System.out.println(especialidadeDAO.count());

        System.out.println("salvar");
        Especialidade especialidade = new Especialidade("Clinico Geral", "CFM");
        especialidadeDAO.insertEspecialidade(especialidade);

        System.out.println("busca por ID");
        especialidade = especialidadeDAO.selectEspecialidade(1);
        System.out.println(especialidade);

        System.out.println("update");
        especialidade.setConselho("CREMEC");
        especialidadeDAO.updateEspecialidade(especialidade);
        especialidade = especialidadeDAO.selectEspecialidade(1);
        System.out.println(especialidade);

        System.out.println("select all");
        List<Especialidade> especialidades = especialidadeDAO.selectAllEspecialidades();
        especialidades.forEach(System.out::println);

        System.out.println("delete");
        especialidadeDAO.deleteEspecialidade(1);
        especialidadeDAO.selectAllEspecialidades().forEach(System.out::println);
    }    
}
