package com.projetouirapuru.hoteluirapuru.model.pessoa;


import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.Documento;

public abstract class Pessoa {
    private String nome;
    private Documento documento;

    public Pessoa(String nome, Documento documnto) {
        this.nome = nome;
        this.documento = documnto;
    }

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

}
