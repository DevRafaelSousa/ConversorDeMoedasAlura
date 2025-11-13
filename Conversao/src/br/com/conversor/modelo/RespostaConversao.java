package br.com.conversor.modelo;

import com.google.gson.annotations.SerializedName;

public class RespostaConversao {

    @SerializedName("conversion_rate")
    private double taxaConversao;

    @SerializedName("conversion_result")
    private double resultadoConversao;

    @SerializedName("base_code")
    private String moedaBase;

    @SerializedName("target_code")
    private String moedaAlvo;

    public double getTaxaConversao() {
        return taxaConversao;
    }

    public double getResultadoConversao() {
        return resultadoConversao;
    }

    public String getMoedaBase() {
        return moedaBase;
    }

    public String getMoedaAlvo() {
        return moedaAlvo;
    }

    @Override
    public String toString() {
        return "RespostaConversao{" +
                "moedaBase='" + moedaBase + '\'' +
                ", moedaAlvo='" + moedaAlvo + '\'' +
                ", taxaConversao=" + taxaConversao +
                ", resultadoConversao=" + resultadoConversao +
                '}';
    }
}