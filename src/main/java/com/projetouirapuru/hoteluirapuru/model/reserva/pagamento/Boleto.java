package com.projetouirapuru.hoteluirapuru.model.reserva.pagamento;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Boleto extends MetodoPagamento{
    private String numero;
    private LocalDate dataValidade;
    private double valor;

    public Boleto(LocalDate dataValidade, double valor) {
        this.dataValidade = dataValidade;
        this.valor = valor;
        setNumero(dataValidade, valor);
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public double getValor() {
        return valor;
    }

    private void setNumero(LocalDate dataValidade, double valor) {
        LocalDate dataBase = LocalDate.of(1997, 10,7);
        long data = ChronoUnit.DAYS.between(dataBase, dataValidade);
        String preco = (((valor * 100)) / Math.pow(10, 10)) +"";
        this.numero = data+preco;
    }
}
