package com.projetouirapuru.hoteluirapuru.model.pessoa.documento;



import java.time.LocalDate;

public class Documento extends InfosBasicas {
    protected String nomePai;
    protected String nomeMae;
    protected LocalDate dataNascimento;
    private String nacionalidade;

    public Documento(InfosBasicas infos, String nomePai, String nomeMae, LocalDate dataNascimento, String nacionalidade) {
        super(infos.getTipoDocumento(), infos.getNumeroDocumento());
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
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

}