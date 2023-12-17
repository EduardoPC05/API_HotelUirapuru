package com.projetouirapuru.hoteluirapuru.model.pessoa.clientes;

import com.projetouirapuru.hoteluirapuru.model.pessoa.Pessoa;
import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.Documento;
import com.projetouirapuru.hoteluirapuru.model.pessoa.login.InfoLogin;


public class Cliente extends Pessoa {
    private InfoLogin infoLogin;

    public Cliente(String nome, Documento documento, InfoLogin infoLogin) {
        super(nome, documento);
        this.infoLogin = infoLogin;
    }

    public InfoLogin getInfoLogin() {
        return infoLogin;
    }
}
