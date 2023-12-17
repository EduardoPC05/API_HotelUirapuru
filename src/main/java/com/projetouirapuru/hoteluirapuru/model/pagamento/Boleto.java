package com.projetouirapuru.hoteluirapuru.model.pagamento;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Boleto implements MetodosPagamento {
    private double valor;
    private LocalDate vencimento;

    private String codigo;

    public Boleto(double valor) {
        this.valor = valor;
        this.vencimento = LocalDate.now().plusDays(30);
        this.codigo = gerarCodigo();
    }
    private String gerarCodigo(){
        long valor = (long) (getValor()*100);
        long day = ChronoUnit.DAYS.between(INICIOBOLETO,getVencimento());

        day = (long) (day * (Math.pow(10,10)));
        return day + valor+" ";
    }


    public double getValor() {
        return valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public String getCodigo() {
        return codigo;
    }
}
