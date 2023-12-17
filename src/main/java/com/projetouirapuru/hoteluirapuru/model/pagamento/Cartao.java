package com.projetouirapuru.hoteluirapuru.model.pagamento;

import java.time.LocalDate;
import java.time.Period;

public class Cartao implements MetodosPagamento {
    private long numeroCartao;
    private String nome;

    private int cvv;

    private LocalDate dataValidade;

    public Cartao(long numeroCartao, String nome, int cvv, LocalDate dataValidade) {
        this.numeroCartao = numeroCartao;
        this.nome = nome;
        this.cvv = cvv;
        this.dataValidade = dataValidade;
    }

    public long getNumeroCartao() {
        return numeroCartao;
    }

    public String getNome() {
        return nome;
    }

    public int getCvv() {
        return cvv;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }
}
