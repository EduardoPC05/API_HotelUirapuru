package com.projetouirapuru.hoteluirapuru.model.pessoa.clientes;

import com.projetouirapuru.hoteluirapuru.model.pessoa.Pessoa;
import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.Documento;
import com.projetouirapuru.hoteluirapuru.model.pessoa.endereco.Endereco;
import com.projetouirapuru.hoteluirapuru.model.pessoa.login.InfoLogin;


public class Hospede extends Pessoa {
    private Endereco endereco;
    private String telefone;
    private InfoLogin infoLogin;


    public Hospede(String nome, Documento documento, Endereco endereco, String telefone, InfoLogin infoLogin) {
        super(nome, documento);
        this.endereco = endereco;
        this.telefone = telefone;
        this.infoLogin = infoLogin;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public InfoLogin getInfoLogin() {
        return infoLogin;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public Documento getDocumento() {
        return super.getDocumento();
    }
}
