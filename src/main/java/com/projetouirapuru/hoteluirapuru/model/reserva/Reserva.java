package com.projetouirapuru.hoteluirapuru.model.reserva;



import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Acompanhante;
import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Hospede;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reserva {

    private String codigo;
    private Hospede hospedePrincipal;
    private ArrayList<Acompanhante> acompanhantes;
    private TipoQuarto tipoQuarto;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private LocalDateTime dataChegada;
    private LocalDateTime dataSaida;
    private double precoEstadia;

    public Reserva(String codigo, Hospede hospedePrincipal, ArrayList<Acompanhante> acompanhantes, TipoQuarto tipoQuarto, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.codigo = codigo;
        this.hospedePrincipal = hospedePrincipal;
        this.acompanhantes = acompanhantes;
        this.tipoQuarto = tipoQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getCodigo() {
        return codigo;
    }

    public Hospede getHospedePrincipal() {
        return hospedePrincipal;
    }

    public ArrayList<Acompanhante> getAcompanhantes() {
        return acompanhantes;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public LocalDateTime getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(LocalDateTime dataChegada) {
        this.dataChegada = dataChegada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public double getPrecoEstadia(){

        // (dia da saida - dia da checkin) -> dia saida < (dia checkout - dia checkin) -> * preco do quarto

        return -1;
    }


}
