package com.oftaldb.util;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.oftaldb.DAO.*;
import com.oftaldb.model.*;


public class Teste {
    static EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
    static PacienteDAO pacienteDAO = new PacienteDAO();
    static MedicoDAO medicoDAO = new MedicoDAO();
    static EspecialidadeMedicaDAO especialidadeMedicaDAO = new EspecialidadeMedicaDAO();
    static ConsultaDAO consultaDAO = new ConsultaDAO();
    static ReceitaOculosDAO receitaOculosDAO = new ReceitaOculosDAO();
    static ObservacaoLaudoDAO observacaoLaudoDAO = new ObservacaoLaudoDAO();
    static EstruturaLenteDAO estruturaLenteDAO = new EstruturaLenteDAO();
    static EspecificacaoLenteDAO especificacaoLenteDAO = new EspecificacaoLenteDAO();
    static AtributoEstruturaLenteDAO atributoEstruturaLenteDAO = new AtributoEstruturaLenteDAO();

    public static void main(String[] args) throws SQLException, ParseException {

        // salvar
        // Paciente paciente = new Paciente("Ana", "11122233344", Date.valueOf("2000-04-18"));
        // pacienteDAO.insertPaciente(paciente);

        // Medico medico = new Medico("Antonio", "254254");
        // medicoDAO.insertMedico(medico);

        // Especialidade especialidade = new Especialidade("Clinico Geral", "CFM");
        // especialidadeDAO.insertEspecialidade(especialidade);

        // EspecialidadeMedica especialidadeMedica = new EspecialidadeMedica(especialidade.getId(), medico.getId());
        // especialidadeMedicaDAO.insertEspecialidadeMedica(especialidadeMedica);

        // Consulta consulta = new Consulta("Antonio", Date.valueOf("2023-12-05"), 1, 1);
        // consultaDAO.insertConsulta(consulta);

        // ReceitaOculos receitaOculos = new ReceitaOculos(consulta.getId());
        // receitaOculosDAO.insertReceitaOculos(receitaOculos);

        // ObservacaoLaudo observacaoLaudo = new ObservacaoLaudo("Teste observacao laudo", receitaOculos.getId());
        // observacaoLaudoDAO.insertObservacaoLaudo(observacaoLaudo);

        // AtributoEstruturaLente atributoEstruturaLente = new AtributoEstruturaLente(null, "esquerdo");
        // atributoEstruturaLenteDAO.insertAtributoEstruturaLente(atributoEstruturaLente);

        // EstruturaLente estruturaLente = new EstruturaLente(null, 1, receitaOculos.getId());
        // estruturaLenteDAO.insertEstruturaLente(estruturaLente);

        // EspecificacaoLente especificacaoLente = new EspecificacaoLente( 1, estruturaLente.getId(), atributoEstruturaLente.getId());
        // especificacaoLenteDAO.insertEspecificacaoLente(especificacaoLente);

        // // select all
        // List<Paciente> pacientes = pacienteDAO.selectAllPacientes();
        // pacientes.forEach(System.out::println);

        // update
        // Consulta consulta = consultaDAO.selectConsulta(1);
        // consulta.setAssinatura("Anton");
        // consultaDAO.updateConsulta(consulta);
        // consulta = consultaDAO.selectConsulta(1);

        // delete
        pacienteDAO.deletePaciente(1);
        pacienteDAO.selectAllPacientes().forEach(System.out::println);

        // consultaDAO.deleteConsulta(1);
        // consultaDAO.selectAllConsultas().forEach(System.out::println);

    }
}
