package com.oftaldb.model;

public class EstruturaLente extends GenericModel {
    private String tipoCorrecao;
    private Integer distanciaPupila;
    private Integer idReceitaOculos;
    
    public EstruturaLente(String tipoCorrecao, Integer distanciaPupila, Integer idReceitaOculos) {
        this.tipoCorrecao = tipoCorrecao;
        this.distanciaPupila = distanciaPupila;
        this.idReceitaOculos = idReceitaOculos;
    }
    
    public EstruturaLente(Integer id, String tipoCorrecao, Integer distanciaPupila, Integer idReceitaOculos) {
        this.tipoCorrecao = tipoCorrecao;
        this.distanciaPupila = distanciaPupila;
        this.idReceitaOculos = idReceitaOculos;
        super.setId(id);
    }

    public String getTipoCorrecao() {
        return tipoCorrecao;
    }

    public void setTipoCorrecao(String tipoCorrecao) {
        this.tipoCorrecao = tipoCorrecao;
    }

    public Integer getDistanciaPupila() {
        return distanciaPupila;
    }

    public void setDistanciaPupila(Integer distanciaPupila) {
        this.distanciaPupila = distanciaPupila;
    }

    public Integer getIdReceitaOculos() {
        return idReceitaOculos;
    }

    public void setIdReceitaOculos(Integer idReceitaOculos) {
        this.idReceitaOculos = idReceitaOculos;
    }

    @Override
    public String toString() {
        return "EstruturaLente {" +
                "id='" + this.getId() + "\'" +
                "tipoCorrecao='" + tipoCorrecao + "\'" +
                "distanciaPupila='" + distanciaPupila + "\'" +
                "idReceitaOculos='" + idReceitaOculos + "\'" +
                '}';
    }
}
