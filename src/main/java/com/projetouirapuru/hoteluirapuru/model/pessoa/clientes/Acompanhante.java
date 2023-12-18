package com.projetouirapuru.hoteluirapuru.model.pessoa.clientes;

import com.projetouirapuru.hoteluirapuru.model.pessoa.Pessoa;
import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.InfosBasicas;

public class Acompanhante extends Pessoa {
    public Acompanhante(String nome, InfosBasicas infos) {
        super(nome, infos);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public InfosBasicas getInfosBasicas() {
        return super.getInfosBasicas();
    }
}
