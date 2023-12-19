package com.projetouirapuru.hoteluirapuru.model.reserva;



import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Acompanhante;
import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Hospede;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Reserva {

    private String codigoAcomodacao;
    private Hospede hospedePrincipal;
    private ArrayList<Acompanhante> acompanhantes;
    private TipoQuarto tipoQuarto;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private LocalDateTime dataChegada;
    private LocalDateTime dataSaida;
    private double precoEstadia;

    public Reserva(String codigoAcomodacao, Hospede hospedePrincipal, ArrayList<Acompanhante> acompanhantes, TipoQuarto tipoQuarto, LocalDate checkIn, LocalDate checkOut) {
        this.codigoAcomodacao = codigoAcomodacao;
        this.hospedePrincipal = hospedePrincipal;
        this.acompanhantes = acompanhantes;
        this.tipoQuarto = tipoQuarto;
        this.checkIn = LocalDateTime.of(checkIn, LocalTime.of(12,0,0));
        this.checkOut = LocalDateTime.of(checkOut,LocalTime.of(9,0,0));
    }
    public Reserva(){}

    public String getCodigoAcomodacao() {
        return codigoAcomodacao;
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
           if (isAtiva()){
               getDataSaida()  - getCheckIn()
           }
        // (dia da saida - dia da checkin) -> dia saida < (dia checkout - dia checkin) -> * preco do quarto

        return -1;
    }

    public boolean isAtiva(){
        return getDataChegada() == null;
    }

    public void setCodigoAcomodacao(String codigoAcomodacao) {
        this.codigoAcomodacao = codigoAcomodacao;
    }

    public void setHospedePrincipal(Hospede hospedePrincipal) {
        this.hospedePrincipal = hospedePrincipal;
    }

    public void setAcompanhantes(ArrayList<Acompanhante> acompanhantes) {
        this.acompanhantes = acompanhantes;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
        isAtiva();
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

}
