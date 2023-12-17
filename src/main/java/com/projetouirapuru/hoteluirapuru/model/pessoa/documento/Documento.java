package com.projetouirapuru.hoteluirapuru.model.pessoa.documento;

import java.time.LocalDate;

public class Documento {
    protected String nomePai;
    protected String nomeMae;
    protected LocalDate dataNascimento;
    private String nacionalidade;
    private String numeroDoc;
    private TipoDocumento tipoDocumento;

    public Documento(String nomePai, String nomeMae, LocalDate dataNascimento, String nacionalidade, String numeroDoc, TipoDocumento tipoDocumento) {
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.numeroDoc = numeroDoc;
        this.tipoDocumento = tipoDocumento;
    }

    public String getNomePai() {
        return nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }
}