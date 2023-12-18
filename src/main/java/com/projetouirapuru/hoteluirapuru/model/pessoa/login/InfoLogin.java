package com.projetouirapuru.hoteluirapuru.model.pessoa.login;

public class InfoLogin {
    private String email;
    private String senha;
    private TipoLogin tipoLogin;

    public InfoLogin(String email, String senha, TipoLogin tipoLogin) {
        this.email = email;
        this.senha = senha;
        this.tipoLogin = tipoLogin;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public TipoLogin getTipoLogin() {
        return tipoLogin;
    }
}
