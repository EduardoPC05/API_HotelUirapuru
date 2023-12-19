package com.projetouirapuru.hoteluirapuru.model.pessoa.documento;



import java.time.LocalDate;

public class Documento {
    protected String nomePai;
    protected String nomeMae;
    protected LocalDate dataNascimento;
    private String nacionalidade;
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;

    public Documento(String nomePai, String nomeMae, LocalDate dataNascimento, String nacionalidade, TipoDocumento tipoDocumento, String numeroDocumento) {
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
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

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }
}