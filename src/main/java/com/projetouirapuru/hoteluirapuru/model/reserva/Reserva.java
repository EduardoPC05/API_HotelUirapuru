package com.projetouirapuru.hoteluirapuru.model.reserva;



import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Acompanhante;
import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Cliente;
import com.projetouirapuru.hoteluirapuru.model.pessoa.clientes.Hospede;
import com.projetouirapuru.hoteluirapuru.model.reserva.pagamento.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Reserva {

    private Cliente hospedePrincipal;
    private int qtdAcompanhantes;
    private ArrayList<Acompanhante> acompanhantes;
    private TipoQuarto tipoQuarto;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private LocalDateTime horarioChegada;
    private LocalDateTime horarioSaida;
    private double precoDiaria;
    private MetodoPagamento pagamento;
    private TipoPagamento tipoPagamento;




    public Reserva(Cliente hospedePrincipal, int qtdAcompanhantes,TipoQuarto tipoQuarto, LocalDate checkIn, LocalDate checkOut) {
        this.hospedePrincipal = hospedePrincipal;
        this.qtdAcompanhantes = qtdAcompanhantes;
        this.tipoQuarto = tipoQuarto;
        this.checkIn = LocalDateTime.of(checkIn,LocalTime.of(9,0,0)); // Horário minimo para dar entrada no hotel
        this.checkOut = LocalDateTime.of(checkOut,LocalTime.of(12,0,0)); // Horário maximo para sair do hotel
        this.acompanhantes = null;
        this.pagamento = new MetodoPagamento();
        this.tipoPagamento = null;
        this.horarioChegada = null;
        this.horarioSaida = null;
        calculaPrecoDiaria(tipoQuarto);

    }

    public void addAcompanhantes(Acompanhante acompanhante) {
        acompanhantes.add(acompanhante);
    }

    public void removeAcompanhantes(String nome){
        if(acompanhantes != null){
            for (Acompanhante ac : acompanhantes){
                if (ac.getNome() == nome){
                    acompanhantes.remove(ac);
                }
            }
        }
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public Cliente getHospedePrincipal() {
        return hospedePrincipal;
    }

    public int getQtdAcompanhantes() {
        return qtdAcompanhantes;
    }

    public ArrayList<Acompanhante> getAcompanhantes() {
        return acompanhantes;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setHospedePrincipal(Cliente hospedePrincipal) {
        this.hospedePrincipal = hospedePrincipal;
    }

    public boolean getReservaAtiva(){
        if (hospedePrincipal instanceof Hospede){
            return true;
        }
        return false;
    }

    public MetodoPagamento getPagamento() {
        return pagamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public LocalDateTime getHorarioChegada() {
        return horarioChegada;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public double getPrecoEstadia(){
        if(getHorarioChegada() != null && getHorarioSaida() != null){
            long retorno = ChronoUnit.DAYS.between(getHorarioChegada(), getHorarioSaida());
            long periodoCorreto = ChronoUnit.DAYS.between(getCheckIn(), getCheckOut());
            if(retorno > periodoCorreto){
                long plus = ChronoUnit.DAYS.between(getHorarioSaida(), getCheckOut());
                retorno += plus;
            }
            double valor = retorno * getPrecoDiaria();
            return valor;
        }
        return -1;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPagamentoCartao(String nome, String numero, int cvv, int mesValidade, int anoValidade) {
        this.pagamento = new Cartao(nome, numero, cvv, mesValidade, anoValidade);
    }

    public void setPagamentoBoleto(LocalDate dataValidade, double valor) {
        this.pagamento = new Boleto(dataValidade, valor);
    }

    public void setPagamentoCheque(String nomeBeneficiario) {
        this.pagamento = new Cheque(nomeBeneficiario);
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void setHorarioChegada(LocalDateTime horarioChegada) {
        this.horarioChegada = horarioChegada;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    private void calculaPrecoDiaria(TipoQuarto tipoQuarto){
        switch (tipoQuarto){
            case NORMAL:
                precoDiaria = 100.00;
                break;
            case SUITE:
                precoDiaria = 150.00;
                break;
            case LUXO:
                precoDiaria = 250.00;
                break;
        }
    }
}
