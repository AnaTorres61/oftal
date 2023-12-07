package com.oftaldb.util;

import java.sql.SQLException;
import java.util.List;

import com.oftaldb.DAO.MedicoDAO;
import com.oftaldb.model.Medico;

public class MedicoTeste {
    static MedicoDAO medicoDAO = new MedicoDAO();

    public static void main(String[] args) throws SQLException {

        System.out.println("cout");
        System.out.println(medicoDAO.count());

        System.out.println("salvar");
        Medico medico = new Medico("Carlos", "17998");
        medicoDAO.insertMedico(medico);

        System.out.println("busca por ID");
        medico = medicoDAO.selectMedico(1);
        System.out.println(medico);

        System.out.println("update");
        medico.setCrm("11111");
        medicoDAO.updateMedico(medico);
        medico = medicoDAO.selectMedico(1);
        System.out.println(medico);

        System.out.println("select all");
        List<Medico> medicos = medicoDAO.selectAllMedicos();
        medicos.forEach(System.out::println);

        System.out.println("delete");
        medicoDAO.deleteMedico(1);
        medicoDAO.selectAllMedicos().forEach(System.out::println);
    } 
}
