package com.projetouirapuru.hoteluirapuru.model.pessoa;


import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.Documento;
import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.InfosBasicas;

public abstract class Pessoa {
    private String nome;
    private InfosBasicas infosBasicas;

    public Pessoa(String nome, InfosBasicas infosBasicas) {
        this.nome = nome;
        this.infosBasicas = infosBasicas;
    }

    public void setInfosBasicas(InfosBasicas infosBasicas) {
        this.infosBasicas = infosBasicas;
    }

    public String getNome() {
        return nome;
    }

    public InfosBasicas getInfosBasicas() {
        return infosBasicas;
    }

    public Boolean hasDocumento(InfosBasicas infosBasicas){
        return infosBasicas instanceof Documento;
    }

    public InfosBasicas getDocumento(InfosBasicas documento){
        if(hasDocumento(documento)){
            if(infosBasicas instanceof Documento){
                return documento;
            }
        }
        return null;
    }
}
