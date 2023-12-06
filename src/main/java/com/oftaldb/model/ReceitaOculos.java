package com.oftaldb.model;

public class ReceitaOculos extends GenericModel {
    private String detalhamento;
    private Integer idConsulta;

    public ReceitaOculos(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public ReceitaOculos(String detalhamento, Integer idConsulta) {
        this.detalhamento = detalhamento;
        this.idConsulta = idConsulta;
    }

    public ReceitaOculos(Integer id, String detalhamento, Integer idConsulta) {
        this.detalhamento = detalhamento;
        this.idConsulta = idConsulta;
        super.setId(id);
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    @Override
    public String toString() {
        return "ReceitaOculos {" +
                "id='" + this.getId() + "\'" +
                "detalhamento='" + detalhamento + "\'" +
                "idConsulta='" + idConsulta + "\'" +
                '}';
    }
}
