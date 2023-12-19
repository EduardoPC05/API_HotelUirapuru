package com.projetouirapuru.hoteluirapuru.model.reserva;


import java.util.ArrayList;

public class Acomodacao {

    private String codigo;
    private String andar;
    private String numero;
    private String descricao;
    private TipoQuarto tipoQuarto;
    private ArrayList<Reserva> reservas;
    private int limiteAdultos;

    private int limiteCriancas;
    private double precoDiaria;


    public Acomodacao(String andar, String numero, String descricao, TipoQuarto tipoQuarto) {
        this.andar = andar;
        this.numero = numero;
        this.descricao = descricao;
        this.tipoQuarto = tipoQuarto;
        this.reservas = new ArrayList<Reserva>();
        setPrecoDiaria(tipoQuarto);
        setCodigo(andar, numero);
        setQtdpessoas(tipoQuarto);
    }

    public Acomodacao() {
    }

    private void setPrecoDiaria(TipoQuarto tipoQuarto){
        switch (tipoQuarto){
            case NORMAL:
                precoDiaria = 100;
                break;
            case SUITE:
                precoDiaria = 200;
                break;
            case LUXO:
                precoDiaria = 300;
                break;
        }
    }

    private void setQtdpessoas(TipoQuarto tipoQuarto){
        switch (tipoQuarto){
            case NORMAL:
                limiteAdultos = 2;
                limiteCriancas = 1;
                break;
            case SUITE, LUXO:
                limiteAdultos = 3;
                limiteCriancas = 2;
                break;
        }
    }

    private void setCodigo(String andar, String numero){
        codigo = andar + numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getAndar() {
        return andar;
    }

    public String getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public int getLimiteAdultos() {
        return limiteAdultos;
    }

    public int getLimiteCriancas() {
        return limiteCriancas;
    }

    public void addReserva(Reserva novo){
        this.reservas.add(novo);
    }

    public void removeReserva(Reserva excluir){
        this.reservas.remove(excluir);
    }
    public boolean verificaReserva(Reserva nova){
        if(!reservas.isEmpty()) {
            for (Reserva r : getReservas()){
                if (r.getCheckIn().isBefore(nova.getCheckOut()) &&
                        r.getCheckOut().isAfter(nova.getCheckIn())) {
                    return false;
                }
            }
        }
        return true;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void setLimiteAdultos(int limiteAdultos) {
        this.limiteAdultos = limiteAdultos;
    }

    public void setLimiteCriancas(int limiteCriancas) {
        this.limiteCriancas = limiteCriancas;
    }
}
