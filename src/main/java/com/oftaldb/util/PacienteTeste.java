package com.oftaldb.util;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.oftaldb.DAO.PacienteDAO;
import com.oftaldb.model.Paciente;

public class PacienteTeste {
    static PacienteDAO pacienteDAO = new PacienteDAO();

    public static void main(String[] args) throws SQLException {

        System.out.println("cout");
        System.out.println(pacienteDAO.count());

        System.out.println("salvar");
        Paciente paciente = new Paciente("Ana", "11122233344", Date.valueOf("2000-04-18"));
        pacienteDAO.insertPaciente(paciente);

        System.out.println("busca por ID");
        paciente = pacienteDAO.selectPaciente(1);
        System.out.println(paciente);

        System.out.println("update");
        paciente.setDtNascimento(Date.valueOf("2000-04-17"));
        pacienteDAO.updatePaciente(paciente);
        paciente = pacienteDAO.selectPaciente(1);
        System.out.println(paciente);

        System.out.println("select all");
        List<Paciente> pacientes = pacienteDAO.selectAllPacientes();
        pacientes.forEach(System.out::println);

        System.out.println("delete");
        pacienteDAO.deletePaciente(1);
        pacienteDAO.selectAllPacientes().forEach(System.out::println);
    }    
}
