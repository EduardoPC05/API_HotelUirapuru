package com.projetouirapuru.hoteluirapuru.model.pessoa.clientes;


import com.projetouirapuru.hoteluirapuru.model.pessoa.Pessoa;
import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.InfosBasicas;
import com.projetouirapuru.hoteluirapuru.model.pessoa.login.InfoLogin;

public class Cliente extends Pessoa {
    private InfoLogin infoLogin;

    public Cliente(String nome, InfosBasicas infosBasicas, InfoLogin infoLogin) {
        super(nome, infosBasicas);
        this.infoLogin = infoLogin;
    }

    public InfoLogin getInfoLogin() {
        return infoLogin;
    }
}
