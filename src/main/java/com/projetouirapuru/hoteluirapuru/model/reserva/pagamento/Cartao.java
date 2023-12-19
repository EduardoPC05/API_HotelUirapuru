package com.projetouirapuru.hoteluirapuru.model.reserva.pagamento;

import java.time.LocalDate;

public class Cartao {
    private String nome;
    private String numero;
    private int cvv;
    private LocalDate validade;

    public Cartao(String nome, String numero, int cvv, int mesValidade, int anoValidade) {
        this.nome = nome;
        this.numero = numero;
        this.cvv = cvv;
        this.validade = LocalDate.of(anoValidade, mesValidade, 1);
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public int getCvv() {
        return cvv;
    }

    public LocalDate getValidade() {
        return validade;
    }
}
