package com.projetouirapuru.hoteluirapuru.model.pessoa.funcionario;


import com.projetouirapuru.hoteluirapuru.model.pessoa.Pessoa;
import com.projetouirapuru.hoteluirapuru.model.pessoa.documento.Documento;
import com.projetouirapuru.hoteluirapuru.model.pessoa.login.InfoLogin;
import com.projetouirapuru.hoteluirapuru.model.reserva.Reserva;

public class Funcionario extends Pessoa {
    private InfoLogin infoLogin;
    private Reserva reservaResponsavel;

    public Funcionario(String nome, Documento documento, InfoLogin infoLogin, Reserva reservaResponsavel) {
        super(nome, documento);
        this.infoLogin = infoLogin;
        this.reservaResponsavel = reservaResponsavel;
    }
    public Funcionario(){};

    public InfoLogin getInfoLogin() {
        return infoLogin;
    }

    public Reserva getReservaResponsavel() {
        return reservaResponsavel;
    }

    public Funcionario(String nome, Documento documento) {
        super(nome, documento);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public Documento getDocumento() {
        return super.getDocumento();
    }

    public void setInfoLogin(InfoLogin infoLogin) {
        this.infoLogin = infoLogin;
    }

    public void setReservaResponsavel(Reserva reservaResponsavel) {
        this.reservaResponsavel = reservaResponsavel;
    }
}
