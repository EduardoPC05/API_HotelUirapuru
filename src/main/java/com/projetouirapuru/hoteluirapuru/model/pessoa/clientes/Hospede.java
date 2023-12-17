package com.projetouirapuru.hoteluirapuru.model.pessoa.clientes;

import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Cliente;
import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.Documento;
import com.projetouirapuru.hoteluirapuru.model.pessoa.endereco.Endereco;
import com.projetouirapuru.hoteluirapuru.model.pessoa.login.InfoLogin;


public class Hospede extends Cliente {
    private Endereco endereco;
    private String telefone;

    public Hospede(Cliente cliente, Endereco endereco, String telefone) {
        super(cliente.getNome(), cliente.getDocumento(), cliente.getInfoLogin());
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public InfoLogin getInfoLogin() {
        return super.getInfoLogin();
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public Documento getDocumento() {
        return super.getDocumento();
    }
}
