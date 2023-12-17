package com.projetouirapuru.hoteluirapuru.model.pessoa.endereco;

public class Endereco {
    private String estado;
    private String cidade;
    private String rua;
    private String numero;
    private String bairro;

    public Endereco(String estado, String cidade, String rua, String numero, String bairro) {
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }
}
